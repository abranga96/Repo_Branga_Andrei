package zoowsome.views.utilities;

import zoowsome.views.ZooFrame;

import java.util.ArrayList;

/**
 * Created by abran on 18.12.2016.
 */

public class FrameStack
{
    private static  FrameStack instance;
    private ArrayList<ZooFrame> stack;

    private FrameStack()
    {
        stack=new ArrayList<ZooFrame>();
    }

    public static FrameStack getInstance()
    {
        if(instance==null)
        {
            instance=new FrameStack();
        }
        return instance;
    }

    public ZooFrame peek()
    {
        return stack.get(0);
    }

    public void push(ZooFrame frame)
    {
        if(!stack.isEmpty())
        {
            peek().setVisible(false);
        }
        frame.setVisible(true);
        stack.add(0,frame);
    }

    public void pop()
    {
        if(!stack.isEmpty())
        {
            peek().dispose();
            stack.remove(0);
            if(!stack.isEmpty())
            {
                peek().setVisible(true);
            }
        }
    }

}
