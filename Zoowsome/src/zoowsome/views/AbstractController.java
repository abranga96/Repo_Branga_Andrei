package zoowsome.views;

import zoowsome.views.utilities.FrameStack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by abran on 18.12.2016.
 */
public class AbstractController
{
    protected ZooFrame frame;

    public AbstractController(ZooFrame frame, boolean hasBackButton)
    {
        this.frame=frame;
        if(hasBackButton)
        {
            frame.setBackButtonActionListener(new BackButtonListener());

        }
    }

    private class BackButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameStack.getInstance().pop();
        }
    }
}
