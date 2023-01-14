package tictactoe.core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
* Test something.
*/
public class CircularBufferTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenEmpty_thenError() throws Exception {
        CircularBuffer buffer = new CircularBuffer(10);

        exceptionRule.expect(Exception.class);
        buffer.pull();
    }

    @Test
    public void whenOverflow_thenError() throws Exception {
        CircularBuffer buffer = new CircularBuffer(3);

        exceptionRule.expect(Exception.class);
        buffer.push(1);
        buffer.push(1);
        buffer.push(1);
        buffer.push(1);
    }

    @Test
    public void whenPushed_thenOk() throws Exception {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.push(1);
        buffer.push(2);
        buffer.push(3);

        Assert.assertEquals(3, buffer.size());
        Assert.assertFalse(buffer.isEmpty());

        Assert.assertEquals(1, buffer.pull());
        Assert.assertEquals(2, buffer.pull());
        Assert.assertEquals(3, buffer.pull());

        Assert.assertEquals(0, buffer.size());
        Assert.assertTrue(buffer.isEmpty());
    }
}
