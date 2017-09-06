import java.io.FileNotFoundException;

/**
 * @author Jan Cas
 * this is a project from the nifty stanford projects
 * it compares 2 words and then gives you the Similarity
 * Project handout in the link below:
 *  |
 * \ /
 * http://nifty.stanford.edu/2017/guerzhoy-SAT-synonyms/2015/p3_synonyms.pdf
 */
class Main {


    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        TextPrep prep = new TextPrep("Data");
        Calc calculateprep = new Calc(prep.TextToSentenceString, prep.WordToIndex);
        calculateprep.caller();
    }
}
