package cz.vendasky;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SequenceGeneratorTest {
    SequenceGenerator generator;

    @Before
    public void setUp() {
        generator = new SequenceGenerator(10, 8);
    }

    @Test
    public void shouldReturnNextSequence() {
        generator.nextSequence();
        Assert.assertEquals("11", this.generator.getSequence());
    }

    @Test
    public void shouldGenerateRequiredSequence() {
        generator.generateRequiredSequence();
        Assert.assertEquals("1113213211", this.generator.getSequence());
    }
}
