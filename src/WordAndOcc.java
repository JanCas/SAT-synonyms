import java.util.ArrayList;

/**
 * Created by janlc on 7/5/2017.
 */
public class WordAndOcc {
    String Word;
    ArrayList<Pair> Pairs = new ArrayList<>();

    public  WordAndOcc(String Word, ArrayList<Pair> Pairs){
        this.Word = Word;
        this.Pairs = Pairs;
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    public ArrayList<Pair> getPairs() {
        return Pairs;
    }

    public void setPairs(ArrayList<Pair> pairs) {
        Pairs = pairs;
    }
}

