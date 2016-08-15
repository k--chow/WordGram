import java.util.*;
import java.io.*;
import java.math.*;

public class sentence
{
    public static void main(String [] args) throws IOException
    {
        Frequency freq = Frequency.getInstance();
        Bifrequency bifreq = Bifrequency.getInstance();
        AdjacencyList list = AdjacencyList.getInstance();
        BufferedReader br = new BufferedReader(new FileReader("/Users/kchow/dropbox/projects/N-gram/big.txt.save"));
        StringTokenizer tk;
        String line = null;
        String word = null;
        int c = 0;
        while ((line = br.readLine()) != null)
        {
            tk = new StringTokenizer(line);
            String previous = null;
            while (tk.hasMoreTokens())
            {
                c++;
                //process the word
                word = tk.nextToken();
                //remove special characters
                word = word.replaceAll("[^A-Za-z0-9]", "");
                //make lower case
                word = word.toLowerCase();
                //add to map, or increment to map
               freq.update(word);
               //add to bifreq map
               if (previous != null)
               {
                   String pair = previous + " " + word;
                   bifreq.update(pair); 
                   list.update(previous, word);}
               //set to previous
               previous = word;
            }
        }
      Scanner in = new Scanner(System.in);
      String next = in.next();
      System.out.println(next + " " + list.getNextWord(next));
      System.out.println(freq.getFrequency(next));


                       
    }
}
