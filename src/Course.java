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

    public void display()
    {
        System.out.println("\n--- Course details ---");
        System.out.println("Course name: " + this.course_name);
        System.out.println("Course code: " + this.coursecode);
        System.out.println("Credit hours: " + this.hrs);
    }

}
