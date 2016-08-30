package Controller;
import javax.swing.*;

public class MyDocumentListener implements DocumentListener {
    public void insertUpdate(DocumentEvent e) {
      if (e.getLength() != 1) {
            return;
        }
    }

    public void removeUpdate(DocumentEvent e) {
    }
    public void changedUpdate(DocumentEvent e) {
    }
}
