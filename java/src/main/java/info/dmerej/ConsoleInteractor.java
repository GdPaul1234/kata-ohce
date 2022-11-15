package info.dmerej;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInteractor implements BaseInteractor {
  @Override
  public String readInput() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      return reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException("Could no read from stdin", e);
    }
  }

  @Override
  public void printMessage(String message) {
    System.out.println(message);
  }
}
