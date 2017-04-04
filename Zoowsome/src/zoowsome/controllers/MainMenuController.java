package zoowsome.controllers;

import zoowsome.views.AbstractController;
import zoowsome.views.AddFrame;
import zoowsome.views.MainMenuFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by abran on 18.12.2016.
 */
public class MainMenuController extends AbstractController
{
    public MainMenuController(MainMenuFrame frame, boolean hasBackButton)
    {
        super(frame,hasBackButton);
        frame.setAddButtonActionListener(new AddButtonActionListener());
    }

    private class AddButtonActionListener implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent e) {
            new AddController(new AddFrame("Add"),true);
        }
    }
}
