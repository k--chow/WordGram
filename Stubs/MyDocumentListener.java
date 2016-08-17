import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.Element;;

public class MyDocumentListener implements DocumentListener
{
    
    @Override
    public void insertUpdate(DocumentEvent e)
    {
        Document documentSource = e.getDocument();
        Element rootElement = documentSource.getDefaultRootElement();
        DocumentEvent.ElementChange change = e.getChange(rootElement);
        System.out.println("Change: " + change);

    }
    @Override
    public void removeUpdate(DocumentEvent e)
    {
        System.out.println(e);
    }
    @Override
    public void changedUpdate(DocumentEvent e)
    {
        System.out.println(e);
    }
}
