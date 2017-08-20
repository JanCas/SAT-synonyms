import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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
            occurances = new Occ(key, WordToIndex, TextString);
            WordAndPair.add(new WordAndOcc(key, occurances.Runner()));
        }
    }

    public void getKeys() {
        for (String key : WordToIndex.keySet()) keys.add(key);
    }

    public void caller() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Process is starting. Reading the lists and analyzing");
        FillWordAndPair();
        System.out.println("Reading and analyzing complete");
        String repeat;
        do {
            System.out.println("please type in word 1");
            String W1 = keyboard.nextLine();
            if (!keys.contains(W1))
                while (!keys.contains(W1)) {
                    System.out.println("please enter a new Word, the previous word was not supported");
                    W1 = keyboard.nextLine();
                }

            System.out.println();
            System.out.println("please type in word 2");
            String W2 = keyboard.nextLine();
            if (!keys.contains(W2))
                while (!keys.contains(W2)) {
                    System.out.println("please enter a new Word, the previous word was not supported");
                    W2 = keyboard.nextLine();
                }

            double result = Similarity(W1, W2);
            System.out.println();
            System.out.println("the similarity between the 2 words is : " + String.format("%.4f", result));
            System.out.println("Do you want to go again (Y/N)");
            repeat = keyboard.nextLine();
        } while (repeat.equalsIgnoreCase("Y"));
    }

    public double Similarity(String Word1, String Word2) {
        int index1 = FindIndex(Word1);
        int index2 = FindIndex(Word2);
        return (sigma(WordAndPair.get(index1).getPairs(), WordAndPair.get(index2).getPairs()) /
                Math.sqrt((sigmaSQ(WordAndPair.get(index1).getPairs())) * (sigmaSQ(WordAndPair.get(index2).getPairs()))));
    }

    public int FindIndex(String Word) {
        for (int i = 0; i < WordAndPair.size(); i++)
            if (WordAndPair.get(i).getWord().equalsIgnoreCase(Word))
                return i;
        return 0;
    }

    public double sigma(ArrayList<Pair> P1, ArrayList<Pair> P2){
        double sum = 0;
        for(Pair p : P1)
            for(Pair x : P2)
                if(p.getWordIndex() == x.getWordIndex())
                    sum += p.getWordCount()*x.getWordCount();
        return sum;
    }

    public double sigmaSQ(ArrayList<Pair> Pairs) {
        double sum = 0;
        for (int i = 0; i < Pairs.size(); i++)
            sum += square(Pairs.get(i).getWordCount());
        return sum;
    }

    public double square(int x) {
        return x * x;
    }
}
