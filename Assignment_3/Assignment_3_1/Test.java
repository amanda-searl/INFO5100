public class Test {

	public static void main(String[] args) {		
		Student student1 = new Student("Liming", 01);
		Student student2 = new Student("Ethan", 02);
		Course course1 = new Course("Java");
		course1.registerStudent(student1);
		course1.registerStudent(student2);
		Student[] Students = course1.getStudents();
		for (Student student : Students) {
			System.out.println(student.getName() + ": " + student.getId());
		}
		Student[] students = course1.getStudents();
		System.out.println("Title: " + course1.getTitle());
		System.out.println("Student number: " + course1.getNumberOfStudent());
		System.out.println("is full? " + course1.isFull());
	}
}
