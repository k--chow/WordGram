package View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;
import Model.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class View {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private Model model;
    private JTextArea editor;
    private boolean completion;
    private int caretPosition;
    private Highlighter highlight;
    private HighlightPainter painter;

    public View(Model model) {
        this.model = model;
        begin();
        showEditor();
        completion = false;
        this.highlight = editor.getHighlighter();
        this.painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);

        InputMap input = editor.getInputMap();
        ActionMap action = editor.getActionMap();
        input.put(KeyStroke.getKeyStroke("ENTER"), "Completion");
        action.put("Completion", new CommitCompletion());
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

    public void autocompleteTask(String completion, int pos) {
      SwingUtilities.invokeLater(new CompletionTask(completion, pos));
    }

    public void wordcompleteTask(int pos, int len) {
      SwingUtilities.invokeLater(new SecondaryCompletionTask(pos, len));
    }

    public boolean getStatus() {
      return completion;
    }

    public class CommitCompletion extends AbstractAction {
      public void actionPerformed(ActionEvent e) {
        if (View.this.completion) {
          View.this.highlight.removeAllHighlights();
          editor.setCaretPosition(View.this.caretPosition);
          View.this.completion = false;
        }
      }

    }

    public class CompletionTask implements Runnable {
      int pos;
      String completion;


      public CompletionTask(String completion, int pos)
      {
        this.pos = pos;
        this.completion = completion;
        View.this.completion = true;
      }

      public void run()
      {
          View.this.editor.insert(completion, pos);
          editor.setCaretPosition(pos);
          int endPos = pos + completion.length();
          View.this.caretPosition = endPos;
          View.this.completion = true;
          try {

            highlight.addHighlight(pos, endPos, painter);
          } catch (Exception ex) {
            System.out.println("Exception: " + ex);
          }
      }
    }

    public class SecondaryCompletionTask implements Runnable {
      int pos;
      int length;
      public SecondaryCompletionTask(int pos, int length) {
        this.pos = pos;
        this.length = length;
        View.this.completion = false;
      }
      //remove highlighting
      //remove word
      public void run()
      {

          try {
            View.this.editor.getDocument().remove(pos, length);
            editor.setCaretPosition(pos);
            highlight.removeAllHighlights();
            System.out.println(length);
          } catch (Exception ex) {
            System.out.println("Exception: " + ex);
          }
      }
    }
}
