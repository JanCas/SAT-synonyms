class Pair {
    private int WordIndex;
    private int WordCount;

    public Pair(int WordIndex, int WordCount) {
        this.WordIndex = WordIndex;
        this.WordCount = WordCount;
    }

    public Pair(int WordIndex){
        this.WordIndex = WordIndex;
        this.WordCount = 1;
    }
    public int getWordIndex() {
        return WordIndex;
    }

    public void setWordIndex(int WordIndex) {
        this.WordIndex = WordIndex;
    }

    public int getWordCount() {
        return WordCount;
    }

    public void setWordCount(int WordCount) {
        this.WordCount = WordCount;
    }

    public void AddWordCount(int WordCount) { this.WordCount += WordCount; }

    public void WordCountPlusOne() {
        WordCount += 1;
    }

}
