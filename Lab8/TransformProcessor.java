import java.util.List;
import java.util.stream.Collectors;

public class TransformProcessor {
    @DataProcessor
    public List<String> transformData(List<String> input) {
        return input.parallelStream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}