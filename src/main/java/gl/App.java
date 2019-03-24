package gl;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class App {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(TextService.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
