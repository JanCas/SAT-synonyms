class Pair {
    private int WordIndex;
    private int WordCount;

    public Pair(int WordIndex, int WordCount) {
        this.WordIndex = WordIndex;
        this.WordCount = WordCount;
    }

    public Pair(int WordIndex) {
        this.WordIndex = WordIndex;
        this.WordCount = 1;
    }

    public int getWordIndex() {
        return WordIndex;
    }

    public int getWordCount() {
        return WordCount;
    }

    public void WordCountPlusOne() {
        WordCount += 1;
    }

}
