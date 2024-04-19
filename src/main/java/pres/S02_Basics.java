package pres;

import com.softwaremill.jox.Channel;

public class S02_Basics {
    public static void main(String[] args) throws InterruptedException {
        var ch = new Channel<Integer>(4);

        ch.send(1);
        ch.send(2);
        System.out.println(ch.receive());
    }
}
