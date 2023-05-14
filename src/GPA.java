import java.io.Serializable;

public class GPA implements Marks
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

    public GPA(double ass1, double ass2, double quiz1, double quiz2, double mid1, double mid2, double finalexam) {
        this.ass1 = ass1;
        this.ass2 = ass2;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.mid1 = mid1;
        this.mid2 = mid2;
        this.finalexam = finalexam;
    }

    @Override
    public double totalmarks() {
        double sum = this.ass1 + this.ass2 + this.quiz1 + this.quiz2 + this.mid1 + this.mid2+this.finalexam;

        return sum;
    }
}
