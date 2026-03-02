/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoublyLinkedList;

import Main.Student;

/**
 *
 * @author TienthDung
 */
public class DoublyLinkedList {

    Node head;
    Node tail;

    public boolean insertFirst(Student data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        return true;
    }

    public boolean insertLast(Student data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        return true;
    }

    public Student deleteFirst() {
        if (this.head == null) {
            return null;
        }
        Student data = this.head.data;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            if (this.head != null) {
                this.head.prev = null;
            }
        }
        return data;
    }

    public Student deleteLast() {
        if (this.head == null) {
            return null; 
        }
        Student data = this.tail.data;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            if (this.tail != null) {
                this.tail.next = null;
            }
        }
        return data; 
    }

    public int search(int id) {
        Node current = this.head;
        int index = 0;
        while (current != null) {
            if (current.data.getId() == id) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    
    public Student searchInfo(int id) {
        Node current = this.head;
        int index = 0;
        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
            index++;
        }
        return null;
    }
    
    public void display() {
        if (this.head == null) {
            System.out.println("Doubly Linked List is empty.");
            return;
        }
        Node current = this.head;
        System.out.println("List: ");
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.next;
        } 
    }

    public boolean update(int index, Student newStudent) {
        if (index < 0 || this.head == null) {
            return false;
        }
        Node current = this.head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current != null) {
            current.data = newStudent;
            return true;
        }
        return false;
    }
}
