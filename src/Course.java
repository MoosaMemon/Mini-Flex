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
