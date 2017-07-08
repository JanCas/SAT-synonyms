import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by janlc on 7/5/2017.
 */
public class Calc {

    public HashMap<String, Integer> WordToIndex = new HashMap<>();
    public ArrayList<List<String>> TextString = new ArrayList<List<String>>();
    ArrayList<WordAndOcc> WordAndPair = new ArrayList<>();
    ArrayList<String> keys = new ArrayList<>();
    Occ occurances;

    public Calc(ArrayList<List<String>> TextString, HashMap<String, Integer> WordToIndex) {
        this.WordToIndex = WordToIndex;
        this.TextString = TextString;
        getKeys();
        occurances = new Occ(WordToIndex, TextString);
    }

    public void FillWordAndPair() {
        for (String key : keys) {
            occurances.SetTarget(key);
            WordAndPair.add(new WordAndOcc(key, occurances.Runner()));
            occurances.DeleteArrayList();
        }
    }

    public void getKeys() {
        for (String key : WordToIndex.keySet())
            keys.add(key);
    }
}
