package tictactoe.core;

import lombok.experimental.SuperBuilder;

import org.junit.Assert;
import org.junit.Test;

/**
* Test something.
*/
public class OutputEventDispatcherTest {

    @SuperBuilder
    static class TestEvent extends Event {

        public TestEvent(Long actorId) {
            super(actorId);
        }
    };

    @Test
    public void whenDuplicate_thenError() {
        OutputEventDispatcher dispatcher = new OutputEventDispatcher();
        Assert.assertThrows(Exception.class, () -> {
            dispatcher.addDestination(Long.valueOf(1), new EventStream());
            dispatcher.addDestination(Long.valueOf(1), new EventStream());
        });
    }

    @Test
    public void whenSent_thenReceived() {
        OutputEventDispatcher dispatcher = new OutputEventDispatcher();
        EventStream dest1 = new EventStream();
        EventStream dest2 = new EventStream();
        dispatcher.addDestination(Long.valueOf(1), dest1);
        dispatcher.addDestination(Long.valueOf(2), dest2);
        dispatcher.write(new TestEvent(Long.valueOf(3)));

        Event eventDest1 = dest1.read();
        Assert.assertNotNull(eventDest1);
        Assert.assertEquals(Long.valueOf(3), eventDest1.getActorId());
        Assert.assertNull(dest1.read());

        Event eventDest2 = dest2.read();
        Assert.assertNotNull(eventDest2);
        Assert.assertEquals(Long.valueOf(3), eventDest2.getActorId());
        Assert.assertNull(dest2.read());
    }
}
