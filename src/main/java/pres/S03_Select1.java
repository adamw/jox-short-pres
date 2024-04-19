package pres;

import com.softwaremill.jox.Channel;

import static com.softwaremill.jox.Select.select;

public class S03_Select1 {
    public static void main(String[] args) throws InterruptedException {
        var ch1 = new Channel<String>();
        var ch2 = new Channel<String>();

        Thread.ofVirtual().start(() -> {
            try {
                ch1.send("v1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.ofVirtual().start(() -> {
            try {
                ch2.send("v2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(
                select(ch1.receiveClause(), ch2.receiveClause())
        );
    }
}
