import java.io.Serializable;

class Teacher extends BasicInfo implements Serializable
{

    boolean tcourse_assigned_status;
    Course AssignedCourse;

    public Teacher(String fname, String lname, String email, String password, int ID, String address, String dept, boolean tcourse_assigned)
    {
        super(fname, lname, email, password, ID, address, dept);

        this.tcourse_assigned_status = tcourse_assigned;
    }

    @Override
    void display()
    {
        System.out.println("First name: " + super.getFname());
        System.out.println("Last name: " + super.getLname());
        System.out.println("Email: " + super.getEmail());
        System.out.println("Teacher ID: " + super.getID());
        System.out.println("Department: " + super.getDept());
    }
}
