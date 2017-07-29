import java.util.List;

class Remover implements Utility {

    public Remover() {}

    /**
     * @param L
     * @return removes all the non words in a List
     */
    public List<String> RemoveAllNonWords(List<String> L) {
        int length = L.size();
        for (int i = 0; i < length; i++)
            if (isBetween(ToASCII(L.get(i)), 33, 64) ||
                    isBetween(ToASCII(L.get(i)), 91, 96) ||
                    isBetween(ToASCII(L.get(i)), 123, 126)) {
                L.remove(i);
                i--;
                length--;
            }
        L = RepealAndReplace(L);
        return L;
    }

    public boolean isBetween(int n, int lower, int upper) {
        return (n >= lower && n <= upper);
    }

    /**
     * @param sentence
     * @return boolean
     * Checks if a List Contains Words
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
     * @param sentence
     * @return List<>String</>
     * replace all the n't in the List<>String</> with not
     */
    public List<String> RepealAndReplace(List<String> sentence) {
        for (int i = 0; i < sentence.size(); i++)
            if (sentence.get(i).equalsIgnoreCase("n't"))
                sentence.set(i, "not");
        return sentence;
    }

    @Override
    public int ToASCII(String Word) {
        return (int) Word.charAt(0);
    }
}
