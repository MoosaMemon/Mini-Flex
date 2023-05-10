import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Scanner sc = new Scanner(System.in);
        File sfile = new File("std_login_info.ser");
        File tfile = new File("tch_login_info.ser");

        ArrayList<Student> std_arry = new ArrayList<Student>();
        ArrayList<Teacher> tch_arry = new ArrayList<Teacher>();
        ArrayList<Course> createdCourses = new ArrayList<Course>();

        int i = 0;

        String email;
        String password;

        boolean slogstatus = false;
        boolean tloginstatus = false;
        boolean aloginstatus = false;

        while (true)
        {
            System.out.println("---MAIN MENU---\n");
            System.out.print("1 - Login as student\n2 - Login as teacher\n3 - Login as admin\n4 - Feedback\n5 - Exit\nEnter choice: ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    // STUDENT LOGIN
                    if(sfile.exists())
                    {
                        FileInputStream sfis = new FileInputStream(sfile);
                        ObjectInputStream sois = new ObjectInputStream(sfis);
                        ArrayList<Student> tmpstds = (ArrayList<Student>) sois.readObject();
                        sois.close();
                        std_arry = tmpstds;
                        tmpstds = null;
                    }
                    else
                    {
                        System.out.println("Failed to proceed! Register a student first.");
                        break;
                    }

                    System.out.print("Enter your email: ");
                    email = sc.next();
                    System.out.print("Enter your password: ");
                    password = sc.next();

                    for (int b=0; b<std_arry.size(); b++)
                    {
                        if ( email.equalsIgnoreCase(std_arry.get(b).getEmail()) )
                        {
                            if(password.equals(std_arry.get(b).getPassword()))
                            {
                                slogstatus = true;
                                System.out.println("Login successful as student!");
                                System.out.println("NOTE: MAKE SURE TO LOG OUT INORDER TO SAVE ANY MADE CHANGES!!!!!!");
                                while (slogstatus)
                                {
                                    System.out.println("--Student Menu--");
                                    System.out.println("1 - View Basic Information");
                                    System.out.println("2 - View Attendance");
                                    System.out.println("3 - View Marks");
                                    System.out.println("4 - GPA");
                                    System.out.println("5 - Course Feedback");
                                    System.out.println("6 - Log Out");
                                    System.out.print("Enter choice: ");
                                    int ch2 = sc.nextInt();
                                    switch (ch2)
                                    {
                                        case 1: //Basic Info
                                            for (int z = 0; z < std_arry.size(); z++)
                                            {
                                                Student std = std_arry.get(z);
                                                std.display();
                                            }
                                            break;
                                        case 2:
                                            // View Attendence
                                            boolean attflag = false;
                                            for(int m=0; m<createdCourses.size();m++)
                                            {
                                                if(attflag==true)
                                                {
                                                    break;
                                                }
                                                System.out.println("Enter course name to view attendance of: ");
                                                String an = sc.next();
                                                while (!attflag)
                                                {
                                                    if (an.equalsIgnoreCase(createdCourses.get(m).course_name))
                                                    {
                                                        attflag = true;

                                                    }
                                                    else
                                                    {
                                                        System.out.println("Enter valid course name!");
                                                        break;
                                                    }
                                                }
                                            }
                                        case 6:
                                            System.out.println("Saving changes before logging out...");
                                            FileOutputStream sfos = new FileOutputStream(sfile);
                                            ObjectOutputStream soos = new ObjectOutputStream(sfos);
                                            soos.writeObject(std_arry);
                                            soos.close();
                                            slogstatus = false;
                                            System.out.println("Successfully logged out!!");
                                            break;
                                        default:
                                            System.out.println("Enter correct choice!");
                                            break;
                                    }
                                }
                                if(slogstatus==false)
                                {
                                    break;
                                }
                            }
                        }
                    }
                    break;

















                case 2:
                    // TEACHER LOGIN
                    if(tfile.exists())
                    {
                        FileInputStream tfis = new FileInputStream(tfile);
                        ObjectInputStream tois = new ObjectInputStream(tfis);
                        ArrayList<Teacher> tmptchs = (ArrayList<Teacher>) tois.readObject();
                        tois.close();
                        tch_arry = tmptchs;
                        tmptchs = null;
                    }
                    else
                    {
                        System.out.println("Failed to proceed! Register a teacher first.");
                    }

                    System.out.print("Enter your email: ");
                    email = sc.next();
                    System.out.print("Enter your password: ");
                    password = sc.next();

                    for(int d=0; d<tch_arry.size();d++)
                    {
                        if(email.equalsIgnoreCase(tch_arry.get(d).getEmail()))
                        {
                            if(password.equals(tch_arry.get(d).getPassword()))
                            {
                                tloginstatus = true;
                                System.out.println("Login successful as teacher!");
                                System.out.println("NOTE: MAKE SURE TO LOG OUT INORDER TO SAVE ANY MADE CHANGES!!!!!!");
                                while (tloginstatus)
                                {
                                    System.out.println("--Teacher Menu--");
                                    System.out.println("1 - View Basic Informtion");
                                    System.out.println("2 - Set Attendance");
                                    System.out.println("3 - Set Marks");
                                    System.out.println("4 - View Course Feedback");
                                    System.out.println("5 - Logout");
                                    System.out.print("Enter choice: ");
                                    int ch3 = sc.nextInt();
                                    switch (ch3)
                                    {
                                        //Basic Info
                                        case 1:
                                            for (int z = 0; z < tch_arry.size(); z++)
                                            {
                                                Teacher teacher = tch_arry.get(z);
                                                teacher.display();
                                            }
                                        case 2:
//                                    //Set Attendance
//
//                                    System.out.println("List of Students");
//                                    for (int z=0; z<std_arry.size(); z++)
//                                    {
//                                        Student std = std_arry.get(z);
//                                        std.display();
//                                    }
//                                    System.out.println("----------------------------");
//
//                                    System.out.println("Enter Roll Number of Student You want to set Attendance for");
//                                    int stdid = sc.nextInt();
//
//                                    //Searching for ID
//                                    boolean attflag = false;
//                                    for (int j = 0; j < std_arry.size(); j++)
//                                    {
//                                        if(attflag==true)
//                                        {
//                                            break;
//                                        }
//                                        if (stdid == Student.sid)
//                                        {
//                                            for(int m=0; m<createdCourses.size();m++)
//                                            {
//                                                if(attflag==true)
//                                                {
//                                                    break;
//                                                }
//
//                                                System.out.println("Enter course name to set attendance of: ");
//                                                String an = sc.next();
//                                                while (!attflag)
//                                                {
//                                                    if (an.equalsIgnoreCase(createdCourses.get(m).course_name))
//                                                    {
//                                                        // implementation here
//                                                        attflag = true;
//                                                        std_arry.get(j).std_attendence.tcrse.add(createdCourses.get(m));
//                                                        std_arry.get(j).std_attendence.time.add(new DateANDTime());
//                                                    }
//                                                    else
//                                                    {
//                                                        System.out.println("Enter valid course name!");
//                                                        break;
//                                                    }
//                                                }
//                                            }
//                                        }
//                                        else
//                                        {
//                                            System.out.println("Invalid ID");
//                                        }
//                                    }
//                                    break;
                                        case 5:
                                            System.out.println("Saving changes before logging out...");
                                            FileOutputStream tfos = new FileOutputStream(tfile);
                                            ObjectOutputStream toos = new ObjectOutputStream(tfos);
                                            toos.writeObject(tch_arry);
                                            toos.close();
                                            tloginstatus = false;
                                            System.out.println("Successfully logged out!!");
                                            break;
                                        default:
                                            System.out.println("Enter correct choice!");
                                            break;
                                    }
                                }
                                if(tloginstatus==false)
                                {
                                    break;
                                }
                            }
                        }
                    }
                    break;














                case 3:
                    // ADMIN LOGIN
                    aloginstatus = true;
                    while (aloginstatus)
                    {
                        System.out.println("NOTE: MAKE SURE TO LOG-OUT INORDER TO SAVE ANY MADE CHANGES!!!!!!");
                        System.out.print("1 - Register Student\n2 - Register Teacher\n3 - Set Courses + Credit Hours\n4 - Assign Course to Teacher\n5 - Assign Courses to Student\n6 - Logout\nEnter choice: ");
                        choice = sc.nextInt();
                        switch (choice)
                        {
                            case 1:
                                // Register Student
                                sc.nextLine();
                                System.out.print("Enter first name of student: ");
                                String fname = sc.nextLine();
                                System.out.print("Enter last name of student: ");
                                String lname = sc.nextLine();
                                System.out.print("Enter address of student: ");
                                String address = sc.nextLine();
                                System.out.print("Enter email for student: ");
                                email = sc.nextLine();
                                System.out.print("Enter password for student: ");
                                password = sc.nextLine();
                                System.out.print("Enter ID for student: ");
                                int id = sc.nextInt();
                                sc.nextLine();

                                if(sfile.exists())
                                {
                                    std_arry = null;
                                    FileInputStream ssfis = new FileInputStream(sfile);
                                    ObjectInputStream ssois = new ObjectInputStream(ssfis);
                                    std_arry = (ArrayList<Student>) ssois.readObject();
                                    ssois.close();
                                }
                                else
                                {
                                    System.out.println("Creating a new file");
                                    sfile.createNewFile();
                                }

                                std_arry.add(new Student(fname, lname, email, password, id, address));

                                FileOutputStream sfos = new FileOutputStream(sfile);
                                ObjectOutputStream soos = new ObjectOutputStream(sfos);
                                soos.writeObject(std_arry);
                                soos.close();
                                System.out.println("Successfully registered student!");
                                break;
                            case 2:
                                // Register Teacher
                                sc.nextLine();
                                System.out.print("Enter first name of teacher: ");
                                fname = sc.next();
                                System.out.print("Enter last name of teacher: ");
                                lname = sc.next();
                                sc.nextLine();
                                System.out.print("Enter address of teacher: ");
                                address = sc.nextLine();
                                System.out.print("Enter email for teacher: ");
                                email = sc.next();
                                System.out.print("Enter password for teacher: ");
                                password = sc.next();
                                System.out.print("Enter ID for teacher: ");
                                id = sc.nextInt();
                                System.out.print("Enter department to teacher: ");
                                String tdpt = sc.next();
                                sc.nextLine();

                                if(tfile.exists())
                                {
                                    tch_arry = null;
                                    FileInputStream ttfis = new FileInputStream(tfile);
                                    ObjectInputStream ttois = new ObjectInputStream(ttfis);
                                    tch_arry = (ArrayList<Teacher>) ttois.readObject();
                                    ttois.close();
                                }
                                else
                                {
                                    System.out.println("Creating a new file");
                                    sfile.createNewFile();
                                }

                                tch_arry.add(new Teacher(fname, lname, email, password, id, address, tdpt, false));

                                FileOutputStream tfos = new FileOutputStream(tfile);
                                ObjectOutputStream toos = new ObjectOutputStream(tfos);
                                toos.writeObject(tch_arry);
                                toos.close();
                                System.out.println("Successfully registered teacher!");
                                break;
                            case 3:
                                // SET COURSES + CREDIT HOURS
                                boolean tmp = false;
                                while (!tmp)
                                {
                                    System.out.println("--Courses Menu--");
                                    System.out.println("---------------------------------");
                                    System.out.println("1 - Add Courses");
                                    System.out.println("2 - Delete Courses");
                                    System.out.println("3 - View Courses");
                                    System.out.println("4 - Go Back to Main Menu");
                                    System.out.println("Enter choice: ");
                                    int opt = sc.nextInt();

                                    switch (opt)
                                    {
                                        case 1:
                                            System.out.println("How many courses you want to Add?");
                                            int n = sc.nextInt();
                                            for (int x = 0; x<n; x++)
                                            {
                                                System.out.print("Enter course name: ");
                                                String cname = sc.next();
                                                System.out.print("Enter course credit hours:");
                                                int hours = sc.nextInt();
                                                System.out.print("Enter course code: ");
                                                String ccc = sc.nextLine();
                                                createdCourses.add(new Course(cname, hours, ccc));
                                            }
                                            break;
                                        case 2:
                                            boolean found = false;
                                            while (!found)
                                            {
                                                System.out.println("Enter Name of Course you want to delete: ");
                                                String cname = sc.next();
                                                for (int b = 0; b < createdCourses.size(); b++)
                                                {
                                                    Course tmpcourse = createdCourses.get(b);
                                                    if (cname.equals(tmpcourse.course_name))
                                                    {
                                                        createdCourses.remove(b);
                                                        System.out.println("Course Removed Successfully");
                                                        found = true;
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Course Name Invalid or Course not found");
                                                    }
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("--The Courses--");
                                            System.out.println("                ");
                                            for (int z=0; z<createdCourses.size(); z++)
                                            {
                                                Course course = createdCourses.get(z);
                                                course.disp();
                                            }
                                            break;
                                        case 4:
                                            tmp = true;
                                            // going back to previous menu
                                            break;
                                        default:
                                            System.out.println("Enter correct choice!");

                                    }
                                }
//                            break;
                            case 4:
                                //Assigning Courses to Teachers

                                //Checking if the Teacher Exists
                                boolean found = false;
                                for (int b=0; b<tch_arry.size(); b++)
                                {
                                    System.out.println("Note: Only one course can be assigned to the teacher!");
                                    System.out.println("Enter email of Teacher: ");
                                    String t_email = sc.next();
                                    Teacher tmptch = tch_arry.get(b);
                                    while (!found)
                                    {
                                        if (t_email.equals(tch_arry.get(i).getEmail()))
                                        {
                                            found = true;
                                            System.out.println("Teacher Details:");
                                            tmptch.display();

                                            if (tmptch.tcourse_assigned_status == false)
                                            {
                                                System.out.println("---- Course List ----");
                                                for (int z=0; z<createdCourses.size(); z++)
                                                {
                                                    Course tmpcrse = createdCourses.get(z);
                                                    System.out.println(tmpcrse.course_name);
                                                }
                                                System.out.println("------------------");
                                                System.out.println("Select Any One Course from The Available Courses: ");
                                                String coursename = sc.next();

                                                boolean found1 = false;
                                                for (int s = 0; s < createdCourses.size(); s++)
                                                {
                                                    Course tmpc = createdCourses.get(s);
                                                    if (coursename.equals(tmpc.course_name))
                                                    {
                                                        tmptch.tcourse_assigned_status = true;
                                                        //look into this later if it donesn't work
                                                        tmptch.AssignedCourse = createdCourses.get(s);
                                                        found1 = true;
                                                        break;
                                                    }
                                                }
                                                if (found1)
                                                {
                                                    System.out.println("Course Assigned Successfully");
                                                }
                                                else
                                                {
                                                    System.out.println("Course Name Invalid or Course not Available at the moment");
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("Teacher has already been assigned a course");
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Teacher not Registered or not Found");
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 5:
                                //Assigning Courses to Students
                                System.out.println("Note: The Max Credit Hour Limit is 10");
                                int totalhrs = 0;
                                System.out.println("-----------------------");
                                System.out.println("Enter email of student to assign course: ");
                                String std_email = sc.next();

                                //Checking if Student exists
                                boolean f1 = false;
                                for (int z=0; z<std_arry.size(); z++)
                                {
                                    Student tmps = std_arry.get(z);
                                    if (std_email.equals(tmps.getEmail()))
                                    {
                                        f1 = true;
                                        System.out.println("Student Details");
                                        tmps.display();
                                        System.out.println("------The Course List--------");
                                        for (int y=0; y<createdCourses.size(); y++)
                                        {
                                            Course course = createdCourses.get(y);
                                            System.out.println(course.course_name+"  "+course.hrs);
                                        }
                                        while (totalhrs <10)
                                        {
                                            System.out.println("Assign Course to the Student from the Course List");
                                            String course_title = sc.next();
                                            boolean found22 = false;
                                            for (int s = 0; s < createdCourses.size(); s++)
                                            {
                                                Course course = createdCourses.get(s);
                                                if (course_title.equals(course.course_name))
                                                {
                                                    totalhrs += course.hrs;
                                                    std_arry.get(z).CoursesToStudy.add(createdCourses.get(s));
                                                    found22 = true;
                                                    break;
                                                }
                                            }
                                            if (found22)
                                            {
                                                System.out.println("Course Assigned Successfully");
                                            }
                                            else
                                            {
                                                System.out.println("Invalid course name/Course not found");
                                            }
                                        }
                                        if(totalhrs == 10)
                                        {
                                            System.out.println("Max Credit Hour Limit(10) Reached");
                                        }
                                        else
                                        {
                                            System.out.println("Assign more courses adding upto 10 credit hours!");
                                        }
                                    }
                                }
                                if (!f1)
                                {
                                    System.out.println("Student not Registered or not found");
                                }
                                break;
                            case 6:
                                aloginstatus=false;
                                System.out.println("Logging out...");
                                break;
                            default:
                                System.out.println("Enter correct option!");
                        }
                    }
                    break;
                case 5:
                    // EXIT OUT OF APPLICATION
                    System.out.println("Exiting out of program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct choice!!");
            }
        }
    }
}