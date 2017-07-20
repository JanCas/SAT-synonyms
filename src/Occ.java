import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by janlc on 6/23/2017.
 */
public class Occ {
    public static String TARGET;
    ArrayList<Pair> OccurancesInSentences = new ArrayList<>();
    HashMap<String, Integer> WordToIndex = new HashMap<>();
    ArrayList<List<String>> TextToSentenceString = new ArrayList<>();

    public Occ(String TARGET, HashMap<String, Integer> WordToIndex, ArrayList<List<String>> TextToSentenceString) {
        Occ.TARGET = TARGET;
        this.WordToIndex = WordToIndex;
        this.TextToSentenceString = TextToSentenceString;
    }

    public Occ(HashMap<String, Integer> WordToIndex, ArrayList<List<String>> TextToSenteceString) {
        this.WordToIndex = WordToIndex;
        this.TextToSentenceString = TextToSenteceString;
    }

    public void SetTarget(String TARGET) {
        Occ.TARGET = TARGET;
    }

    /**
     * @param key
     * @return boolean
     * cecks if OccurancesInSentences contains the pair with the key
     */
    public boolean ContainsPair(int key) {
        if (OccurancesInSentences != null)
            for (Pair P : OccurancesInSentences)
                if (P.getWordIndex() == key)
                    return true;
        return false;
    }


    /**
     * @param WordID
     * @return int
     * returns the index of a pair with a certain Id
     */
    public int GetIndexOfPair(int WordID) {
        for (int i = 0; i < OccurancesInSentences.size(); i++)
            if (OccurancesInSentences.get(i).getWordIndex() == WordID)
                return i;
        return 0;
    }

    /**
     * @param key
     * @return int index
     * Returns the Index of where the Pair has to be put
     */
    public int PutIntoRightLoc(int key) {
        System.out.println(OccurancesInSentences.size());
        if (OccurancesInSentences.size() == 0)
            return 0;
        else
            for (int i = 0; i < OccurancesInSentences.size(); i++)
                if (i + 1 == OccurancesInSentences.size() &&
                        key > OccurancesInSentences.size())
                    return i + 1;
                else if (OccurancesInSentences.get(i).getWordIndex() > key ||
                        OccurancesInSentences.get(i + 1).getWordIndex() > key)
                    return i;
        return 0;
    }

    /**
     * @param sentence
     * counts the Occurances in the sentence around the TARGET
     */
    public void CountOccurancesInSentence(List<String> sentence) {
        for (String Word : sentence)
            if (!(Word.equalsIgnoreCase(TARGET)))
                if (!ContainsPair(WordToIndex.get(Word)))
                    OccurancesInSentences.add(PutIntoRightLoc(WordToIndex.get(Word)), new Pair(WordToIndex.get(Word)));
                else
                    OccurancesInSentences.get(GetIndexOfPair(WordToIndex.get(Word))).WordCountPlusOne();
    }

    /**
     * runs CountOccurancesInSentence over the whole text
     */
    public void CountOccurancesInText() {
        for (List<String> sentence : TextToSentenceString)
            if (sentence.contains(TARGET))
                CountOccurancesInSentence(sentence);
    }

    public ArrayList<Pair> Runner() {
        CountOccurancesInText();
        return OccurancesInSentences;
    }

    public void DeleteArrayList(){
        OccurancesInSentences.clear();
    }

    public void PrintOcc() {
        for (Pair P : OccurancesInSentences)
            System.out.println("key " + P.getWordIndex() + " : Value " + P.getWordCount());
    }
}
