package cz.vendasky;

import java.io.*;

public class SequenceGenerator {

    private int positionOfSequence;
    private int countOfRequiredNumbers;
    private String sequence;

    private SequenceGenerator(int positionOfSequence, int countOfRequiredNumbers) {
        this.positionOfSequence = positionOfSequence;
        this.countOfRequiredNumbers = countOfRequiredNumbers;
        this.sequence = "1";
    }

    public void nextSequence() {
        int countOfNumbers = 0;
        String actualNumber = this.sequence.substring(0, 1);
        String newSequence = "";
        for(int i = 0; i < this.sequence.length(); ++i) {
            if(this.sequence.substring(i, i + 1).equals(actualNumber)) {
                ++countOfNumbers;
            } else {
                newSequence = newSequence + countOfNumbers + actualNumber;
                actualNumber = this.sequence.substring(i, i + 1);
                countOfNumbers = 1;
            }
        }
        newSequence = newSequence + countOfNumbers + actualNumber;
        if (newSequence.length() >= countOfRequiredNumbers) {
            this.sequence = newSequence.substring(0, countOfRequiredNumbers);
        } else {
            this.sequence = newSequence;
        }                
    }

    public String getSequence() {
        return this.sequence;
    }

    public void generateRequiredSequence() {
        for (int i = 1; i < this.positionOfSequence; i++) {
            this.nextSequence();
            System.out.println("-----------------------------I" + i + "------------------------------------------------");
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

    public static SequenceGenerator generateSequenceGenerator(String pathToInputFile) {
        String line = readFromInputFile(pathToInputFile);
        int positionOfSequence = Integer.parseInt(line.substring(0, line.indexOf(" ")));
        int countOfRequiredNumbers = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
        return new SequenceGenerator(positionOfSequence, countOfRequiredNumbers);
    }

    public static void run(String pathToInputFile, String pathToOutputFile) {
        SequenceGenerator generator = generateSequenceGenerator(pathToInputFile);
        generator.generateRequiredSequence();
        try {
            PrintWriter writer = new PrintWriter(pathToOutputFile, "UTF-8");
            writer.println(generator.getSequence());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SequenceGenerator.run("/home/vaclav/IdeaProjects/SequenceGenerator/inputs/05.in", "/home/vaclav/IdeaProjects/SequenceGenerator/outputs/05.txt");
    }

}
