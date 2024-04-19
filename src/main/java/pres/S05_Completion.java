package pres;

import com.softwaremill.jox.Channel;

public class S05_Completion {
    public static void main(String[] args) throws InterruptedException {
        var ch = new Channel<String>(4);

        ch.send("hello");
        ch.done();

        System.out.println("Received: " + ch.receiveOrClosed());
        System.out.println("Received: " + ch.receiveOrClosed());
    }
}
