import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Teacher {
    String tfname;
    String tlname;
    static int tid = 3000;
    String tdept;
    boolean t_assigned = false;

    public Teacher(String tfname, String tlname, String tdept) {
        this.tfname = tfname;
        this.tlname = tlname;
        this.tdept = tdept;
        tid++;
    }

    public void display() {
        System.out.println("Teacher ID: " + tid);
        System.out.println("Teacher Name: " + this.tfname + " " + this.tlname);
        System.out.println("Teacher Department: " + this.tdept);
    }
}

class Student {
    String sfname;
    String slname;
    static int sid = 7000;
    String address;

    public Student(String sfname, String slname, String address) {
        this.sfname = sfname;
        this.slname = slname;
        this.address = address;
        sid++;
    }

    public void display() {
        System.out.println("Student ID: " + sid);
        System.out.println("Name: " + this.sfname + " " + this.slname);
        System.out.println("Address: " + this.address);
    }
    public void display2(){
        System.out.println("Student ID: " + sid+"  Name: " + this.sfname + " " + this.slname);
    }
}

class Course {
    static int course_id = 1001;
    String course_name;
    int hrs;
    boolean assigned = false;

    public Course(String course_name, int hrs) {

        course_id++;
        this.course_name = course_name;
        this.hrs = hrs;
    }

    public void disp() {
        System.out.println("Course Name: " + this.course_name + " Course ID: " + course_id + " Credit Hours: " + this.hrs);
    }

}

