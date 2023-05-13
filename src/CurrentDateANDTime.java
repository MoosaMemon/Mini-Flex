import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

class CurrentDateANDTime implements Serializable {
    int day;
    int month;
    int year;
    int hour;
    int minute;

    CurrentDateANDTime()
    {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        this.day = currentDate.getDayOfMonth();
        this.month = currentDate.getMonthValue();
        this.year = currentDate.getYear();
        this.hour = currentTime.getHour();
        this.minute = currentTime.getMinute();
    }
    void display()
    {
        System.out.println("DATE: " + (day + "/" + month + "/" + year));
        System.out.println("TIME: " + (this.hour + ":" + this.minute));

    }

}
