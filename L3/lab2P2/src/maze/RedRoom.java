package maze;

import java.awt.Color;

public class RedRoom extends Room{
    public RedRoom(int num)
    {
        super(num);
    }

    @Override
    public Color getColor()
    {
        return Color.PINK; //Light red or pink?
    }
}