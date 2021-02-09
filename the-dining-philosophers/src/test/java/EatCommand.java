public class EatCommand {

    private final DiningPhilosophers diningPhilosophers;

    public EatCommand(DiningPhilosophers diningPhilosophers) {
        this.diningPhilosophers = diningPhilosophers;
    }

    public void commandToEat(Philosopher p) {
        try {
            diningPhilosophers.wantsToEat(p.getId(), p.pickLeftFork(), p.pickRightFork(), p.eat(), p.putLeftFork(), p.putRightFork());
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
