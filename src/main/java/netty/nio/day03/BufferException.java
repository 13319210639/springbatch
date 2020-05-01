package netty.nio.day03;

import java.nio.ByteBuffer;

public class BufferException
{
    public static void main(String[] args) {
        ByteBuffer  byteBuffer =ByteBuffer.allocate(64);
        byteBuffer.put((byte) (1*2));
        byteBuffer.asReadOnlyBuffer();

    }
}
