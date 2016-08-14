import java.util.*;

public class AdjacencyList
{
    private static AdjacencyList list = new AdjacencyList();
    private HashMap<String, HashSet<String> > hm = new HashMap<String, HashSet<String> >();
    private Frequency freq = Frequency.getInstance();
    private Bifrequency bifreq = Bifrequency.getInstance();
    public AdjacencyList(){};

    public static AdjacencyList getInstance() {
        return list;
    }

    public void update(String previous, String word)
    {
        if (hm.containsKey(previous))
        {
            hm.get(previous).add(word);
            //System.out.println(hm.get(previous)); 
        } else {
            hm.put(previous, new HashSet<String> ());
                    }
    }
    
    public String getNextWord(String previous)
    {
        if (!hm.containsKey(previous))
        {
            return null;
        }

        Double highestProbability = 0.0;
        String nextWord = "";
        for(String candidate: hm.get(previous))
        {
            Double andProbability = bifreq.getBifrequency(previous + " " + candidate);
            Double individualProbability = freq.getFrequency(candidate);
            Double finalProbability = andProbability/individualProbability;
            if (finalProbability > highestProbability)
            {
                nextWord = candidate;
                finalProbability = highestProbability;
            }
        }
        return nextWord;

    }
}
