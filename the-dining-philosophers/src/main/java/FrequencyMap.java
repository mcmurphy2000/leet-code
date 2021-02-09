import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

class Frequency {
    final Integer id;
    int count;

    public Frequency(Integer id, int count) {
        this.id = id;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frequency frequency = (Frequency) o;
        return id.equals(frequency.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class FrequencyMap {

    private final ConcurrentMap<Integer, Frequency> map;
    private final SortedSet<Frequency> set;

    public FrequencyMap() {
        map = new ConcurrentHashMap<>();
        Comparator<Frequency> comparator = Comparator.comparingInt(Frequency::getCount);
        set = new ConcurrentSkipListSet<>(comparator);
    }

    // it gets dead-locked here
    public synchronized void registerOccurrence(Integer id) {
        Frequency frequency;
        frequency = map.putIfAbsent(id, new Frequency(id, 0));
        frequency.count++;
        set.remove(frequency);
        set.add(frequency);
    }

    public Integer getMostFrequentId() {
        if (set.size() == 0) {
            return null;
        } else {
            return set.last().getId();
        }
    }
}
