import java.util.*;
import java.io.*;

class State
{
    private String word;
    private double individualProbability;

    public State (String word, double individualProbability)
    {
        this.word = word;
        this.individualProbability = individualProbability;
    }

    public String getWord()
    {
        return this.word;
    }

    public Double getProbability()
    {
        return this.individualProbability;
    }

    

}
