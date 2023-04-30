import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> stdinfo = new HashMap<>();
        HashMap<String, String> teachinfo = new HashMap<>();

        String email;
        String password;

        while (true)
        {
            System.out.println("---MAIN MENU---\n");
            System.out.print("1 - Login as student\n2 - Login as teacher\n3 - Login as admin\n4 - feedback\n5 - Exit\nEnter choice: ");
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
                    }
                    else
                    {
                        System.out.println("Login failed as teacher!!");
                    }
                    break;
                case 3:
                    //Admin Portal
                    System.out.print("1 - Register Student\n2 - Register Teacher\nEnter choice: ");
                    choice = sc.nextInt();
                    switch (choice)
                    {
                        case 1:
                            // Register Student
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