import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.DocumentPreprocessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TextPrep implements Utility{

    public final ArrayList<List<String>> TextToSentenceString = new ArrayList<>();
    public final HashMap<String, Integer> WordToIndex = new HashMap<>();
    private final Remover RemoveTockens = new Remover();


    public TextPrep(String fn) {
        ParseIntoSentencesIntoString(fn);
    }

    /**
     * @Author: Jan Cas
     */
    public void ParseIntoSentencesIntoString(String fn) {
        DocumentPreprocessor dp = new DocumentPreprocessor(fn);
        for (List<HasWord> sentence : dp)
            if(ContainsWords(HasWordListToString(sentence)))
                TextToSentenceString.add(MakesentenceLowerCase(OnlyWord(HasWordListToString(sentence))));
        SentenceToWordToHashMap();
    }

    /**
     * @Author Jan Cas
     * @param sentence
     * @return List<>String</>
     * Takes a List<>HasWord</> and converts it into a List<>String</>
     */
    public List<String> HasWordListToString(List<HasWord> sentence) {
        ArrayList<String> sen = new ArrayList<>();
        for (HasWord Word : sentence)
            sen.add(Word.word());
        return sen;
    }

    /**
     * @Author Jan Cas
     * @param sentence
     * @return List<>String</>
     * Takes a sentence stored in List<>String</> and then makes all the word lower Case
     */
    public List<String> MakesentenceLowerCase(List<String> sentence) {
        for (int i = 0; i < sentence.size(); i++)
            if (isBetween(ToASCII(sentence.get(i)), 65, 90))
                sentence.set(i, sentence.get(i).toLowerCase());
        return sentence;
    }

    /**
     * @Author Jan Cas
     * @param sentence
     * @return List<>String</>
     * takes a sentence stored in List<>String</> and returns that same sentence but without any non Words
     */
    public List<String> OnlyWord(List<String> sentence){
        return ContainsWords(sentence) ? RemoveTockens.RemoveAllNonWords(sentence) : null;
    }

    /**
     * @Author Jan Cas
     * @param sentence
     * @return boolean
     * takes a sentence and checks if it contains words and returns a boolean
     */
    @Override
    public boolean ContainsWords(List<String> sentence){
        for (String Word : sentence)
            if (isBetween(ToASCII(Word), 65, 90) ||
                    isBetween(ToASCII(Word), 97, 122))
                return true;
        return false;
    }

    /**
     * @Author Jan Cas
     * Assignes each word to an ID
     */
    public void SentenceToWordToHashMap() {
        for (List<String> sentence : TextToSentenceString)
            for (String Word : sentence)
                WordToIndex.putIfAbsent(Word, WordToIndex.size());
    }

    /**
     * @Author Jan Cas
     * @param Text
     * Prints out An ArrayList<>List<>String</></>
     */
    public void PrintStringArray(ArrayList<List<String>> Text){
        for(List<String> sentence : Text)
            System.out.println(sentence);
    }

    /**
     * @Author Jan Cas
     * @param n
     * @param lower
     * @param upper
     * @return boolean
     * checks if n is between lower and upper
     */
    @Override
    public boolean isBetween(int n, int lower, int upper) {
        return (n >= lower && n <= upper);
    }

    /**
     * @Author Jan Cas
     * @param Word
     * @return int Ascii
     * Converts the first char of a Word (String)
     */
    @Override
    public int ToASCII(String Word) {
        return (int) Word.charAt(0);
    }
}
