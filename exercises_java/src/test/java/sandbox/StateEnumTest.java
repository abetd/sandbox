package sandbox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.Set;

/**
 * 状態とイベント
 */
public class StateEnumTest {

    enum State {
        LOCKED(EnumSet.of(Event.OPEN, Event.CLOSE)),
        OPENED(EnumSet.of(Event.CLOSE, Event.LOCK)),
        CLOSED(EnumSet.of(Event.OPEN, Event.LOCK));

        final Set<Event> allowedEvents;

        State(Set<Event> events) {
            this.allowedEvents = events;
        }

        State occurs(Event event) {
            if (isArrowed(event)) return event.transit();
            throw new IllegalArgumentException();
        }

        boolean isArrowed(Event event) {
            return allowedEvents.contains(event);
        }
    }

    enum Event {
        OPEN,
        CLOSE,
        LOCK;

        State transit() {
            if (this.equals(OPEN)) return State.OPENED;
            if (this.equals(CLOSE)) return State.CLOSED;
            return State.LOCKED;
        }
    }

    @Test
    void testLocked() {
        assertAll(
                () -> assertEquals(State.OPENED, State.LOCKED.occurs(Event.OPEN)),
                () -> assertEquals(State.CLOSED, State.LOCKED.occurs(Event.CLOSE)),
                () -> assertThrows(IllegalArgumentException.class, () -> State.LOCKED.occurs(Event.LOCK))
        );
    }

    @Test
    void testOpen() {
        assertAll(
                () -> assertEquals(State.CLOSED, State.OPENED.occurs(Event.CLOSE)),
                () -> assertEquals(State.LOCKED, State.OPENED.occurs(Event.LOCK)),
                () -> assertThrows(IllegalArgumentException.class, () -> State.OPENED.occurs(Event.OPEN))
        );
    }

    @Test
    void testClose() {
        assertAll(
                () -> assertEquals(State.OPENED, State.CLOSED.occurs(Event.OPEN)),
                () -> assertEquals(State.LOCKED, State.CLOSED.occurs(Event.LOCK)),
                () -> assertThrows(IllegalArgumentException.class, () -> State.CLOSED.occurs(Event.CLOSE))
        );
    }
}
