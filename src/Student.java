import java.io.Serializable;
import java.util.ArrayList;

class Student extends BasicInfo implements Serializable
{
    Attendence std_attendence = new Attendence();
    ArrayList<Course> CoursesToStudy = new ArrayList<>();
    Acedemics std_acdem = new Acedemics();
    ArrayList<String> CourseFeedback = new ArrayList<>();


    public Student(String fname, String lname, String email, String password, int ID, String address, String dept)
    {
        super(fname, lname, email, password, ID, address, dept);
    }

    @Override
    void display()
    {
        System.out.println("\n--- Student details ---");
        System.out.println("Name: " + ( super.getFname() + " " + super.getLname() ));
        System.out.println("Email: " + super.getEmail());
        System.out.println("ID: " + super.getID());
        System.out.println("Student department: " + super.getDept());
    }
}
