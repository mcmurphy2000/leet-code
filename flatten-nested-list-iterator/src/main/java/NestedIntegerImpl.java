import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NestedIntegerImpl implements NestedInteger {

    private final Integer integer;
    private final List<NestedInteger> list;

    public NestedIntegerImpl(Integer integer) {
        this.integer = Objects.requireNonNull(integer);
        list = new ArrayList<>();
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.integer = null;
        this.list = Objects.requireNonNull(list);
    }

    @Override
    public boolean isInteger() {
        return integer != null;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
