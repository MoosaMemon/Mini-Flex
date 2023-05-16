import java.io.Serializable;

public class GPA implements Marks, Serializable
{
    double ass1;
    double ass2;
    double quiz1;
    double quiz2;
    double mid1;
    double mid2;
    double finalexam;
    double gpa;
    double cgpa;
    String grade;

    public GPA(double ass1, double ass2, double quiz1, double quiz2, double mid1, double mid2, double finalexam)
    {
        this.ass1 = ass1;
        this.ass2 = ass2;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.mid1 = mid1;
        this.mid2 = mid2;
        this.finalexam = finalexam;
    }

    @Override
    public double totalmarks()
    {
        double sum = this.ass1 + this.ass2 + this.quiz1 + this.quiz2 + this.mid1 + this.mid2+this.finalexam;
        return sum;
    }
    void display()
    {
        System.out.println("Assignment-1: " + this.ass1);
        System.out.println("Assignment-2: " + this.ass2);
        System.out.println("Quiz-1: " + this.quiz1);
        System.out.println("Quiz-2: " + this.quiz2);
        System.out.println("Mid-1: " + this.mid1);
        System.out.println("Mid-2: " + this.mid2);
        System.out.println("Final Exam: " + this.finalexam);
        System.out.println("Grand total: " + this.totalmarks());
        System.out.println("GPA: " + this.gpa);

    }

}
