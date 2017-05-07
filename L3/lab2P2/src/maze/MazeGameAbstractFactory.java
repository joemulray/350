/*
 * SimpleMazeGame.java
 * Copyright (c) 2008, Drexel University.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Drexel University nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY DREXEL UNIVERSITY ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL DREXEL UNIVERSITY BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package maze;

import maze.ui.MazeViewer;
import java.io.*;
import java.util.*;

/**
 *
 * @author Sunny
 * @version 1.0
 * @since 1.0
 */
public class MazeGameAbstractFactory implements MazeFactory{



    //basic maze functions
    public Room createRoom(int num){ return new Room(num);}
    public Wall createWall(){ return new Wall();}
    public Door createDoor(Room room1, Room room2){ return new Door(room1, room2);}



    /**
     * Creates a small maze.
     */
    public Maze createMaze()
    {
        //Create new maze object.
        Maze maze = new Maze();
        Room room1 = new Room(0);
        Room room2 = new Room(1);

        maze.addRoom(room1);
        maze.addRoom(room2);


        //not setting a door leaving open space inbetween two doors.
        room1.setSide(Direction.West, createWall());
        room1.setSide(Direction.North, createWall());
        room1.setSide(Direction.South, createWall());
        room1.setSide(Direction.East, room2);

        room2.setSide(Direction.West, room1);
        room2.setSide(Direction.East, createWall());
        room2.setSide(Direction.North, createWall());
        room2.setSide(Direction.South, createWall());


        maze.setCurrentRoom(room1);

        return maze;


    }

    public static Maze loadMaze(final String path) throws IOException
    {
        //create list of rooms doors and sides to store when parsing file
        ArrayList<Room> rooms = new ArrayList<Room>();
        ArrayList<Door> doors = new ArrayList<Door>();
        Map<Room, ArrayList<String> > sides = new HashMap<Room, ArrayList<String> >();


        File file = new File(path);
        Scanner mazeFile = new Scanner(file);
        ArrayList<String> content = new ArrayList<String>();
        int roomNum,room1, room2;
        String doorNum;
        String [] object;
        ArrayList<String> totalSides = new ArrayList<String>();
        Direction points [] = {Direction.North, Direction.South, Direction.East, Direction.West};

        //load contents of file into arraylist for parsing.
        while(mazeFile.hasNext()){
            content.add(mazeFile.nextLine());
        }

        mazeFile.close();

        //Create all Rooms;
        for(String line: content) {
            object = line.split(" ");

            //if first object equals room, get sides create room
            if (object[0].equals("room")) {

                ArrayList<String> side = new ArrayList<String>();
                roomNum = Integer.parseInt(object[1]);

                Room room = new Room(roomNum);
                rooms.add(room);

                //adding side objects to add to arrraylist
                side.add(object[2]);
                side.add(object[3]);
                side.add(object[4]);
                side.add(object[5]);

                sides.put(room, side);
            }
        }


        //create all doors.
        for(String line2: content){
            object = line2.split(" ");

            //if object equals door create door and add connecting rooms.
            if(object[0].equals("door")){
                doorNum = object[1];
                room1 = Integer.parseInt(object[2]);
                room2 = Integer.parseInt(object[3]);

                Door door = new Door(rooms.get(room1), rooms.get(room2));

                //check status of door
                if(object[4].equals("close")){
                    door.setOpen(false);
                }
                else{ door.setOpen(true); }

                doors.add(door);
            }
        }

        //create new maze
        Maze maze = new Maze();


        //cycle through rooms list, and add walls
        for(Room room: rooms){
            totalSides = sides.get(room);

            //add all of the walls with attributes to maze.
            for(int index= 0; index < points.length; index++){

                String choice = totalSides.get(index);

                //if option is wall create wall vise versa for door and rooms
                if(choice.equals("wall")){
                    room.setSide(points[index], new Wall());
                }
                else if(choice.substring(0,1).equals("d")){
                    int doorSpot = Integer.parseInt(choice.substring(1));
                    Door sideDoor = doors.get(doorSpot);
                    room.setSide(points[index], sideDoor);
                }
                else{
                    Room sideRoom = rooms.get(Integer.parseInt(choice));
                    room.setSide(points[index], sideRoom);

                }
            }
            //add each room into maze.
            maze.addRoom(room);
        }

        //set the current room
        maze.setCurrentRoom(0);

        //return maze.
        return maze;
    }

    public static void main(String[] args) throws IOException
    {
        String param;

        if(args.length < 1){
            System.out.println("Please pass an input parameter ");
            System.exit(0);
        }
        else{

            param = args[0];

            if(param.equals("red")){
                //create red maze
                RedMazeFactory redMazeCreator = new RedMazeFactory();
                Maze redMaze = redMazeCreator.createMaze();
                MazeViewer viewer = new MazeViewer(redMaze);
                viewer.run();

            }
            else if(param.equals("blue")){
                //create blue maze
                BlueMazeFactory blueMazeCreator = new BlueMazeFactory();
                Maze blueMaze = blueMazeCreator.createMaze();
                MazeViewer viewer = new MazeViewer(blueMaze);
                viewer.run();

            }

            else{
                //create basic maze
                MazeGameAbstractFactory basicMazeCreator = new MazeGameAbstractFactory();
                Maze basicMaze = basicMazeCreator.createMaze();
                MazeViewer viewer = new MazeViewer(basicMaze);
                viewer.run();

            }

        }
    }
}
