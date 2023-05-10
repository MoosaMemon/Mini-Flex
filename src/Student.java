import java.io.Serializable;

class Student extends BasicInfo implements Serializable
{
    Attendence std_attendence = new Attendence();

    public Student(String fname, String lname, String email, String password, int ID, String address)
    {
        super(fname, lname, email, password, ID, address);
    }

    @Override
    void display()
    {
        System.out.println("Name: " + ( this.getFname() + " " + this.getLname() ));
        System.out.println("Email: " + this.getEmail());
        System.out.println("ID: " + this.getID());
    }
}
