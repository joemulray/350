package maze;

/**
 * Created by josephmulray on 5/7/17.
 */
public class BlueMazeFactory extends MazeGameAbstractFactory implements MazeFactory{

    public Room createRoom(int num){
        //return green room
        return new GreenRoom(num);
    }

    public Wall createWall(){
        //return blue walls
        return new BlueWall();
    }

    public Door createDoor(Room room1, Room room2){
        //return Brown door.
        return new BrownDoor(room1, room2);
    }
}
