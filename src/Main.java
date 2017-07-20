import java.io.FileNotFoundException;

/**
 * @author Jan Cas
 *
 */
class Main{


    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException{
        TextPrep prep = new TextPrep( "C:/Users/janlc/Desktop/Sherlock.txt");
        Calc calculateprep = new Calc(prep.TextToSentenceString, prep.WordToIndex);
        calculateprep.FillWordAndPair();
        //calculateprep.PrintWordAndPair();
    }
}
