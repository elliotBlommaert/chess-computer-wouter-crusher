package general;

import java.util.Objects;

public class Pair<T, S> {
    private final T fst;
    private final S snd;

    public Pair(T fst, S snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(fst, pair.fst) && Objects.equals(snd, pair.snd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fst, snd);
    }

    public T getFirst() {
        return fst;
    }

    public S getSecond() {
        return snd;
    }
}
