/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stack;

import Main.Student; // Import Student

/**
 *
 * @author TienthDung
 */
public class Singly_Stack {

    private Node head;
    private int size;

    public Singly_Stack() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;

        size++;
        System.out.println("Pushed Student ID: " + student.getId());
    }

    public Student pop() {
        if (isEmpty()) {
            System.out.println("[!] Error: Stack is empty.");
            return null;
        }

        Student poppedStudent = head.data;

        head = head.next;

        size--;
        System.out.println("Popped Student ID: " + poppedStudent.getId());
        return poppedStudent;
    }

    public Student pop1() {
        if (isEmpty()) {
            return null;
        }
        Student st = head.data;
        head = head.next;
        size--;
        return st;
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("[!] Error: Stack is empty.");
            return null;
        }
        return head.data;
    }

    public Student peek1() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Current Stack (Top -> Bottom - by ID): ");
        Node current = head;
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.next;
//            if (current != null) {
//                System.out.print(" -> ");
//            }
        }
        System.out.println();
    }
}
