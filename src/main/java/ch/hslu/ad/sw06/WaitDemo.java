package ch.hslu.ad.sw06;

import ch.hslu.ad.sw02.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WaitDemo {
    private static final Logger LOG = LogManager.getLogger(Task.class);
    public static boolean joy = false;

    public synchronized void guardedJoy() {
        LOG.info("GuardedJoy started()");
        while (!joy) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("JOY is unlocked and called");
    }

    public synchronized void notifyJoy() {
        joy = true;
        this.notifyAll();
    }


    public static void main(String[] args) throws Exception {
        final WaitDemo waitDemo = new WaitDemo();
        new Thread(() -> {
            waitDemo.guardedJoy();
        }).start();

        Thread.sleep(1000);

        waitDemo.notifyJoy();
    }
}
