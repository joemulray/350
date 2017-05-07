package maze;

/**
 * Created by josephmulray on 5/7/17.
 */
public class RedMazeFactory extends MazeGameAbstractFactory implements MazeFactory{
    public Room createRoom(int num){
        //return red rooms
        return new RedRoom(num);
    }

    public Wall createWall(){
        //return red walls
        return new RedWall();
    }

    public Door createDoor(Room room1, Room room2){
        return new Door(room1, room2);
    }
}
