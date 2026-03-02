/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

import Main.Student; // Import Student

/**
 *
 * @author TienthDung
 */
public class Circular_Queue {
    private Node tail;
    private int size;

    public Circular_Queue() {
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(Student student) {
        Node newNode = new Node(student);
        if (isEmpty()) {
            tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Enqueued Student ID: " + student.getId());
    }

    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("[!] Error: Queue is empty.");
            return null; 
        }
        
        Student removedStudent = tail.next.data;

        if (tail == tail.next) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }

        size--;
        System.out.println("Dequeued Student ID: " + removedStudent.getId());
        return removedStudent;
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("[!] Error: Queue is empty.");
            return null;
        }
        return tail.next.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        
        System.out.println("Current Queue (Front to Rear - by ID): ");
        Node current = tail.next;
        
        do {
            System.out.println(current.data.toString()); 
            current = current.next;
//            if (current != tail.next) {
//                System.out.print(" -> ");
//            }
        } while (current != tail.next);
        
        System.out.println();
    }
}