package netty.nio.day03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.LongAdder;

public class MapByteBuff {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile= new RandomAccessFile("E:/xqs.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();

        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        map.put(0, Byte.parseByte("X"));
        LongAdder longAdder =new LongAdder();


    }
}
