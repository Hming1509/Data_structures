
package CircularLinkedList;

import Main.Student;

public class Node {
    private Student data;
    private Node next;

    public Node() {
      
    }

    public Node(Student student) {
        this.data = student;
        this.next = null;
    }

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
}

