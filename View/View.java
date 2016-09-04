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
    private Model model;
    private static JTextArea editor;

    public View(Model model) {
        this.model = model;
        begin();
        showEditor();
    }

    private void begin()
    {
        mainFrame = new JFrame("WordGram");
        mainPanel = new JPanel(new BorderLayout());
        mainFrame.setSize(600, 600);
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
        System.exit(0);
        }
        });
    }

    public void showEditor()
    {
        editor = new JTextArea(40, 40);
        JScrollPane scrollPane = new JScrollPane(editor);
        editor.setLineWrap(true);
        editor.setBackground(Color.BLACK);
        editor.setForeground(Color.WHITE);
        editor.setCaretColor(Color.WHITE);
        scrollPane.setBackground(Color.BLACK);
        mainPanel.add(scrollPane);
        //mainPanel.add(editor, BorderLayout.CENTER);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    public void addCompletionListener(MyDocumentListener listener)
    {
      editor.getDocument().addDocumentListener(listener);
    }

    public static class CompletionTask implements Runnable {
      int pos;
      String completion;

      public CompletionTask(String completion, int pos)
      {
        this.pos = pos;
        this.completion = completion;
      }

      public void run()
      {
          editor.insert(completion, pos);
      }
    }
}
