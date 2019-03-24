package gl;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 1)
@Warmup(iterations = 2)
@Measurement(iterations = 5)
public class TextService {

    @State(Scope.Thread)
    public static class MyState {
        public String text = "";
        int[] integers = ThreadLocalRandom.current().ints().limit(100_000).toArray();
    }

    @Benchmark
    public String staticText() {
        return "Some static text";
    }

    @Benchmark
    public String variable(MyState myState) {
        return myState.text;
    }

    @Benchmark
    public String exception(MyState myStatet) throws RuntimeException {
        throw new CustomException();
    }

    @Benchmark
    public String exceptionCatch(MyState myState) throws RuntimeException {
        try {
            throw new CustomException();
        } catch (CustomException ex) {
        }
        return myState.text;
    }

    @Benchmark
    public String exceptionCatchWithStackTrace(MyState myState) throws RuntimeException {
        try {
            throw new CustomException();
        } catch (CustomException ex) {
            ex.printStackTrace();
        }
        return myState.text;
    }

    @Benchmark
    public void forLoop(MyState ar) {
        List<Object> list = new ArrayList<>();
        for (Object i : ar.integers) {
            list.add(i);
        }

    }

    @Benchmark
    public void streamLoop(MyState ar) {
        List<Object> list = new ArrayList<>();

        Arrays.stream(ar.integers).forEach(x -> {
            list.add(x);
        });

    }
}