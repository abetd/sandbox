package lambda.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorTest {
    List<Sample> samples = Arrays.asList(
            new Sample(LocalDate.of(2019, 5, 2), LocalTime.of(11, 00, 00)),
            new Sample(LocalDate.of(2019, 5, 2), LocalTime.of(12, 00, 00)),
            new Sample(LocalDate.of(2019, 5, 3), LocalTime.of(9, 00, 00)),
            new Sample(LocalDate.of(2019, 5, 3), LocalTime.of(10, 00, 00))
    );

    @Test
    @DisplayName("Comparatorで複数項目でソート")
    void test() {
        Comparator<Sample> comparator = Comparator.comparing(Sample::getDate).thenComparing(Sample::getTime).reversed();
        Optional<Sample> actual = samples.stream().sorted(comparator).findFirst();
        assertEquals(LocalDate.of(2019, 5, 3), actual.get().getDate());
        assertEquals(LocalTime.of(10, 00, 00), actual.get().getTime());

        comparator = Comparator.comparing(Sample::getDate).thenComparing(Sample::getTime);
        actual = samples.stream().sorted(comparator).findFirst();
        assertEquals(LocalDate.of(2019, 5, 2), actual.get().getDate());
        assertEquals(LocalTime.of(11, 00, 00), actual.get().getTime());
    }
}


class Sample {
    public Sample(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }
    private LocalDate date;
    private LocalTime time;

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
