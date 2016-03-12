package cz.vendasky;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SequenceGeneratorTest {
    SequenceGenerator generator;

    public SequenceGeneratorTest() {
    }

    @Before
    public void setUp() {
        this.generator = new SequenceGenerator(8, 10);
    }

    @Test
    public void shouldReturnNextSequence() {
        this.generator.nextSequence();
        Assert.assertEquals("11", this.generator.getSequence());
    }
}
