
package CircularLinkedList;

import Main.Student;
import java.util.ArrayList;

public class CircularLinkedList {
    private Node tail;
    int count = 0;

    public CircularLinkedList(Node tail) {
        this.tail = tail;
    }

    public CircularLinkedList() {
        this.tail = null;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    
    public void display() {
        Node temp = this.tail;
        try {
            if (temp == null) {
                System.out.println("Empty list^^");
            } else {
                System.out.println("The number of record(s): " + count);
                // Bắt đầu từ head (tail.getNext())
                Node head = this.tail.getNext();
                Node current = head;
                do {
                    System.out.println(current.getData().toString() + " ");
                    current = current.getNext();
                } while (current != head); // Lặp cho đến khi quay lại head
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    // Phương thức chèn (Insert) - Sử dụng Student.getId() (giả định trả về int)
    public void insertFirst(Student Data) {
        try {
            if (searchByID(Data.getId()) != null) {
                System.out.println("ID alredy existed!");
            } else {
                Node newNode = new Node(Data);
                if (this.tail == null) {
                    this.tail = newNode;
                    this.tail.setNext(this.tail);
                    count++;
                    System.out.println("Student successfully added^^");
                } else {
                    newNode.setNext(this.tail.getNext());
                    this.tail.setNext(newNode);
                    count++;
                    System.out.println("Student successfully added^^");
                }
            }
        } catch (Exception e) {
        }
    }
    
    // Phương thức chèn (Insert) - Sử dụng Student.getId() (giả định trả về int)
    public void insertLast(Student Data) {
        try {
            if (searchByID(Data.getId()) != null) {
                System.out.println("ID alredy existed!");
            } else {
                Node newNode = new Node(Data);
                if (this.tail == null) {
                    this.tail = newNode;
                    this.tail.setNext(this.tail);
                    count++;
                    System.out.println("Student successfully added^^");
                } else {
                    newNode.setNext(this.tail.getNext());
                    this.tail.setNext(newNode);
                    this.tail = newNode;
                    count++;
                    System.out.println("Student successfully added^^");
                }
            }
        } catch (Exception e) {
        }
    }
    
    // Các phương thức xóa (không liên quan trực tiếp đến kiểu ID)
    public Student deleteFirst() {
        Student s = null;
        try {
            if (this.tail == null) {
                s = null;
            } else if (this.tail.getNext() == this.tail) {
                s = this.tail.getData();
                this.tail = null;
                count--;
            } else {
                s = this.tail.getNext().getData();
                this.tail.setNext(this.tail.getNext().getNext());
                count--;
            }
        } catch (Exception e) {
        }
        return s;
    }
    
    public Student deleteLast() {
        Student s = null;
        try {
            if (this.tail == null) {
                s = null;
            } else if (this.tail.getNext() == this.tail) {
                s = this.tail.getData();
                this.tail = null;
                count--;
            } else {
                s = this.tail.getData();
                Node current = this.tail.getNext();
                // Tìm node trước tail
                while (current.getNext() != tail) {
                    current = current.getNext();
                }
                current.setNext(this.tail.getNext());
                this.tail = current;
                count--;
            }
        } catch (Exception e) {
        }
        return s;
    }
    
    // Phương thức tìm kiếm theo Tên (không thay đổi)
    public ArrayList<Student> searchByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        if (this.tail == null) {
            // Không cần gán result = null, chỉ cần trả về danh sách rỗng
            return result; 
        } else {
            Node temp = this.tail.getNext();
            do {
                if (temp.getData().getName().contains(name)) {
                    result.add(temp.getData());
                }
                temp = temp.getNext();
            } while (temp != this.tail.getNext());
        }
        return result;
    }    
    
    // Phương thức tìm kiếm theo ID - Thay đổi tham số từ String thành int
    public Student searchByID(int id) {
        Student s = null;
        if (this.tail != null) { 
            Node temp = this.tail.getNext(); 
            do {
                // So sánh ID kiểu int
                if (temp.getData().getId() == id) { 
                    s = temp.getData();
                    break; 
                }
                temp = temp.getNext();
            } while (temp != this.tail.getNext()); 
        }
        return s;
    }
    
    // Phương thức cập nhật - Thay đổi tham số từ String thành int
    public boolean updateById(int id, Student newData) {
        boolean check = false;
        if (this.tail == null) {
            check = false;
        } else {
            Node current = this.tail.getNext();
            do {
                // So sánh ID kiểu int
                if (current.getData().getId() == id) { 
                    current.setData(newData);
                    check = true;
                    break;
                }
                current = current.getNext();
            } while (current != this.tail.getNext());
        }
        return check;
    }
}

