package dev.idion.ioexample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

  public static void main(String[] args) throws IOException {
    try (FileInputStream in = new FileInputStream("src/main/resources/input.txt");
        FileOutputStream out = new FileOutputStream("src/main/resources/output.txt")) {
      int c;

      while ((c = in.read()) != -1) { // -1은 EOF에 도달하면 출력됩니다.
        out.write(c);
      }
    }
  }
}
