package dev.idion.nioexample;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {

  public static void main(String[] args) throws IOException {
    // "r", "rw", "rws", "rwd" 모드가 있다.
    try (RandomAccessFile file = new RandomAccessFile("src/main/resources/temp.txt", "r")) {
      FileChannel channel = file.getChannel();
      ByteBuffer byteBuffer = ByteBuffer.allocate(512); // 힙에 넌다이렉트 버퍼 생성
      while (channel.read(byteBuffer) > 0) {
        // 출력하기 위해 flip을 사용해서 버퍼를 비움
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
          System.out.print((char) byteBuffer.get());
        }
      }
    }
  }
}
