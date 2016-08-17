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
        System.out.println(model.getWord("sherlock"));
        View view = new View();
        //View(Model)
        //Controller(Model, View)
    }
}
