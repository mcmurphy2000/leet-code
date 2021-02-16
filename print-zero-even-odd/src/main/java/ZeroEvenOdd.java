import java.util.function.IntConsumer;

enum State {
    ZERO, EVEN, ODD, END;
}

class ZeroEvenOdd {
    private final int n;
    private State state;
    private int nowPrinting;

    public ZeroEvenOdd(int n) {
        this.n = n;
        synchronized (this) {
            state = State.ZERO;
            nowPrinting = 1;
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            while (state != State.ZERO && state != State.END)
                wait();
            if (state == State.END) return;
            printNumber.accept(0);
            setNextState();
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            while (state != State.EVEN && state != State.END)
                wait();
            if (state == State.END) return;
            printNumber.accept(nowPrinting);
            setNextState();
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            while (state != State.ODD && state != State.END)
                wait();
            if (state == State.END) return;
            printNumber.accept(nowPrinting);
            setNextState();
            notifyAll();
        }
    }

    private void setNextState() {
        switch (state) {
            case ZERO:
                state = nowPrinting % 2 == 0 ? State.EVEN : State.ODD;
                break;
            case EVEN:
            case ODD:
                nowPrinting++;
                state = nowPrinting > n ? State.END : State.ZERO;
                break;
        }
    }
}