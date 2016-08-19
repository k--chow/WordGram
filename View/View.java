package View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;
import Model.*;

public class View {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private MyKeyListener listener;
    private Model model;

    public View(MyKeyListener listener, Model model) {
        this.listener = listener;
        this.model = model;
        begin();
        showEditor();
    }

    private void begin()
    {
        mainFrame = new JFrame("WordGram");
        mainPanel = new JPanel(new BorderLayout());
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
        System.exit(0);
        }        
        });    
    }

    public void showEditor()
    {
        JTextArea editor = new JTextArea(5, 40);
        editor.addKeyListener(this.listener);
        mainPanel.add(editor);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}


