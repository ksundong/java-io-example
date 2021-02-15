package dev.idion.ioexample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {

  public static void main(String[] args) throws IOException {
    try (BufferedReader in = new BufferedReader(new FileReader("src/main/resources/input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("src/main/resources/output.txt"))) {
      String line;

      while ((line = in.readLine()) != null) {
        out.println(line);
      }
    }
  }
}
