package zoowsome.views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import com.intellij.psi.impl.source.Constants;
import zoowsome.views.utilities.FrameStack;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import static com.intellij.execution.testframework.ui.TestsProgressAnimator.FRAMES;
import javax.swing.border.EmptyBorder;
/**
 * Created by abran on 18.12.2016.
 */
public abstract class ZooFrame extends JFrame implements ZooFrame_I
{
    protected  JPanel contentPanel;
    public static final int HEIGHT = 500;   public static final int WIDTH = 700;
    public ZooFrame(String title)
    {
        FrameStack.getInstance().push(this);
        setTitle(title);
        setSize(WIDTH,HEIGHT);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPanel=new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        contentPanel.setBackground(Color.red);
        add(contentPanel,BorderLayout.CENTER);
    }

    public void setBackButtonActionListener(ActionListener a)
    {
        JPanel buttonPanel=new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        buttonPanel.add(backButton);
        this.add(buttonPanel,BorderLayout.NORTH);
        backButton.addActionListener(a);
    }


    @Override
    public void goBack() {

    }
}
