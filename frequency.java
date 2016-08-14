import java.util.*;

public class Frequency
{
    private static Frequency freq = new Frequency();
    public HashMap<String, Double> hm = new HashMap<String, Double>();
    private Double total = 0.0;
    private Frequency(){};

    public static Frequency getInstance() {
        return freq;
    }

    public Double getFrequency(String word)
    {
        if (hm.containsKey(word)) {
            return hm.get(word)/total;
        }
        return 0.0;
    }

    public void update(String word)
    {
        if (hm.containsKey(word)) {
            hm.put(word, hm.get(word) + 1.0);
        } else {
            hm.put(word, 1.0);
        }
        total++;
    }



    
}
