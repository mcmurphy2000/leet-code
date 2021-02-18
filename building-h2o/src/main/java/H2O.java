class H2O {

    private final Object lock = new Object();
    private int count;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (lock) {
            while (count >= 2)
                lock.wait();
            count++;
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            lock.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (lock) {
            while (count < 2)
                lock.wait();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            count = 0;
            lock.notifyAll();
        }
    }
}