package Array;
import Main.Student; 
import java.util.ArrayList;
import java.util.List;

public class Dynamic_Array {
    private List<Student> data;
    public Dynamic_Array() {
        this.data = new ArrayList<>();
    }

    public void insertFirst(Student student) {
        this.data.add(0, student);
        System.out.println("Inserted first Student ID: " + student.getId());
    }

    public void insertLast(Student student) {
        this.data.add(student);
        System.out.println("Inserted last Student ID: " + student.getId());
    }

    public Student deleteFirst() {
        if (data.isEmpty()) {
            System.out.println("Error: Array is empty. Cannot delete first.");
            return null;
        }

        Student deletedStudent = this.data.remove(0); 
        System.out.println("Deleted first Student ID: " + deletedStudent.getId());
        return deletedStudent;
    }

    public Student deleteLast() {
        if (data.isEmpty()) {
            System.out.println("Error: Array is empty. Cannot delete last.");
            return null;
        }
        
        Student deletedStudent = this.data.remove(data.size() - 1);
        System.out.println("Deleted last Student ID: " + deletedStudent.getId());
        return deletedStudent;
    }
    
    public boolean update(int oldId, Student newStudent) {
        int index = search(oldId, false); 

        if (index != -1) {
            this.data.set(index, newStudent);
            System.out.println("Updated Student ID " + oldId + " to new Student ID " + newStudent.getId() + " at index " + index);
            return true;
        }
        System.out.println("Student with ID " + oldId + " not found for update.");
        return false;
    }

    private int search(int id, boolean printOutput) {
        for (int i = 0; i < data.size(); i++) {
            if (this.data.get(i).getId() == id) { 
                if (printOutput) {
                    System.out.println("Found Student ID " + id + " at index " + i + ". Name: " + this.data.get(i).getName());
                }
                return i;
            }
        }
        if (printOutput) {
            System.out.println("Student with ID " + id + " not found.");
        }
        return -1;
    }
    
    public int search(int id) {
        return search(id, true);
    }

    public void display() {
        if (data.isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.println("Current Array (Size " + data.size() + " - IDs): ");
        for (Student s : data) {
            System.out.println(s.toString());
        }
    }
}