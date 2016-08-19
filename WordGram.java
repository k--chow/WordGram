import java.util.*;
import Model.*;
import View.*;
import Controller.*;

public class WordGram
{
    public static void main(String[] args)
    {
        //Model()
        Model model = new Model();
        MyKeyListener listener = new MyKeyListener(model);
        View view = new View(listener, model);
        //View(Model)
        //Controller(Model, View)
    }
}
