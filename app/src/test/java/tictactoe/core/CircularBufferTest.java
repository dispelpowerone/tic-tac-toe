package tictactoe.core;

import org.junit.Assert;
import org.junit.Test;

/**
* Test something.
*/
public class CircularBufferTest {

    @Test
    public void whenEmpty_thenError() {
        CircularBuffer buffer = new CircularBuffer(10);

        Assert.assertThrows(Exception.class, () -> {
            buffer.pull();
        });
    }

    @Test
    public void whenOverflow_thenError() {
        CircularBuffer buffer = new CircularBuffer(3);

        Assert.assertThrows(Exception.class, () -> {
            buffer.push(1);
            buffer.push(1);
            buffer.push(1);
            buffer.push(1);
        });
    }

    @Test
    public void whenPushed_thenOk() {
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
