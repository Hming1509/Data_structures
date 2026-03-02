/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SLL;
import Main.Student;

/**
 *
 * @author TienthDung
 */
class Node {
    Student data; 
    Node next;

    public Node(Student data) {
        this.data = data;
        this.next = null;
    }
}
