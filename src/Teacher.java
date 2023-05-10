import java.io.Serializable;

class Teacher extends BasicInfo implements Serializable
{
    String tdept;
    boolean tcourse_assigned_status;
    Course AssignedCourse;

    public Teacher(String fname, String lname, String email, String password, int ID, String address, String tdept, boolean tcourse_assigned)
    {
        super(fname, lname, email, password, ID, address);
        this.tdept = tdept;
        this.tcourse_assigned_status = tcourse_assigned;
    }


    @Override
    void display() {

    }
}
