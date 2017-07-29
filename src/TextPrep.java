import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.DocumentPreprocessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TextPrep implements Utility {

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
            if (ContainsWords(HasWordListToString(sentence)))
                TextToSentenceString.add(MakesentenceLowerCase(OnlyWord(HasWordListToString(sentence))));
        SentenceToWordToHashMap();
    }

    /**
     * @param sentence
     * @return List<>String</>
     * Takes a List<>HasWord</> and converts it into a List<>String</>
     * @Author Jan Cas
     */
    public List<String> HasWordListToString(List<HasWord> sentence) {
        ArrayList<String> sen = new ArrayList<>();
        for (HasWord Word : sentence) {
            //System.out.println(Word.word());
            sen.add(Word.word());
        }
        return sen;
    }


    /**
     * @param sentence
     * @return List<>String</>
     * Takes a sentence stored in List<>String</> and then makes all the word lower Case
     * @Author Jan Cas
     */
    public List<String> MakesentenceLowerCase(List<String> sentence) {
        for (int i = 0; i < sentence.size(); i++)
            if (isBetween(ToASCII(sentence.get(i)), 65, 90))
                sentence.set(i, sentence.get(i).toLowerCase());
        return sentence;
    }

    /**
     * @param sentence
     * @return List<>String</>
     * takes a sentence stored in List<>String</> and returns that same sentence but without any non Words
     * @Author Jan Cas
     */
    public List<String> OnlyWord(List<String> sentence) {
        return ContainsWords(sentence) ? RemoveTockens.RemoveAllNonWords(sentence) : null;
    }

    /**
     * @param sentence
     * @return boolean
     * takes a sentence and checks if it contains words and returns a boolean
     * @Author Jan Cas
     */
    @Override
    public boolean ContainsWords(List<String> sentence) {
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
                if (Word != null) {
                    WordToIndex.putIfAbsent(Word, WordToIndex.size());
                }
    }

    @Override
    public boolean isBetween(int n, int lower, int upper) {
        return (n >= lower && n <= upper);
    }

    /**
     * @param Word
     * @return int Ascii
     * Converts the first char of a Word (String)
     * @Author Jan Cas
     */
    @Override
    public int ToASCII(String Word) {
        return (int) Word.charAt(0);
    }
}
