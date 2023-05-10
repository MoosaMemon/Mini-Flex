import java.io.Serializable;

abstract class BasicInfo implements Serializable
{
    private String fname;
    private String lname;
    private String email;
    private String password;
    protected int ID;
    private String address;

    public BasicInfo(String fname, String lname, String email, String password, int ID, String address)
    {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.ID = ID;
        this.address = address;
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

}
