package View;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import javax.swing.*;
import Model.*;
import View.*;

public class MyDocumentListener implements DocumentListener{
    private Model model;
    private View view;
    public MyDocumentListener(Model model, View view) {
      this.model = model;
      this.view = view;
    }
    public void insertUpdate(DocumentEvent e) {
      if (e.getLength() != 1) {
            return;
      }
      int pos = e.getOffset();
      String line = "";
      try {
        line = e.getDocument().getText(0, pos+1);
      } catch (Exception ex) {

      }

      //if space
      String last = line.substring(line.length()-1);
      String lastWord;
      String newWord;
      if (last.trim().length() == 0) {
        int i = line.length()-2;
        while(line.substring(i, i+1).trim().length() != 0 && i > 0) {
          i--;
        }
        lastWord = line.substring(i+1, line.length()-1);
        newWord = model.getWord(lastWord);
        System.out.println(lastWord + " " + newWord);
        if (newWord != null) {
          view.autocompleteTask(newWord, pos + 1);
        }
      } else if (view.getStatus()){
        int i = line.length()-1;
        int j;
        while(line.substring(i, i+1).trim().length() != 0 && i > 0) {
          i--;
        }
        j = line.length() - i;
        view.wordcompleteTask(i+2, j);
      }

      //else autocomplete
      //remove actual word
      //get offset position

      //get line, find previous word

      //use model

    }

    public void removeUpdate(DocumentEvent e) {
    }
    public void changedUpdate(DocumentEvent e) {
    }
}
