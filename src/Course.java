import java.io.Serializable;

class Course implements Serializable
{
    String coursecode;
    String course_name;
    int hrs;

    public Course(String course_name, int hrs, String coursecode)
    {
        this.course_name = course_name;
        this.hrs = hrs;
        this.coursecode = coursecode;
    }

    public void disp() {
        System.out.println("Course Name: " + this.course_name + " Course ID: " + coursecode + " Credit Hours: " + this.hrs);
    }

}
