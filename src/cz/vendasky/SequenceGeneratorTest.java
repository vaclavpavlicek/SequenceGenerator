package cz.vendasky;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceGeneratorTest {
    SequenceGenerator generator;

    @Before
    public void setUp() {
        generator = new SequenceGenerator(10, 8);
    }

    @Test
    public void shouldReturnNextSequence() {
        generator.nextSequence();
        assertEquals("11", this.generator.getSequence());
    }

    @Test
    public void shouldGenerateRequiredSequence() {
        generator.generateRequiredSequence();
        assertEquals("1113213211", this.generator.getSequence());
    }

    @Test
    public void shouldReadFromInputFile() {
        assertEquals("14 1000", SequenceGenerator.readFromInputFile("/home/vaclav/IdeaProjects/SequenceGenerator/inputs/01.in"));
    }

    @Test
    public void shouldCreateSequenceGenerator() {
        assertNotNull(SequenceGenerator.generateSequenceGenerator("/home/vaclav/IdeaProjects/SequenceGenerator/inputs/01.in"));
    }
}
