package Encapsulation;

class Student {
    private String name;
    private int rollNumber;
    private int marks;

    public Student(String name, int rollNumber, int marks) {
        setName(name);
        setRollNumber(rollNumber);
        setMarks(marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name.");
        }
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        if (rollNumber > 0) {
            this.rollNumber = rollNumber;
        } else {
            System.out.println("Invalid roll number.");
        }
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks. Marks should be between 0 and 100.");
        }
    }
}

public class S {
    public static void main(String[] args) {
        Student student = new Student("Alice", 101, 85);

        System.out.println("Initial Student Details:");
        System.out.println("Name: " + student.getName());
        System.out.println("Roll Number: " + student.getRollNumber());
        System.out.println("Marks: " + student.getMarks());

        student.setName("Bob");
        student.setRollNumber(102);
        student.setMarks(95);

        System.out.println("\nUpdated Student Details:");
        System.out.println("Name: " + student.getName());
        System.out.println("Roll Number: " + student.getRollNumber());
        System.out.println("Marks: " + student.getMarks());

        // Attempting to set invalid data using setter methods
        student.setMarks(150); // This should print an error message and not update the marks

        // Accessing data after attempting to set invalid marks
        System.out.println("\nFinal Student Details (After Invalid Marks Attempt):");
        System.out.println("Name: " + student.getName());
        System.out.println("Roll Number: " + student.getRollNumber());
        System.out.println("Marks: " + student.getMarks());
    }
}

