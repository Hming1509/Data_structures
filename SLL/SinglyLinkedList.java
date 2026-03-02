/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SLL;

import Main.Student; // Import Student

/**
 *
 * @author TienthDung
 */

public class SinglyLinkedList {
    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void insertFirst(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("Inserted first Student ID: " + student.getId());
    }

    public void insertLast(Student student) {
        Node newNode = new Node(student);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Inserted last Student ID: " + student.getId());
    }

    public Student deleteFirst() {
        if (isEmpty()) {
            System.out.println("[!] Error: List is empty. Cannot delete first.");
            return null;
        }
        Student deletedStudent = head.data;
        head = head.next;
        size--;
        System.out.println("Deleted first Student ID: " + deletedStudent.getId());
        return deletedStudent;
    }

    public Student deleteLast() {
        if (isEmpty()) {
            System.out.println("[!] Error: List is empty. Cannot delete last.");
            return null;
        }

        Student deletedStudent;
        if (head.next == null) {
            deletedStudent = head.data;
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            deletedStudent = current.next.data;
            current.next = null;
        }
        size--;
        System.out.println("Deleted last Student ID: " + deletedStudent.getId());
        return deletedStudent;
    }

    public boolean update(int oldId, Student newStudent) {
        Node current = head;
        while (current != null) {
            if (current.data.getId() == oldId) { 
                current.data = newStudent;
                System.out.println("Updated Student ID " + oldId + " to new Student ID " + newStudent.getId());
                return true;
            }
            current = current.next;
        }
        System.out.println("Student with ID " + oldId + " not found for update.");
        return false;
    }

    public Student search(int id) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.getId() == id) { 
                System.out.println("Found Student ID " + id + " at index " + index + ".");
                System.out.println(current.data.toString());
                return current.data;
            }
            current = current.next;
            index++;
        }
        System.out.println("Student with ID " + id + " not found.");
        return null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Current Singly Linked List (IDs): ");
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