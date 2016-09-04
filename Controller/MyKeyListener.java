package Controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import Model.*;
import View.*;

public class MyKeyListener implements KeyListener
{
        private Model model;
        public MyKeyListener(Model model)
        {
            this.model = model;
        }

        private String word = "";
        public void keyPressed(KeyEvent e){
        if (e.getKeyCode() != KeyEvent.VK_SPACE){
          word += (char)e.getKeyCode();
        } else {
          word = word.toLowerCase();
          String newWord = model.getWord(word.toLowerCase());
          System.out.println(word + " " + newWord);
          if (newWord != null)
          {/* For EventDispatchThread
            SwingUtilities.invokeLater(
                        new CompletionTask(newWord, pos + 1));
            }*/
            SwingUtilities.invokeLater(new View.CompletionTask(newWord));
          }
          word = "";
        }

       }

        public void keyTyped(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
        }

}
