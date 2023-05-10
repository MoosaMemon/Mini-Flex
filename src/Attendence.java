import java.io.Serializable;
import java.util.ArrayList;

class Attendence implements Serializable {
    ArrayList<Course> tcrse = new ArrayList<>();
    ArrayList<DateANDTime> time = new ArrayList<>();
}
