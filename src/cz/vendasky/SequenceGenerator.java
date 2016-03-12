package cz.vendasky;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
                   if (newSequence.length() > countOfRequiredNumbers) {
                        newSequence = newSequence.substring(0, countOfRequiredNumbers);
                        this.sequence = newSequence;
                        return;
                    }
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

    public void generateRequiredSequence() {
        for (int i = 1; i < this.positionOfSequence; i++) {
            this.nextSequence();
        }
    }

    public static String readFromInputFile(String pathToFile) {
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

}
