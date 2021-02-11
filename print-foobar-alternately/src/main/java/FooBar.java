enum NowPrinting {
    FOO, BAR;
}

class FooBar {
    private final int n;
    private NowPrinting nowPrinting = NowPrinting.FOO;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (nowPrinting == NowPrinting.BAR)
                    wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                nowPrinting = NowPrinting.BAR;
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (nowPrinting == NowPrinting.FOO)
                    wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                nowPrinting = NowPrinting.FOO;
                notifyAll();
            }
        }
    }
}