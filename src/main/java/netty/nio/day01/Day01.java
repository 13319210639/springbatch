package netty.nio.day01;

import java.nio.IntBuffer;

public class Day01 {
    static IntBuffer buffer = null;

    public static void main(String[] args) {
        buffer = IntBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i * 2);
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }

    }

}
