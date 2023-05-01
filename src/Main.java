import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Teacher{
    String f_name;
    String l_name;
    static int id = 3000;
    String dept;

    public Teacher(String f_name, String l_name, String dept) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.dept = dept;
        id++;
    }
    public void display(){
        System.out.println("Teacher ID : "+id);
        System.out.println("Name : "+this.f_name+" "+this.l_name);
        System.out.println("Department : "+this.dept);
    }
}
class Student{
    String F_name;
    String L_name;
    static int id = 7000;
    String address;

    public Student(String f_name, String l_name, String address) {
        F_name = f_name;
        L_name = l_name;
        this.address = address;
        id++;
    }
    public void display(){
        System.out.println("Student ID : "+id);
        System.out.println("Name : "+this.F_name+" "+this.L_name);
        System.out.println("Address : "+this.address);
    }
}
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> stdinfo = new HashMap<>();
        HashMap<String, String> teachinfo = new HashMap<>();
        Student s1[] = new Student[72];
        Teacher t1[] = new Teacher[72];
        int index = 0;
        int index2 = 0;
        int i=0;
        ArrayList<Character> att = new ArrayList<Character>();
        ArrayList<Integer> month = new ArrayList<Integer>();
        ArrayList<Integer> day = new ArrayList<Integer>();
        String email;
        String password;

        while (true)
        {
            System.out.println("---MAIN MENU---\n");
            System.out.print("1 - Login as student\n2 - Login as teacher\n3 - Login as admin\n4 - Feedback\n5 - Exit\nEnter choice: ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    // Student Login
                    System.out.print("Enter your email: ");
                    email = sc.next();
                    System.out.print("Enter your password: ");
                    password = sc.next();

                    HashMap<String, String> stemphashmap = new HashMap<>();

                    try
                    {
                        ObjectInputStream r = new ObjectInputStream(new FileInputStream("stdlogininfo.txt"));
                        stemphashmap = (HashMap<String, String>)r.readObject();
                        r.close();
                    }
                    catch (IOException | ClassNotFoundException e)
                    {
                        System.out.println("Failed to open/find file!");
//                        System.out.println(e);
                    }

                    if (stemphashmap.containsKey(email) && stemphashmap.containsValue(password))
                    {
                        System.out.println("Login successful as student!");
                        while(true){
                            System.out.println("--Student Menu--");
                            System.out.println("1 - View Basic Information");
                            System.out.println("2 - Attendance");
                            System.out.println("3 - View Marks");
                            System.out.println("4 - GPA");
                            System.out.println("5 - Course Feedback");
                            System.out.println("6 - Log Out");
                            int ch2 = sc.nextInt();
                            switch(ch2){
                                case 1: //Basic Info
                                    while(i<index){
                                        s1[i].display();
                                        i++;
                                    }
                                    break;
                                case 2:
                                    System.out.println("**Attendence**");
                                    for(char p: att){
                                        int j=0;
                                        System.out.println("Date: "+month.get(j)+"/"+day.get(j));
                                        System.out.println("Attendence: "+p);
                                        j++;
                                    }
                                case 6:
                                    break;


                            }
                        }
                    }
                    else
                    {
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

                    try
                    {
                        ObjectInputStream r = new ObjectInputStream(new FileInputStream("teachlogininfo.txt"));
                        ttemphashmap = (HashMap<String, String>)r.readObject();
                        r.close();
                    }
                    catch (IOException | ClassNotFoundException e)
                    {
                        System.out.println("Failed to open/find file!");
//                        System.out.println(e);
                    }

                    if (ttemphashmap.containsKey(email) && ttemphashmap.containsValue(password))
                    {
                        System.out.println("Login successful as teacher!");
                        while (true){
                            System.out.println("--Teacher Menu--");
                            System.out.println("1 - View Basic Informtion");
                            System.out.println("2 - Set Attendance");
                            System.out.println("3 - Set Marks");
                            System.out.println("4 - View Course Feedback");
                            System.out.println("5 - Logout");
                            int ch3 = sc.nextInt();
                            switch (ch3){
                                case 1: //Basic Info
                                    while(i<index){
                                        t1[i].display();
                                        i++;
                                    }
                                    break;
                                case 2: //Attendence
                                    System.out.println("List of Students");
                                    while(i<index){
                                        s1[i].display();
                                        i++;
                                    }
                                    System.out.println("----------------------------");
                                    System.out.println("Enter Roll Number of Student You want to set Attendence for");
                                    int stdid = sc.nextInt();
                                    //Searching for ID
                                    for(int j=0;j<index;j++){
                                        if(stdid == s1[i].id){
                                            System.out.println("Date(Date should be between 13 August 2022 to 25 December 2022)");
                                            System.out.println("Enter Month(7-12)");
                                            int month1 = sc.nextInt();
                                            System.out.println("Enter Day(1-31)");
                                            int day1 = sc.nextInt();
                                            if((month1>=7 && month1<=12) && (day1>=1 && day1<=31)){
                                                day.add(day1);
                                                month.add(month1);
                                                System.out.println("Mark P for Present\nMark A for Absent\nMark L for Late");
                                                char attendence= sc.next().charAt(0);
                                                att.add(attendence);
                                            }
                                            else System.out.println("Invalid Date");

                                        }
                                        else System.out.println("Invalid ID");
                                    }
                                    break;
                                default:
                                    break;

                            }
                        }
                    }
                    else
                    {
                        System.out.println("Login failed as teacher!!");
                    }
                    break;
                case 3:
                    //Admin Portal
                    System.out.print("1 - Register Student\n2 - Register Teacher\n3 - Set Courses + Credit Hours\n4 - Assign Courses\nEnter choice: ");
                    choice = sc.nextInt();
                    switch (choice)
                    {
                        case 1:
                            // Register Student
                            int total;
                            System.out.println("Enter First Name of Student");
                            String fname = sc.next();
                            System.out.println("Enter Last Name of Student");
                            String lname = sc.next();
                            System.out.println("Enter Address of Student");
                            String address = sc.nextLine();
                            sc.nextLine();
                            s1[index] = new Student(fname,lname,address);
                            total = index;
                            index++;
                            System.out.print("Enter email for student: ");
                            email = sc.next();
                            System.out.print("Enter password for student: ");
                            password = sc.next();
                            stdinfo.put(email, password);
                            try
                            {
                                ObjectOutputStream w = new ObjectOutputStream(new FileOutputStream("stdlogininfo.txt", true));
                                w.writeObject(stdinfo);
                                w.close();
                            }
                            catch (IOException e)
                            {
                                System.out.println(e);
                            }
                            System.out.println("Successfully registered student!");
                            break;
                        case 2:
                            // Register Teacher
                            int total2;
                            System.out.println("Enter First Name of Teacher");
                            String ftname = sc.next();
                            System.out.println("Enter Last Name of Teacher");
                            String ltname = sc.next();
                            System.out.println("Enter Department of Teacher");
                            String dept = sc.nextLine();
                            sc.nextLine();
                            t1[index2] = new Teacher(ftname,ltname,dept);
                            total2 = index2;
                            index2++;
                            System.out.print("Enter email for teacher: ");
                            email = sc.next();
                            System.out.print("Enter password for teacher: ");
                            password = sc.next();
                            teachinfo.put(email, password);
                            try
                            {
                                ObjectOutputStream w = new ObjectOutputStream(new FileOutputStream("teachlogininfo.txt", true));
                                w.writeObject(teachinfo);
                                w.close();
                            }
                            catch (IOException e)
                            {
                                System.out.println(e);
                            }
                            System.out.println("Successfully registered teacher!");
                            break;
                        default:
                            System.out.println("Enter valid choice!");
                    }
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Exiting out of program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct choice!!");
            }
//            email = null;
//            password = null;
//            stdinfo = null;
//            teachinfo = null;
        }
    }
}