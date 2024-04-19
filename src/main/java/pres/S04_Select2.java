package pres;

import com.softwaremill.jox.Channel;

import static com.softwaremill.jox.Select.select;

public class S04_Select2 {
    public static void main(String[] args) throws InterruptedException {
        var ch1 = new Channel<Integer>();
        var ch2 = new Channel<Integer>();

        Thread.ofVirtual().start(() -> {
            try {
                ch1.receive();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.ofVirtual().start(() -> {
            try {
                ch2.receive();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        var sent = select(
                ch1.sendClause(13, () -> "first"),
                ch2.sendClause(25, () -> "second")
        );

        System.out.println("Sent: " + sent);
    }
}
