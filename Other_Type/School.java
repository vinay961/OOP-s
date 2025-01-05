package Other_Type;

abstract class Person{
    protected String name;
    protected int ID;

    public Person(String name, int ID){
        this.name = name;
        this.ID = ID;
    }

    public abstract void DisplayInfo();
}

class Student extends Person{
    private double grade;
    private int attendance;

    public Student(String name, int ID){
        super(name, ID);
        this.grade = 0;
        this.attendance = 0;
    }

    public void updateGrade(double grade){
        this.grade = grade;
    }

    public void markAttendence(){
        attendance++;
    }

    @Override
    public void DisplayInfo(){
        System.out.println("Student Name: " + name + ", ID: " + ID + ", Grade: " + grade + ", Attendance: " + attendance);
    }
}

class Teacher extends Person{
    public Teacher(String name, int ID){
        super(name, ID);
    }

    public void assignGrade(Student student, double grade){
        student.updateGrade(grade);
        System.out.println("Assigned grade " + grade + " to " + student.name);
    }

    public void markStudentAttendance(Student student){
        student.markAttendence();
        System.out.println("Marked attendance for " + student.name);
    }

    @Override
    public void DisplayInfo(){
        System.out.println("Teacher Name: " + name + ", ID: " + ID);
    }
}

public class School {
    public static void main(String[] args) {
        Student s1 = new Student("Vinay", 101);
        Teacher t1 = new Teacher("Mrs. Janhavi", 1);

        t1.assignGrade(s1, 85.5);
        t1.markStudentAttendance(s1);

        System.out.println("\n--- Info ---");
        t1.DisplayInfo();
        s1.DisplayInfo();
    }
}
