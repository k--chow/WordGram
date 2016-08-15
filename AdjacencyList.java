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
        Double totalFrequency = 0.0;
        for(String candidate: hm.get(previous))
        {
            totalFrequency += bifreq.getBifrequency(previous + " " + candidate);
        }
        for(String candidate: hm.get(previous))
        {
            Double probability = bifreq.getBifrequency(previous + " " + candidate)/totalFrequency;

            if (probability > highestProbability)
            {
                nextWord = candidate;
                highestProbability = probability;
            }
        }
        System.out.println(highestProbability);
        return nextWord;

    }
}
