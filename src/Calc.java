import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by janlc on 7/5/2017.
 */
public class Calc {

    public HashMap<String, Integer> WordToIndex = new HashMap<>();
    public ArrayList<List<String>> TextString = new ArrayList<>();
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
            System.out.println("Target Word: " + key);
            occurances.SetTarget(key);
            WordAndPair.add(new WordAndOcc(key, occurances.Runner()));
            occurances.DeleteArrayList();
        }
    }

    public void PrintWordAndPair(){
        for(int i = 0; i < WordAndPair.size(); i++){
            System.out.print("Word : " + WordAndPair.get(i).getWord());
            System.out.print(" Pairs : " );
            for (Pair P : WordAndPair.get(i).getPairs())
                System.out.print(P + " ");
            System.out.println();
        }

    }
    public void getKeys() {
        for (String key : WordToIndex.keySet()) {
           // System.out.println(key);
            keys.add(key);
        }
    }

}