public class Main {
    public static void CourseMenu() {
        System.out.println("--Courses Menu--");
        System.out.println("---------------------------------");
        System.out.println("1 - Add Courses");
        System.out.println("2 - Delete Courses");
        System.out.println("3 - View Courses");
        System.out.println("4 - Go Back to Main Menu");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> stdinfo = new HashMap<>();
        HashMap<String, String> teachinfo = new HashMap<>();

        ArrayList<Student> s1 = new ArrayList<Student>();
        ArrayList<Teacher> t1 = new ArrayList<Teacher>();
        ArrayList<Course> c1 = new ArrayList<Course>();

        int index = 0;
        int index2 = 0;
        int i = 0;
        ArrayList<Character> att = new ArrayList<Character>();
        ArrayList<Integer> month = new ArrayList<Integer>();
        ArrayList<Integer> day = new ArrayList<Integer>();
        String email;
        String password;

        boolean slogstatus = false;
        boolean tloginstatus = false;

        while (true) {
            System.out.println("---MAIN MENU---\n");
            System.out.print("1 - Login as student\n2 - Login as teacher\n3 - Login as admin\n4 - Feedback\n5 - Exit\nEnter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Student Login
                    System.out.print("Enter your email: ");
                    email = sc.next();
                    System.out.print("Enter your password: ");
                    password = sc.next();

                    HashMap<String, String> stemphashmap = new HashMap<>();

                    try {
                        ObjectInputStream r = new ObjectInputStream(new FileInputStream("stdlogininfo.txt"));
                        stemphashmap = (HashMap<String, String>) r.readObject();
                        r.close();
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Failed to open/find file!");
//                        System.out.println(e);
                    }

                    if (stemphashmap.containsKey(email) && stemphashmap.containsValue(password)) {
                        slogstatus = true;
                        System.out.println("Login successful as student!");
                        while (slogstatus) {
                            System.out.println("--Student Menu--");
                            System.out.println("1 - View Basic Information");
                            System.out.println("2 - Attendance");
                            System.out.println("3 - View Marks");
                            System.out.println("4 - GPA");
                            System.out.println("5 - Course Feedback");
                            System.out.println("6 - Log Out");
                            int ch2 = sc.nextInt();
                            switch (ch2) {
                                case 1: //Basic Info
                                    for (int z = 0; z < s1.size(); z++) {
                                        Student std = s1.get(z);
                                        std.display();
                                    }
                                case 2:
                                    System.out.println("**Attendence**");
                                    for (char p : att) {
                                        int j = 0;
                                        System.out.println("Date: " + month.get(j) + "/" + day.get(j));
                                        System.out.println("Attendence: " + p);
                                        j++;
                                    }
                                case 6:
                                    slogstatus = false;
                                    System.out.println("Successfully logged out!");
                                    break;
                                default:
                                    System.out.println("Enter correct choice!");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Login failed as student!!");
                    }
                    break;
                case 2:
                    // Teacher login
                    System.out.print("Enter your email: ");
                    email = sc.next();
                    System.out.print("Enter your password: ");
                    password = sc.next();

                    HashMap<String, String> ttemphashmap = new HashMap<>();

                    try {
                        ObjectInputStream r = new ObjectInputStream(new FileInputStream("teachlogininfo.txt"));
                        ttemphashmap = (HashMap<String, String>) r.readObject();
                        r.close();
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Failed to open/find file!");
//                        System.out.println(e);
                    }

                    if (ttemphashmap.containsKey(email) && ttemphashmap.containsValue(password)) {
                        tloginstatus = true;
                        System.out.println("Login successful as teacher!");
                        while (tloginstatus) {
                            System.out.println("--Teacher Menu--");
                            System.out.println("1 - View Basic Informtion");
                            System.out.println("2 - Set Attendance");
                            System.out.println("3 - Set Marks");
                            System.out.println("4 - View Course Feedback");
                            System.out.println("5 - Logout");
                            int ch3 = sc.nextInt();
                            switch (ch3) {
                                //Basic Info
                                case 1:
                                    for (int z = 0; z < t1.size(); z++) {
                                        Teacher teacher = t1.get(z);
                                        teacher.display();
                                    }
                                    //Attendance
                                case 2:
                                    System.out.println("List of Students");
                                    for (int z = 0; z < s1.size(); z++) {
                                        Student std = s1.get(z);
                                        std.display();
                                    }
                                    System.out.println("----------------------------");
                                    System.out.println("Enter Roll Number of Student You want to set Attendance for");
                                    int stdid = sc.nextInt();
                                    //Searching for ID
                                    for (int j = 0; j < s1.size(); j++) {
                                        if (stdid == Student.sid) {
                                            System.out.println("Date(Date should be between 13 August 2022 to 25 December 2022)");
                                            System.out.println("Enter Month(7-12)");
                                            int month1 = sc.nextInt();
                                            System.out.println("Enter Day(1-31)");
                                            int day1 = sc.nextInt();
                                            if ((month1 >= 7 && month1 <= 12) && (day1 >= 1 && day1 <= 31)) {
                                                day.add(day1);
                                                month.add(month1);
                                                System.out.println("Mark P for Present\nMark A for Absent\nMark L for Late");
                                                char attendence = sc.next().charAt(0);
                                                att.add(attendence);
                                            } else System.out.println("Invalid Date");

                                        } else System.out.println("Invalid ID");
                                    }
                                    break;
                                case 5:
                                    tloginstatus = false;
                                    System.out.println("Successfully logged out!");
                                    break;
                                default:
                                    System.out.println("Enter correct choice!");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Login failed as teacher!!");
                    }
                    break;
                case 3:
                    //Admin Portal
                    System.out.print("1 - Register Student\n2 - Register Teacher\n3 - Set Courses + Credit Hours\n4 - Assign Course to Teacher\n5 - Assign Courses to Student\n6 - Exit\nEnter choice: ");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            // Register Student

                            System.out.println("Enter First Name of Student");
                            String fname = sc.next();
                            System.out.println("Enter Last Name of Student");
                            String lname = sc.next();
                            System.out.println("Enter Address of Student");
                            String address = sc.nextLine();
                            sc.nextLine();
                            s1.add(new Student(fname, lname, address));
                            System.out.print("Enter email for student: ");
                            email = sc.next();
                            System.out.print("Enter password for student: ");
                            password = sc.next();
                            stdinfo.put(email, password);
                            try {
                                ObjectOutputStream w = new ObjectOutputStream(new FileOutputStream("stdlogininfo.txt", true));
                                w.writeObject(stdinfo);
                                w.close();
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                            System.out.println("Successfully registered student!");
                            break;
                        case 2:
                            // Register Teacher
                            System.out.println("Enter First Name of Teacher");
                            String ftname = sc.next();
                            System.out.println("Enter Last Name of Teacher");
                            String ltname = sc.next();
                            System.out.println("Enter Department of Teacher");
                            String dept = sc.nextLine();
                            sc.nextLine();
                            t1.add(new Teacher(ftname, ltname, dept));
                            System.out.print("Enter email for teacher: ");
                            email = sc.next();
                            System.out.print("Enter password for teacher: ");
                            password = sc.next();
                            teachinfo.put(email, password);
                            try {
                                ObjectOutputStream w = new ObjectOutputStream(new FileOutputStream("teachlogininfo.txt", true));
                                w.writeObject(teachinfo);
                                w.close();
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                            System.out.println("Successfully registered teacher!");
                            break;
                        case 3:
                            //Setting Courses and credit hours respectively
                            while (true) {
                                CourseMenu();
                                int opt = sc.nextInt();
                                if (opt == 1) {
                                    System.out.println("How many courses you want to Add?");
                                    int n = sc.nextInt();
                                    for (int x = 0; x < n; x++) {
                                        System.out.println("Enter Name of Course you want to Add");
                                        String cname = sc.next();
                                        System.out.println("Enter Credit Hours you want to assign to the Course");
                                        int hours = sc.nextInt();
                                        c1.add(new Course(cname, hours));
                                    }
                                } else if (opt == 2) {
                                    System.out.println("Enter Name of Course you want to delete");
                                    String cname = sc.next();
                                    boolean found = false;
                                    for (int b = 0; b < c1.size(); b++) {
                                        Course course = c1.get(b);
                                        if (cname.equals(course.course_name)) {
                                            c1.remove(b);
                                            found = true;
                                            break;
                                        }
                                    }
                                    if (found) {
                                        System.out.println("Course Removed Successfully");
                                    } else {
                                        System.out.println("Course Name Invalid or Course not found");
                                    }
                                } else if (opt == 3) {
                                    System.out.println("--The Courses--");
                                    System.out.println("                ");
                                    for (int z = 0; z < c1.size(); z++) {
                                        Course course = c1.get(z);
                                        course.disp();
                                    }
                                } else if (opt == 4) {
                                    break;
                                } else {
                                    break;
                                }
                            }
                            break;
                        case 4:
                            //Assigning Courses to Teachers
                            System.out.println("Note: Teacher can teach only one course!");
                            System.out.println("Please enter First name of Teacher");
                            String t_name = sc.next();
                            //Checking if the Teacher Exists
                            boolean found1 = false;
                            for (int b = 0; b < t1.size(); b++) {
                                Teacher t2 = t1.get(b);
                                if (t_name.equals(t2.tfname)) {
                                    found1 = true;
                                    System.out.println("Teacher Details:");
                                    t2.display();
                                    if (t2.t_assigned == false) {
                                        System.out.println("Course List");
                                        for (int z = 0; z < c1.size(); z++) {
                                            Course course = c1.get(z);
                                            System.out.println(course.course_name);
                                        }
                                        System.out.println("------------------");
                                        System.out.println("Select Any One Course from The Available Courses");
                                        String coursename = sc.next();
                                        boolean found = false;
                                        for (int s = 0; s < c1.size(); s++) {
                                            Course course = c1.get(s);
                                            if (coursename.equals(course.course_name)) {
                                                course.assigned = true;
                                                t2.t_assigned = true;
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (found) {
                                            System.out.println("Course Assigned Successfully");
                                        } else {
                                            System.out.println("Course Name Invalid or Course not Available at the moment");
                                        }
                                    } else System.out.println("Teacher has already been assigned a course");
                                }
                            }
                            if (!(found1)) {
                                System.out.println("Teacher not Registered or not Found");
                            }


                            break;
                        case 5:
                            //Assigning Courses to Students
                            System.out.println("Note: The Max Credit Hour Limit is 10");
                            int totalhrs = 0;
                            System.out.println("--------------------------------");
                            System.out.println("Student List -->>");
                            for (int z = 0; z < s1.size(); z++) {
                                Student std = s1.get(z);
                                std.display();
                            }
                            System.out.println("-----------------------");
                            System.out.println("Enter ID of student you want to Assign the Courses");
                            int std_id = sc.nextInt();
                            //Checking if Student exists
                            boolean f1 = false;
                            for (int z = 0; z < s1.size(); z++) {
                                Student s5 = s1.get(z);
                                if (std_id == Student.sid) {
                                    f1 = true;
                                    System.out.println("Student Details");
                                    s5.display2();
                                    System.out.println("------The Course List--------");
                                    for (int y = 0; y < c1.size(); y++) {
                                        Course course = c1.get(y);
                                        System.out.println(course.course_name+"  "+course.hrs);
                                    }
                                    while (totalhrs <10) {
                                        System.out.println("Assign Course to the Student from the Course List");
                                        String course_title = sc.next();
                                        boolean found = false;
                                        for (int s = 0; s < c1.size(); s++) {
                                            Course course = c1.get(s);
                                            if (course_title.equals(course.course_name)) {
                                                course.assigned = true;
                                                totalhrs += course.hrs;
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (found)
                                            System.out.println("Course Assigned Successfully");
                                        else System.out.println("Course Name Invalid or Course not Found");
                                    } if(totalhrs == 10) System.out.println("Max Credit Hour Limit(10) Reached");
                                    else System.out.println("Select More Courses until the Max Credit Hour Limit is reached");

                                }
                            }
                            if (!f1)
                                System.out.println("Student not Registered or not found");

                            break;
                        case 6:
                            System.out.println("Exiting out of program...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Enter correct choice!!");
                    }
            }
        }
    }
}