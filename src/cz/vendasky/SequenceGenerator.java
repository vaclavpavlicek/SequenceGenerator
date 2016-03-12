package cz.vendasky;

public class SequenceGenerator {
    private int countOfRequiredNumbers;
    private int positionOfSequence;
    private String sequence;

    public SequenceGenerator(int countOfRequiredNumbers, int positionOfSequence) {
        this.countOfRequiredNumbers = countOfRequiredNumbers;
        this.positionOfSequence = positionOfSequence;
        this.sequence = "1";
    }

    public void nextSequence() {
        int countOfNumbers = 0;
        String actualNumber = "";
        String newSequence = "";

        for(int i = 0; i < this.sequence.length(); ++i) {
            if(this.sequence.substring(i, i + 1).equals(actualNumber)) {
                ++countOfNumbers;
            } else {
                if(countOfNumbers != 0) {
                    newSequence = newSequence + Integer.toString(countOfNumbers) + actualNumber;
                }

                actualNumber = this.sequence.substring(i, i + 1);
                countOfNumbers = 1;
            }
        }

        newSequence = newSequence + Integer.toString(countOfNumbers) + actualNumber;
        this.sequence = newSequence;
    }

    public String getSequence() {
        return this.sequence;
    }
}
