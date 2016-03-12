package cz.vendasky;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceGeneratorTest {
    SequenceGenerator generator;

    @Before
    public void setUp() {
        generator = SequenceGenerator.generateSequenceGenerator("/home/vaclav/IdeaProjects/SequenceGenerator/inputs/01.in");
    }

    @Test
    public void shouldReturnNextSequence() {
        generator.nextSequence();
        assertEquals("11", this.generator.getSequence());
    }

    @Test
    public void shouldGenerateRequiredSequence() {
        generator.generateRequiredSequence();
        assertEquals("11131221131211132221232112111312212321123113112221121113122113111231133221121321132132211331121321231231121113122113322113111221131221", this.generator.getSequence());
    }

    @Test
    public void shouldReadFromInputFile() {
        assertEquals("17 1000", SequenceGenerator.readFromInputFile("/home/vaclav/IdeaProjects/SequenceGenerator/inputs/01.in"));
    }

    @Test
    public void shouldCreateSequenceGenerator() {
        assertNotNull(SequenceGenerator.generateSequenceGenerator("/home/vaclav/IdeaProjects/SequenceGenerator/inputs/01.in"));
    }

    @After
    public void run() {
        SequenceGenerator.run("/home/vaclav/IdeaProjects/SequenceGenerator/inputs/05.in", "/home/vaclav/IdeaProjects/SequenceGenerator/outputs/05.txt");
    }
}
