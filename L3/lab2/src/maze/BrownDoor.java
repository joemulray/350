package maze;

import java.awt.Color;

public class BrownDoor extends Door
{
    public BrownDoor(Room r1, Room r2)
    {
        super(r1, r2);
    }

    @Override
    public Color getColor()
    {
        Color brown = new Color(205,133,63); //peru brown
        return brown;
    }
}