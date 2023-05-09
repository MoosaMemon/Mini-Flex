import java.time.LocalDate;
import java.time.LocalTime;

class DateANDTime {
    int day;
    int month;
    int year;
    int hour;
    int minute;

    DateANDTime() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        this.day = currentDate.getDayOfMonth();
        this.month = currentDate.getMonthValue();
        this.year = currentDate.getYear();
        this.hour = currentTime.getHour();
        this.minute = currentTime.getMinute();
    }
}
