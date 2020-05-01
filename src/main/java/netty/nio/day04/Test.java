package netty.nio.day04;

import java.util.HashMap;
import java.util.concurrent.atomic.LongAdder;

public class Test {
    public static void main(String[] args) {
        LongAdder longAdder=new LongAdder();
        longAdder.add(1);
        longAdder.increment();
        HashMap hashMap=new HashMap();
        hashMap.put("a",args);

    }
}
