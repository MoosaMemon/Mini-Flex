import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Scanner sc = new Scanner(System.in);
        File sfile = new File("std_info.ser");
        File tfile = new File("tch_info.ser");
        File cfile = new File("crse_info.ser");

        ArrayList<Student> std_arry = new ArrayList<Student>();
        ArrayList<Teacher> tch_arry = new ArrayList<Teacher>();
        ArrayList<Course> createdCourses = new ArrayList<Course>();

        Teacher tmptch = null;

        if(sfile.exists())
        {
            FileInputStream sfis = new FileInputStream(sfile);
            ObjectInputStream sois = new ObjectInputStream(sfis);
            ArrayList<Student> tmpstds = (ArrayList<Student>) sois.readObject();
            sois.close();
            sfis.close();
            std_arry = tmpstds;
            tmpstds = null;
        }
        if(tfile.exists())
        {
            FileInputStream tfis = new FileInputStream(tfile);
            ObjectInputStream tois = new ObjectInputStream(tfis);
            ArrayList<Teacher> tmptchs = (ArrayList<Teacher>) tois.readObject();
            tois.close();
            tfis.close();
            tch_arry = tmptchs;
            tmptchs = null;
        }
        if(cfile.exists())
        {
            FileInputStream cfis = new FileInputStream(cfile);
            ObjectInputStream cois = new ObjectInputStream(cfis);
            ArrayList<Course> tmpcrs = (ArrayList<Course>) cois.readObject();
            cois.close();
            cfis.close();
            createdCourses = tmpcrs;
            tmpcrs = null;
        }

        int i = 0;

        String email;
        String password;

        boolean slogstatus = false;
        boolean tloginstatus = false;
        boolean aloginstatus = false;

        while (true)
        {
            System.out.println("\n--- HOME PAGE ---\n");
            System.out.print("1 - Login as student\n2 - Login as teacher\n3 - Login as admin\n4 - Exit\nEnter choice: ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    // STUDENT LOGIN
                    if(!sfile.exists())
                    {
                        System.out.println("\nFailed to proceed! Register a student first.");
                        break;
                    }
                    if(!cfile.exists())
                    {
                        System.out.println("\nFailed to proceed! Enroll in a course first!");
                        break;
                    }

                    System.out.print("\nEnter your email: ");
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
                                System.out.println("\nLogin successful as student!");
                                System.out.println("NOTE: MAKE SURE TO LOG OUT INORDER TO SAVE ANY MADE CHANGES!!!!!!");
                                while (slogstatus)
                                {
                                    System.out.println("\n---- STUDENT MENU ----");
                                    System.out.println("1 - View Basic Information");
                                    System.out.println("2 - View Attendance");
                                    System.out.println("3 - View Marks");
                                    System.out.println("4 - GPA");
                                    System.out.println("5 - Give course feedback");
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
                                            sc.nextLine();
                                            System.out.print("\nEnter course name to view attendance of: ");
                                            String ch9 = sc.nextLine();

//                                            System.out.println(std_arry.get(b).std_attendence.tcrse.size());
                                            for(int g=0; g<std_arry.get(b).std_attendence.tcrse.size(); g++)
                                            {
                                                if(std_arry.get(b).std_attendence.tcrse.get(g).course_name.trim().equalsIgnoreCase(ch9.trim()))
                                                {
                                                    System.out.println("\nAttendance marked for: " + std_arry.get(b).std_attendence.tcrse.get(g).course_name);
                                                    std_arry.get(b).std_attendence.time.get(g).display();
                                                }
                                            }
                                            break;
                                        case 3:
                                            sc.nextLine();
                                            System.out.print("\nEnter the course name to view marks of: ");
                                            String tcrs = sc.nextLine();

                                            for(int f=0;f<std_arry.get(b).std_acdem.CourseDetails.size(); f++)
                                            {
                                                if(std_arry.get(b).std_acdem.CourseDetails.get(f).course_name.trim().equalsIgnoreCase(tcrs.trim()))
                                                {
                                                    System.out.println("Transcript for course: " + std_arry.get(b).std_acdem.CourseDetails.get(f).course_name);
                                                    std_arry.get(b).std_acdem.CourseMarks.get(f).display();
                                                }
                                            }
                                            break;
                                        case 4:
                                            break;
                                        case 5:
                                            System.out.print("\nEnter course name to give feedback of: ");
                                            String cnn = sc.next();
                                            for(int d=0; d<std_arry.get(b).CoursesToStudy.size(); d++)
                                            {
                                                if(std_arry.get(b).CoursesToStudy.get(d).course_name.trim().equalsIgnoreCase(cnn.trim()))
                                                {
                                                    sc.nextLine();
                                                    System.out.print("\nEnter course feedback: ");
                                                    String tmpfdbk = sc.nextLine();
                                                    std_arry.get(b).CourseFeedback.add(tmpfdbk);
                                                    System.out.println("Successfully given course feedback!!");
                                                    break;
                                                }
                                            }
                                            break;
                                        case 6:
                                            System.out.println("\nSaving changes before logging out...");
                                            FileOutputStream sfos = new FileOutputStream(sfile);
                                            ObjectOutputStream soos = new ObjectOutputStream(sfos);
                                            soos.writeObject(std_arry);
                                            soos.close();
                                            sfos.close();
                                            slogstatus = false;
                                            System.out.println("Successfully logged out!!");
                                            break;
                                        default:
                                            System.out.println("Enter correct choice!!\n");
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
                    if(!tfile.exists())
                    {
                        System.out.println("\nFailed to proceed! Register a teacher first.");
                        break;
                    }
                    if(!cfile.exists())
                    {
                        System.out.println("\nFailed to proceed! Get assigned a course first!");
                        break;
                    }

                    System.out.print("\nEnter your email: ");
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
                                System.out.println("\nLogin successful as teacher!");
                                System.out.println("NOTE: MAKE SURE TO LOG OUT INORDER TO SAVE ANY MADE CHANGES!!!!!!");
                                while (tloginstatus)
                                {
                                    System.out.println("\n---- TEACHER MENU ----");
                                    System.out.println("1 - View Basic Information");
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
                                            break;
                                        case 2:
                                            //Set Attendance
                                            System.out.print("\nEnter ID of student to set attendance for: ");
                                            int stdid = sc.nextInt();

                                            //Searching for ID
                                            boolean attflag = false;
                                            for (int j=0; j<std_arry.size(); j++)
                                            {
                                                if(attflag==true)
                                                {
                                                    break;
                                                }
                                                if (stdid == std_arry.get(j).getID())
                                                {
//                                                    System.out.println("\nStudent Found!!");
                                                    for(int x=0; x<std_arry.get(j).CoursesToStudy.size(); x++)
                                                    {
                                                        if(std_arry.get(j).CoursesToStudy.get(x).course_name.equalsIgnoreCase(tch_arry.get(d).AssignedCourse.course_name))
                                                        {
                                                            attflag = true;
                                                            std_arry.get(j).std_attendence.tcrse.add(tch_arry.get(d).AssignedCourse);
                                                            std_arry.get(j).std_attendence.time.add(new CurrentDateANDTime());
                                                            System.out.println("Attendance marked successfully!");
                                                            break;
                                                        }
                                                    }
                                                }
                                                else
                                                {
                                                    System.out.println("Invalid ID!");
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.print("\nEnter roll number of student to set marks for: ");
                                            int studentid = sc.nextInt();
                                            for (int j=0; j<std_arry.size(); j++)
                                            {
                                                if (studentid == std_arry.get(j).getID())
                                                {
//                                                    System.out.println("Student Found!!");
                                                    boolean validation = false;
                                                    while (true)
                                                    {
                                                        System.out.println("\n---Assign marks----");
                                                        System.out.print("Input marks of assignment-1 (Max:5): ");
                                                        double ass1 = sc.nextDouble();
                                                        System.out.print("Input marks of assignment-2 (Max:5): ");
                                                        double ass2 = sc.nextDouble();
                                                        System.out.print("Input marks of quiz-1 (Max:5): ");
                                                        double quiz1 = sc.nextDouble();
                                                        System.out.print("Input marks of quiz-2 (Max:5): ");
                                                        double quiz2 = sc.nextDouble();
                                                        System.out.print("Input marks of mid-1 (Max:15): ");
                                                        double mid1 = sc.nextDouble();
                                                        System.out.print("Input marks of mid-2 (Max:15): ");
                                                        double mid2 = sc.nextDouble();
                                                        System.out.print("Input marks of final exam (Max:50): ");
                                                        double f = sc.nextDouble();
                                                        if (ass1 <=5 || ass2 <=5 || quiz1 <=5 || quiz2 <=5 || mid1 <=15 || mid2 <=15 || f <=50)
                                                        {
                                                            validation = true;

                                                        }
                                                        if(validation == true)
                                                        {
                                                            std_arry.get(j).std_acdem.CourseMarks.add(new GPA(ass1, ass2, quiz1, quiz2, mid1, mid2, f));
                                                            std_arry.get(j).std_acdem.CourseDetails.add(tch_arry.get(d).AssignedCourse);
                                                            break;
                                                        }
                                                        else
                                                        {
                                                            System.out.println("Marks of one or more components is invalid, please input again!\n");
                                                        }
                                                    }
                                                    System.out.println("----------------------------");
                                                    System.out.println("\nAssigning GPA and marks...");
                                                    for(int z = 0;z<std_arry.get(j).std_acdem.CourseMarks.size();z++)
                                                    {
                                                        GPA g1 = std_arry.get(j).std_acdem.CourseMarks.get(z);
                                                        if (g1.totalmarks()>86)
                                                        {
                                                            g1.grade = "A+";
                                                            g1.gpa = 4;
                                                        }
                                                        else if(g1.totalmarks()==86)
                                                        {
                                                            g1.grade = "A";
                                                            g1.gpa = 4;
                                                        }
                                                        else if(g1.totalmarks()>=82 && g1.totalmarks()<86)
                                                        {
                                                            g1.grade = "A-";
                                                            g1.gpa = 3.67;
                                                        }
                                                        else if(g1.totalmarks()>=78 && g1.totalmarks()<82)
                                                        {
                                                            g1.grade = "B+";
                                                            g1.gpa = 3.33;
                                                        }
                                                        else if(g1.totalmarks()>=74 && g1.totalmarks()<78)
                                                        {
                                                            g1.grade = "B";
                                                            g1.gpa = 3.00;
                                                        }
                                                        else if(g1.totalmarks()>=70 && g1.totalmarks()<74)
                                                        {
                                                            g1.grade = "B-";
                                                            g1.gpa = 2.67;
                                                        }
                                                        else if(g1.totalmarks()>=66 && g1.totalmarks()<70)
                                                        {
                                                            g1.grade = "C+";
                                                            g1.gpa = 2.33;
                                                        }
                                                        else if(g1.totalmarks()>=62 && g1.totalmarks()<66)
                                                        {
                                                            g1.grade = "C";
                                                            g1.gpa = 2;
                                                        }
                                                        else if(g1.totalmarks()>=58 && g1.totalmarks()<62)
                                                        {
                                                            g1.grade = "C-";
                                                            g1.gpa = 1.67;
                                                        }
                                                        else if(g1.totalmarks()>=54 && g1.totalmarks()<58)
                                                        {
                                                            g1.grade = "D";
                                                            g1.gpa = 1.33;
                                                        }
                                                        else
                                                        {
                                                            g1.grade = "F";
                                                            g1.gpa = 1;
                                                        }
                                                        System.out.println("Successfully assigned GPA and marks. ");
                                                    }
                                                }
                                                else
                                                {
                                                    System.out.println("\nStudent not Found/invalid ID!\n");
                                                }
                                            }
                                            break;
                                        case 4:
                                            System.out.print("\nEnter roll number of the student to view feedback of: ");
                                            int rnn = sc.nextInt();
                                            for(int k=0;k<std_arry.size(); k++)
                                            {
                                                if(rnn == std_arry.get(k).getID())
                                                {
                                                    for(int f=0; f<std_arry.get(k).CoursesToStudy.size(); f++)
                                                    {
                                                        if(tch_arry.get(d).AssignedCourse.course_name.trim().equalsIgnoreCase(std_arry.get(k).CoursesToStudy.get(f).course_name.trim()))
                                                        {
                                                            System.out.println("\nFeedback: " + std_arry.get(k).CourseFeedback.get(f));
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        case 5:
                                            System.out.println("\nSaving changes before logging out...");
                                            FileOutputStream tfos = new FileOutputStream(tfile);
                                            ObjectOutputStream toos = new ObjectOutputStream(tfos);
                                            toos.writeObject(tch_arry);
                                            toos.close();
                                            tfos.close();
                                            tloginstatus = false;
                                            System.out.println("Successfully logged out!!");
                                            break;
                                        default:
                                            System.out.println("Enter correct choice!\n");
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
                        System.out.println("\nNOTE: MAKE SURE TO LOG-OUT INORDER TO SAVE ANY MADE CHANGES!!!!!!");
                        System.out.println("---- MAIN MENU OF ADMIN PANEL ----");
                        System.out.print("\n1 - Register Student\n2 - Register Teacher\n3 - Set Courses + Credit Hours\n4 - Assign Course to Teacher\n5 - Assign Courses to Student\n6 - Logout\nEnter choice: ");
                        choice = sc.nextInt();
                        switch (choice)
                        {
                            case 1:
                                // Register Student
                                sc.nextLine();
                                System.out.print("\nEnter first name of student: ");
                                String fname = sc.nextLine();
                                System.out.print("Enter last name of student: ");
                                String lname = sc.nextLine();
                                System.out.print("Enter address of student: ");
                                String address = sc.nextLine();
                                System.out.print("Enter email for student: ");
                                email = sc.nextLine();
                                System.out.print("Enter password for student: ");
                                password = sc.nextLine();
                                System.out.print("Enter department for student: ");
                                String dep = sc.nextLine();
                                System.out.print("Enter ID for student: ");
                                int id = sc.nextInt();

                                if(sfile.exists())
                                {
                                    std_arry = null;
                                    FileInputStream ssfis = new FileInputStream(sfile);
                                    ObjectInputStream ssois = new ObjectInputStream(ssfis);
                                    std_arry = (ArrayList<Student>) ssois.readObject();
                                    ssois.close();
                                    ssfis.close();
                                }
                                else
                                {
//                                    System.out.println("\nCreating a new file!");
                                    sfile.createNewFile();
                                }

                                std_arry.add(new Student(fname, lname, email, password, id, address, dep));

                                FileOutputStream sfos = new FileOutputStream(sfile);
                                ObjectOutputStream soos = new ObjectOutputStream(sfos);
                                soos.writeObject(std_arry);
                                soos.close();
                                sfos.close();
                                System.out.println("\nSuccessfully registered student!");
                                break;
                            case 2:
                                // Register Teacher
                                sc.nextLine();
                                System.out.print("\nEnter first name of teacher: ");
                                fname = sc.next();
                                System.out.print("Enter last name of teacher: ");
                                lname = sc.next();
                                sc.nextLine();
                                System.out.print("Enter address of teacher: ");
                                address = sc.nextLine();
                                System.out.print("Enter email for teacher: ");
                                email = sc.next();
                                sc.nextLine();
                                System.out.print("Enter password for teacher: ");
                                password = sc.next();
                                System.out.print("Enter ID for teacher: ");
                                id = sc.nextInt();
                                System.out.print("Enter department to teacher: ");
                                String tdpt = sc.next();

                                if(tfile.exists())
                                {
                                    tch_arry = null;
                                    FileInputStream ttfis = new FileInputStream(tfile);
                                    ObjectInputStream ttois = new ObjectInputStream(ttfis);
                                    tch_arry = (ArrayList<Teacher>) ttois.readObject();
                                    ttois.close();
                                    ttfis.close();
                                }
                                else
                                {
                                    System.out.println("\nCreating a new file");
                                    sfile.createNewFile();
                                }

                                tch_arry.add(new Teacher(fname, lname, email, password, id, address, tdpt, false));

                                FileOutputStream tfos = new FileOutputStream(tfile);
                                ObjectOutputStream toos = new ObjectOutputStream(tfos);
                                toos.writeObject(tch_arry);
                                toos.close();
                                tfos.close();
                                System.out.println("\nSuccessfully registered teacher!");
                                break;
                            case 3:
                                // CREATE COURSES + CREDIT HOURS
                                boolean tmp = false;
//                                sc.nextLine();
                                while (!tmp)
                                {
                                    System.out.println("\n---- Courses Menu ----");
                                    System.out.println("\n1 - Add Courses");
                                    System.out.println("2 - Delete Courses");
                                    System.out.println("3 - View Courses");
                                    System.out.println("4 - Previous menu");
                                    System.out.print("Enter choice: ");
                                    int opt = sc.nextInt();

                                    switch (opt)
                                    {
                                        case 1:
                                            sc.nextLine();
                                            System.out.print("\nEnter course name: ");
                                            String cname = sc.nextLine();
                                            System.out.print("Enter course credit hours: ");
                                            int hours = sc.nextInt();
                                            sc.nextLine();
                                            System.out.print("Enter course code: ");
                                            String ccc = sc.nextLine();

                                            if(cfile.exists())
                                            {
                                                createdCourses = null;
                                                FileInputStream cfis = new FileInputStream(cfile);
                                                ObjectInputStream cois = new ObjectInputStream(cfis);
                                                createdCourses = (ArrayList<Course>) cois.readObject();
                                                cois.close();
                                                cfis.close();
                                            }
                                            else
                                            {
                                                System.out.println("Creating a new file");
                                                sfile.createNewFile();
                                            }

                                            createdCourses.add(new Course(cname, hours, ccc));

                                            FileOutputStream cfos = new FileOutputStream(cfile);
                                            ObjectOutputStream coos = new ObjectOutputStream(cfos);
                                            coos.writeObject(createdCourses);
                                            coos.close();
                                            cfos.close();
                                            System.out.println("\nSuccessfully registered course!");
                                            break;
                                        case 2:
                                            if(!cfile.exists())
                                            {
                                                System.out.println("\nRegister a course first!!");
                                                break;
                                            }
                                            sc.nextLine();
                                            boolean found = false;
                                            boolean notfound = true;
                                            while (!found)
                                            {
                                                System.out.print("\nEnter name of course to delete: ");
                                                String cn = sc.next();
                                                for (int b=0; b<createdCourses.size(); b++)
                                                {
                                                    Course tmpcourse = createdCourses.get(b);
                                                    if (cn.equals(tmpcourse.course_name))
                                                    {
                                                        createdCourses.remove(b);
                                                        System.out.println("\nCourse removed successfully!!");
                                                        found = true;
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        System.out.println("\nCourse name invalid/course not found!");
                                                        notfound = false;
                                                        break;
                                                    }
                                                }
                                                if(!notfound)
                                                {
                                                    break;
                                                }
                                            }
                                            break;
                                        case 3:
                                            if(!cfile.exists())
                                            {
                                                System.out.println("\nRegister a course first!!");
                                                break;
                                            }
                                            System.out.println("\n---- Registered courses ----");
                                            for (int z=0; z<createdCourses.size(); z++)
                                            {
                                                Course course = createdCourses.get(z);
                                                course.display();
                                                System.out.print("----------------\n");
                                            }
                                            break;
                                        case 4:
                                            tmp = true;
                                            // going back to previous menu
                                            break;
                                        default:
                                            System.out.println("\nEnter correct choice!\n");
                                    }
                                }
                                break;
                            case 4:
                                //Assigning Courses to Teachers
                                sc.nextLine();
                                if(!cfile.exists())
                                {
                                    System.out.println("\nFailed to proceed! Register a course first.");
                                    break;
                                }
                                if(!tfile.exists())
                                {
                                    System.out.println("\nFailed to proceed! Register a teacher first.");
                                    break;
                                }

                                //Checking if the Teacher Exists
                                boolean found = false;
                                for (int b=0; b<tch_arry.size(); b++)
                                {
                                    System.out.println("Note: only one course can be assigned to the teacher!");
                                    System.out.print("Enter email of Teacher: ");
                                    String tmpemail = sc.next();
                                    while (!found)
                                    {
                                        if (tmpemail.equals(tch_arry.get(b).getEmail()))
                                        {
                                            found = true;

                                            if (!tch_arry.get(b).tcourse_assigned_status)
                                            {
                                                System.out.print("Enter course name to assign: ");
                                                String coursename = sc.next();

                                                boolean found1 = false;
                                                for (int s=0; s<createdCourses.size(); s++)
                                                {
                                                    if (coursename.trim().equalsIgnoreCase(createdCourses.get(s).course_name.trim()))
                                                    {
                                                        tch_arry.get(b).tcourse_assigned_status = true;
                                                        //look into this later if it donesn't work
                                                        tch_arry.get(b).AssignedCourse = createdCourses.get(s);
                                                        found1 = true;
                                                        break;
                                                    }
                                                }
                                                if (found1)
                                                {
                                                    System.out.println("Course assigned successfully");
                                                    break;
                                                }
                                                else
                                                {
                                                    System.out.println("Course name invalid/course not available at the moment");
                                                    break;
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("Teacher has already been assigned a course");
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Teacher not registered/not found");
                                            break;
                                        }
                                    }
                                    if(found)
                                    {
                                        break;
                                    }
                                }
                                break;
                            case 5:
                                //Assigning Courses to Students
                                sc.nextLine();
                                if(!cfile.exists())
                                {
                                    System.out.println("Failed to proceed! Register a course first.");
                                    break;
                                }
                                if(!sfile.exists())
                                {
                                    System.out.println("\nFailed to proceed! Register a student first.");
                                    break;
                                }

                                System.out.print("\nEnter email of student to assign course: ");
                                String std_email = sc.next();

                                //Checking if Student exists
                                boolean f1 = false;
                                boolean found22 = false;
                                for (int z=0; z<std_arry.size(); z++)
                                {
                                    if (std_email.trim().equalsIgnoreCase(std_arry.get(z).getEmail().trim()))
                                    {
                                        f1 = true;
                                        System.out.println("------The Course List--------");
                                        for (int y=0; y<createdCourses.size(); y++)
                                        {
                                            createdCourses.get(y).display();
                                            System.out.println();
                                        }
                                        System.out.println("---------------------");

                                        System.out.print("Select a course from above: ");
                                        String course_title = sc.next();

                                        for (int s=0; s<createdCourses.size(); s++)
                                        {
                                            if (course_title.trim().equalsIgnoreCase(createdCourses.get(s).course_name.trim()))
                                            {
                                                std_arry.get(z).CoursesToStudy.add(createdCourses.get(s));
                                                found22 = true;
                                                System.out.println("Course assigned successfully");
                                                break;
                                            }
                                            else
                                            {
                                                System.out.println("Invalid course name/course not found");
                                                found22 = false;
                                                break;
                                            }
                                        }
                                    }
                                    if(found22)
                                    {
                                        break;
                                    }
                                }
                                break;
                            case 6:
                                System.out.println("Saving changes before logging out...");

                                // saving changes made to students
                                if(sfile.exists())
                                {
                                    FileOutputStream sfoss = new FileOutputStream(sfile);
                                    ObjectOutputStream sooss = new ObjectOutputStream(sfoss);
                                    sooss.writeObject(std_arry);
                                    sooss.close();
                                    sfoss.close();
                                }

                                //saving changes made to teachers
                                if(tfile.exists())
                                {
                                    FileOutputStream tfoss = new FileOutputStream(tfile);
                                    ObjectOutputStream tooss = new ObjectOutputStream(tfoss);
                                    tooss.writeObject(tch_arry);
                                    tooss.close();
                                    tfoss.close();
                                }

                                // saving changes made to courses
                                if(cfile.exists())
                                {
                                    FileOutputStream cfos = new FileOutputStream(cfile);
                                    ObjectOutputStream coos = new ObjectOutputStream(cfos);
                                    coos.writeObject(createdCourses);
                                    coos.close();
                                    cfos.close();
                                }

                                aloginstatus=false;
                                System.out.println("Successfully logged out");
                                break;
                            default:
                                System.out.println("Enter correct option!");
                        }
                    }
                    break;
                case 4:
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