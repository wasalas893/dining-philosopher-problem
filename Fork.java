import java.util.Random;

 public class Frk {
    int forkId;
    private boolean status;

    Frk(int forkId) {

        this.status = true;
    }

    public synchronized void free() throws InterruptedException {
        status = true;
    }

    public synchronized boolean pick(int philosopherId) throws InterruptedException {
        int a = 0;
        int wait = new Random().nextInt(10) + 5;

        while (!status) {

            Thread.sleep(new Random().nextInt(100) + 50);

            a++;

            if (a > wait) {
                return false;
            }

        }
        status = false;
        return true;

    }
}
