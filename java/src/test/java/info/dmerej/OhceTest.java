package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class OhceTest {
    @Test
    void testMainLoop() {
        List<String> inputs = new ArrayList<>(List.of("hello", "oto", "quit"));
        var interactor = new BaseInteractor() {
            private final List<String> output = new ArrayList<>();

            @Override
            public String readInput() {
                return inputs.remove(0);
            }

            @Override
            public void printMessage(String message) {
                output.add(message);
            }
        };
        Ohce ohce = new Ohce(interactor);

        ohce.mainLoop();

        var expecteds = List.of("olleh", "oto", "That was a palindrome!");
        assertEquals(expecteds, interactor.output);
    }
}
