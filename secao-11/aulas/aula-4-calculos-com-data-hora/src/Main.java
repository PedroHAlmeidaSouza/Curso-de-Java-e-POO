import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        LocalDate d04 = LocalDate.parse("2025-07-15");
        LocalDateTime d05 = LocalDateTime.parse("2025-07-15T01:30:26");
        Instant d06 = Instant.parse("2025-07-15T01:30:26Z");

        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nextWeekLocalDate = d04.plusDays(7);

        System.out.println("pastWeekLocalDate: " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate: " + nextWeekLocalDate);

        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);

        System.out.println("pastWeekLocalDateTime: " + pastWeekLocalDateTime);
        System.out.println("nextWeekLocalDateTime: " + nextWeekLocalDateTime);

        Instant pastWeekInstant = d06.minusSeconds(7);
        Instant nextWeekInstant = d06.plusSeconds(7);

        System.out.println("pastWeekInstant: " + pastWeekInstant);
        System.out.println("nextWeekInstant: " + nextWeekInstant);

        Duration d1 = Duration.between(pastWeekLocalDateTime, d05);
        System.out.println("d1 dias: " + d1.toDays());
    }
}