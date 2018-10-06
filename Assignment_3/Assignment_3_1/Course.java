
import java.util.Arrays;
import java.util.List;

public class Course {

	private static final int MAXIMUM_STUDENT_NUM = 10;

	private String title;
	private int numberOfStudent;
	private Student[] students = new Student[MAXIMUM_STUDENT_NUM];

	public Course(String title) {
		this.title = title;
	}

	public Course() {}
	
	public void setTitle(String title) {
		this.title = title;		
	}

	public String getTitle() {
		return title;
	}

	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

	public int getNumberOfStudent() {
		return numberOfStudent;
	}

    public Student[] getStudents() {
    	// return students;
    	Student[] pointer = new Student[numberOfStudent];
	        for (int i = 0; i < numberOfStudent; i++) {
	            pointer[i] = students[i];
	        }
        return pointer;
    }

	public boolean isFull() {
		if (numberOfStudent == MAXIMUM_STUDENT_NUM) {
			return true;
		} else {
			return false;
		}
	}

	public void registerStudent(Student student) {
		if (isFull()) {
			System.out.println("Register Failed! Course is full");
		} 
		else {
			students[numberOfStudent] = student;
			numberOfStudent++;
			System.out.println("Register Succeed!");
		}
	}

}
