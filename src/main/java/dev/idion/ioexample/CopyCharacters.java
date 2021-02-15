package dev.idion.ioexample;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {

  public static void main(String[] args) throws IOException {
    try (FileReader in = new FileReader("src/main/resources/input.txt");
        FileWriter out = new FileWriter("src/main/resources/output.txt")) {
      int c;

      while ((c = in.read()) != -1) { // -1은 EOF에 도달하면 출력됩니다.
        out.write(c);
      }
    }
  }
}
