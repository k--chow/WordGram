import java.util.*;

public class Bifrequency
{
    private static Bifrequency bf = new Bifrequency();
    private HashMap<String, Double> hm = new HashMap<String, Double>();
    private Double total = 0.0;
    public Bifrequency(){};
 
    public static Bifrequency getInstance() {
        return bf;
    }

    public void update(String pair)
    {
        if (hm.containsKey(pair))
        {
            hm.put(pair, hm.get(pair) + 1);
        } else {
            hm.put(pair, 1.0);
        }
        total++;
    }

    public Double getBifrequency(String pair)
    {
        if (hm.containsKey(pair))
        {
            return hm.get(pair)/total;

        }
        return 0.0;
    }

}
