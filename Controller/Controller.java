package Controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import Model.*;
import View.*;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
      this.model = model;
      this.view = view;

      //listeners
      view.addCompletionListener(new MyDocumentListener(model));
    }


}
