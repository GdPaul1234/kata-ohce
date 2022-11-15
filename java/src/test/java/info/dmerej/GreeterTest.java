package info.dmerej;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreeterTest {
  @Test
  void nightlyGreeting() {
    // Assert that greeter says "Good night" when current hour is 0 (midnight)
    var midnightClock = new BaseClock() {
      @Override
      public int getCurrentHour() {
        return 0; // midnight
      }
    };
    var greeter = new Greeter(midnightClock);

    assertEquals("Good night", greeter.greet());
  }

  @ParameterizedTest
  @ValueSource(ints = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 } )
  void neverAsserts(int hour) {
    // Assert that the assertion in greet() is never thrown, by checking all hours from 0 to 23
    var clock = new BaseClock() {
      @Override
      public int getCurrentHour() {
        return hour; // midnight
      }
    };
    var greeter = new Greeter(clock);

    assertDoesNotThrow(greeter::greet);
  }
}
