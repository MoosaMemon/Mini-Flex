import java.io.Serializable;

abstract class BasicInfo implements Serializable
{
    private String fname;
    private String lname;
    private String email;
    private String password;
    private int ID;
    private String address;
    private String dept;

    public BasicInfo(String fname, String lname, String email, String password, int ID, String address, String dept)
    {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.ID = ID;
        this.address = address;
        this.dept = dept;
    }
    abstract void display();

    public String getFname()
    {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }
    public String getDept()
    {
        return dept;
    }

}
