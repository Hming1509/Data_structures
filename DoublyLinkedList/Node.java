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
class Node {

    Student data;
    Node prev;
    Node next;

    public Node(Student data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
