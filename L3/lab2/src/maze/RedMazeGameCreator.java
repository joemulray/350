package maze;

/**
 * Created by josephmulray on 5/7/17.
 */
public class RedMazeGameCreator extends MazeGameCreator{
    public RedMazeGameCreator(){}

    public Room createRoom(int num){
        //return red rooms
        return new RedRoom(num);
    }

    public Wall createWall(){
        //return red walls
        return new RedWall();
    }

}
