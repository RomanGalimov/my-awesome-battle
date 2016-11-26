import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by egor__000 on 22.11.2016.
 */
public class DateHelper {
    private static final String DATE_PATTERN = "dd.MM.yyy HH:mm";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    private LocalDateTime start;
    private LocalDateTime current;
    public DateHelper(){
        start = LocalDateTime.now().minusYears(1500);
        current = LocalDateTime.from(start);
    }

    public String getFormattedStartDate(){
        return FORMATTER.format(start);
    }

    public String getFormattedCurrentDate(){
        return FORMATTER.format(current);
    }

    public void skipTime() {
        current = current.plusMinutes(45);
    }

    public String getFormattedDiff(){
        LocalDateTime period = LocalDateTime.from(start);
        long years = period.until(current, ChronoUnit.YEARS);


        long months = period.until(current, ChronoUnit.MONTHS);
        period = period.plusMonths(months);

        long days = period.until(current, ChronoUnit.DAYS);
        period = period.plusDays(days);

        long hours = period.until(current, ChronoUnit.HOURS);
        period = period.plusHours(hours);

        long minutes = period.until(current, ChronoUnit.MINUTES);
        period = period.plusMinutes(minutes);

        return years + " year(s) " + months + " month(s) " + days + " day(s) "
                + hours + " hour(s) " + minutes + " minute(s) ";
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getCurrent() {
        return current;
    }

    public void setCurrent(LocalDateTime current) {
        this.current = current;
    }
}
