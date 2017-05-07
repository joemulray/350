package maze;

/**
 * Created by josephmulray on 5/7/17.
 */
public interface MazeFactory {
    public abstract Wall createWall();
    public abstract Room createRoom(int num);
    public abstract Door createDoor(Room room1, Room room2);
}
