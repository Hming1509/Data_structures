
package Main;

import java.util.Scanner;
import Array.Dynamic_Array;
import SLL.SinglyLinkedList;
import BinarySearchTree.BinarySearchTree;
import CircularLinkedList.CircularLinkedList;
import DoublyLinkedList.DoublyLinkedList;
import Queue.Circular_Queue;
import Stack.Singly_Stack;
import Graph.Graph;
import java.util.ArrayList;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        int choice;
        do {
            System.out.println("\n===== DATA STRUCTURE MANAGEMENT MENU (STUDENT ID MODE) =====");
            System.out.println("1. Array");
            System.out.println("2. SinglyLinkedList");
            System.out.println("3. BinarySearchTree");
            System.out.println("4. Circular_Queue");
            System.out.println("5. Singly_Stack");
            System.out.println("6. Graph");
            System.out.println("7. DoublyLinkedList");
            System.out.println("8. CircularLinkedList");
            System.out.println("0. Exit");
            System.out.print("Select data structure to test (0-8): ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println("-----------------------------------------");

                switch (choice) {
                    case 1:
                        testArray();
                        break;
                    case 2:
                        testSinglyLinkedList();
                        break;
                    case 3:
                        testBinarySearchTree();
                        break;
                    case 4:
                        testCircularQueue();
                        break;
                    case 5:
                        testSinglyStack();
                        break;
                    case 6:
                        testGraph();
                        break;
                    case 7:
                        testDoublyLinkedList(); 
                        break;
                    case 8: 
                        testCircularLinkedList();
                    case 0:
                        System.out.println("Exiting program. Goodbye!");
                        break;
                    default:
                        System.out.println("[!] Invalid choice. Please select again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("[!] Error: Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    public static Student getStudentInput(int id) {
        String name = "";
        Double score = 0.0;
        try {
            System.out.print("Enter Student Name for ID " + id + ": ");
            name = scanner.nextLine();
            System.out.print("Enter Student Score for ID " + id + ": ");
            score = scanner.nextDouble();
            scanner.nextLine(); 
        } catch (java.util.InputMismatchException e) {
            System.out.println("[!] Error: Invalid score input. Using score 0.0.");
            scanner.nextLine();
        }
        return new Student(id, name, score);
    }

    public static void testArray() {
        Dynamic_Array arr = new Dynamic_Array();
        int choice;

        do {
            System.out.println("\n----- ARRAY TEST MENU (STUDENT ID) -----");
            System.out.println("1. insertFirst");
            System.out.println("2. insertLast");
            System.out.println("3. deleteFirst");
            System.out.println("4. deleteLast");
            System.out.println("5. update (by ID)");
            System.out.println("6. search (by ID)");
            System.out.println("7. display");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select operation (0-7): ");

            try {
                choice = scanner.nextInt();
                System.out.println("-----------------------------------------");
                scanner.nextLine(); // Consume newline after choice

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID to insert at head: ");
                        int id1 = scanner.nextInt();
                        scanner.nextLine();
                        arr.insertFirst(getStudentInput(id1));
                        break;
                    case 2:
                        System.out.print("Enter Student ID to insert at tail: ");
                        int id2 = scanner.nextInt();
                        scanner.nextLine();
                        arr.insertLast(getStudentInput(id2));
                        break;
                    case 3:
                        arr.deleteFirst();
                        break;
                    case 4:
                        arr.deleteLast();
                        break;
                    case 5:
                        System.out.print("Enter OLD Student ID to update: ");
                        int oldId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter NEW Student ID: ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        Student newStudentData = getStudentInput(newId);
                        arr.update(oldId, newStudentData);
                        break;
                    case 6:
                        System.out.print("Enter Student ID to search: ");
                        arr.search(scanner.nextInt());
                        break;
                    case 7:
                        arr.display();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("[!] Invalid choice. Please select again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("[!] Error: Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    public static void testSinglyLinkedList() {
        SinglyLinkedList list = new SinglyLinkedList();
        int choice;

        do {
            System.out.println("\n----- SINGLY LINKED LIST TEST MENU (STUDENT ID) -----");
            System.out.println("1. insertFirst");
            System.out.println("2. insertLast");
            System.out.println("3. deleteFirst");
            System.out.println("4. deleteLast");
            System.out.println("5. update (by ID)");
            System.out.println("6. search (by ID)");
            System.out.println("7. display");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select operation (0-7): ");

            try {
                choice = scanner.nextInt();
                System.out.println("-----------------------------------------");
                scanner.nextLine(); // Consume newline after choice

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID to insert at head: ");
                        int id1 = scanner.nextInt();
                        scanner.nextLine();
                        list.insertFirst(getStudentInput(id1));
                        break;
                    case 2:
                        System.out.print("Enter Student ID to insert at tail: ");
                        int id2 = scanner.nextInt();
                        scanner.nextLine();
                        list.insertLast(getStudentInput(id2));
                        break;
                    case 3:
                        Student deletedFirst = list.deleteFirst();
                        if (deletedFirst != null) {
                            System.out.println("Deleted Student ID: " + deletedFirst.getId());
                        }
                        break;
                    case 4:
                        Student deletedLast = list.deleteLast();
                        if (deletedLast != null) {
                            System.out.println("Deleted Student ID: " + deletedLast.getId());
                        }
                        break;
                    case 5:
                        System.out.print("Enter OLD Student ID to update: ");
                        int oldId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter NEW Student ID: ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        Student newStudentData = getStudentInput(newId);
                        list.update(oldId, newStudentData);
                        break;
                    case 6:
                        System.out.print("Enter Student ID to search: ");
                        list.search(scanner.nextInt());
                        break;
                    case 7:
                        list.display();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("[!] Invalid choice. Please select again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("[!] Error: Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    public static void testBinarySearchTree() {
        BinarySearchTree bst = new BinarySearchTree();
        int choice;

        do {
            System.out.println("\n----- BINARY SEARCH TREE TEST MENU (STUDENT ID) -----");
            System.out.println("1. insert");
            System.out.println("2. delete (by ID)");
            System.out.println("3. update (by ID)");
            System.out.println("4. search (by ID)");
            System.out.println("5. inOrder Traversal");
            System.out.println("6. preOrder Traversal");
            System.out.println("7. postOrder Traversal"); 
            System.out.println("0. Back to Main Menu");
            System.out.print("Select operation (0-7): ");

            try {
                choice = scanner.nextInt();
                System.out.println("-----------------------------------------");
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID to insert: ");
                        int insertId = scanner.nextInt();
                        scanner.nextLine();
                        Student studentToInsert = getStudentInput(insertId);
                        bst.insert(studentToInsert);
                        break;
                    case 2:
                        System.out.print("Enter Student ID to delete: ");
                        bst.delete(scanner.nextInt());
                        break;
                    case 3:
                        System.out.print("Enter OLD Student ID to update: ");
                        int oldId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter NEW Student ID: ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        Student newStudentData = getStudentInput(newId);
                        bst.update(oldId, newStudentData);
                        break;
                    case 4:
                        System.out.print("Enter Student ID to search: ");
                        bst.search(scanner.nextInt());
                        break;
                    case 5:
                        bst.inOrder();
                        break;
                    case 6:
                        bst.preOrder();
                        break;
                    case 7: 
                        bst.postOrder();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("[!] Invalid choice. Please select again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("[!] Error: Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    public static void testCircularQueue() {
        Circular_Queue queue = new Circular_Queue();
        int choice;

        do {
            System.out.println("\n----- CIRCULAR QUEUE TEST MENU (STUDENT ID) -----");
            System.out.println("1. enqueue");
            System.out.println("2. dequeue");
            System.out.println("3. peek");
            System.out.println("4. display");
            System.out.println("5. size");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select operation (0-5): ");

            try {
                choice = scanner.nextInt();
                System.out.println("-----------------------------------------");
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID to enqueue: ");
                        int id1 = scanner.nextInt();
                        scanner.nextLine();
                        queue.enqueue(getStudentInput(id1));
                        break;
                    case 2:
                        Student dequeued = queue.dequeue();
                        if (dequeued != null) {
                            System.out.println("Dequeued Student ID: " + dequeued.getId());
                        }
                        break;
                    case 3:
                        Student peeked = queue.peek();
                        if (peeked != null) {
                            System.out.println("Front element: " + peeked.toString());
                        }
                        break;
                    case 4:
                        queue.display();
                        break;
                    case 5:
                        System.out.println("Current size: " + queue.size());
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("[!] Invalid choice. Please select again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("[!] Error: Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    public static void testSinglyStack() {
        Singly_Stack stack = new Singly_Stack();
        int choice;

        do {
            System.out.println("\n----- Singly_ STACK TEST MENU (STUDENT ID) -----");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. display");
            System.out.println("5. size");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select operation (0-5): ");

            try {
                choice = scanner.nextInt();
                System.out.println("-----------------------------------------");
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID to push: ");
                        int id1 = scanner.nextInt();
                        scanner.nextLine();
                        stack.push(getStudentInput(id1));
                        break;
                    case 2:
                        Student popped = stack.pop();
                        if (popped != null) {
                            System.out.println("Popped Student ID: " + popped.toString());
                        }
                        break;
                    case 3:
                        Student peeked = stack.peek();
                        if (peeked != null) {
                            System.out.println("Top element (peek ID): " + peeked.toString());
                        }
                        break;
                    case 4:
                        stack.display();
                        break;
                    case 5:
                        System.out.println("Current size: " + stack.size());
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("[!] Invalid choice. Please select again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("[!] Error: Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    public static void testGraph() {
        Graph graph = new Graph();
        int choice;

        do {
            System.out.println("\n----- GRAPH TEST MENU (STUDENT ID) -----");
            System.out.println("1. addVertex");
            System.out.println("2. removeVertex (by ID)");
            System.out.println("3. updateVertex (by ID)");
            System.out.println("4. addEdge (by ID)");
            System.out.println("5. removeEdge (by ID)");
            System.out.println("6. contains (by ID)");
            System.out.println("7. dfs (Depth First Search - by ID)");
            System.out.println("8. bfs (Breadth First Search - by ID)");
            System.out.println("9. showAll (IDs only)");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select operation (0-9): ");

            try {
                choice = scanner.nextInt();
                System.out.println("-----------------------------------------");
                scanner.nextLine();
                int id1, id2, oldId, newId;
                Student newS;

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID to add: ");
                        id1 = scanner.nextInt();
                        scanner.nextLine();
                        graph.addVertex(getStudentInput(id1));
                        break;
                    case 2:
                        System.out.print("Enter Student ID to remove: ");
                        id1 = scanner.nextInt();
                        scanner.nextLine();
                        graph.removeVertex(id1);
                        break;
                    case 3:
                        System.out.print("Enter OLD Student ID: ");
                        oldId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter NEW Student ID: ");
                        newId = scanner.nextInt();
                        scanner.nextLine();
                        newS = getStudentInput(newId);
                        graph.updateVertex(oldId, newS);
                        break;
                    case 4:
                        System.out.print("Enter Student ID 1: ");
                        id1 = scanner.nextInt();
                        System.out.print("Enter Student ID 2: ");
                        id2 = scanner.nextInt();
                        scanner.nextLine();
                        graph.addEdge(id1, id2);
                        break;
                    case 5:
                        System.out.print("Enter Student ID 1: ");
                        id1 = scanner.nextInt();
                        System.out.print("Enter Student ID 2: ");
                        id2 = scanner.nextInt();
                        scanner.nextLine();
                        graph.removeEdge(id1, id2);
                        break;
                    case 6:
                        System.out.print("Enter Student ID to check: ");
                        id1 = scanner.nextInt();
                        scanner.nextLine();
                        boolean found = graph.contains(id1);
                        System.out.println(found ? "Vertex exists." : "Vertex does not exist.");
                        break;
                    case 7:
                        System.out.print("Enter start Student ID for DFS: ");
                        int startDfs = scanner.nextInt();
                        System.out.println("DFS result (IDs): " + graph.dfs(startDfs));
                        break;
                    case 8:
                        System.out.print("Enter start Student ID for BFS: ");
                        int startBfs = scanner.nextInt();
                        System.out.println("BFS result (IDs): " + graph.bfs(startBfs));
                        break;
                    case 9:
                        graph.showAll();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("[!] Invalid choice. Please select again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("[!] Error: Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }
    
    public static void testDoublyLinkedList() {
        DoublyLinkedList list = new DoublyLinkedList();
        int choice;

        do {
            System.out.println("\n----- DOUBLY LINKED LIST TEST MENU (STUDENT ID) -----");
            System.out.println("1. insertFirst");
            System.out.println("2. insertLast");
            System.out.println("3. deleteFirst");
            System.out.println("4. deleteLast");
            System.out.println("5. update (by Index)");
            System.out.println("6. search (by ID)");
            System.out.println("7. display");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select operation (0-7): ");

            try {
                choice = scanner.nextInt();
                System.out.println("-----------------------------------------");
                scanner.nextLine(); // Consume newline after choice

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID to insert at head: ");
                        int id1 = scanner.nextInt();
                        scanner.nextLine();
                        list.insertFirst(getStudentInput(id1));
                        break;
                    case 2:
                        System.out.print("Enter Student ID to insert at tail: ");
                        int id2 = scanner.nextInt();
                        scanner.nextLine();
                        list.insertLast(getStudentInput(id2));
                        break;
                    case 3:
                        Student deletedFirst = list.deleteFirst();
                        if (deletedFirst != null) {
                            System.out.println("Deleted Student ID: " + deletedFirst.getId());
                        } else {
                            System.out.println("List is empty. Cannot delete.");
                        }
                        break;
                    case 4:
                        Student deletedLast = list.deleteLast();
                        if (deletedLast != null) {
                            System.out.println("Deleted Student ID: " + deletedLast.getId());
                        } else {
                            System.out.println("List is empty. Cannot delete.");
                        }
                        break;
                    case 5:
                        System.out.print("Enter Index to update: ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter NEW Student ID for index " + index + ": ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        Student newStudentData = getStudentInput(newId);
                        list.update(index, newStudentData);
                        break;
                    case 6:
                        System.out.print("Enter Student ID to search: ");
                        int searchId = scanner.nextInt();
                        int foundIndex = list.search(searchId);
                        if (foundIndex != -1) {
                            System.out.println("Student ID " + searchId + " found at Index: " + foundIndex);
                            Student result = list.searchInfo(searchId);
                            if (result != null) {
                                System.out.println(result);
                            }
                        } else {
                            System.out.println("Student ID " + searchId + " not found.");
                        }
                        break;
                    case 7:
                        list.display();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("[!] Invalid choice. Please select again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("[!] Error: Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    public static void testCircularLinkedList() {
        CircularLinkedList list = new CircularLinkedList();
        int choice;

        do {
            System.out.println("\n----- Circular LINKED LIST TEST MENU (STUDENT ID) -----");
            System.out.println("1. insertFirst");
            System.out.println("2. insertLast");
            System.out.println("3. deleteFirst");
            System.out.println("4. deleteLast");
            System.out.println("5. update (by Index)");
            System.out.println("6. search (by Name)");
            System.out.println("7. display");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select operation (0-7): ");

            try {
                choice = scanner.nextInt();
                System.out.println("-----------------------------------------");
                scanner.nextLine(); // Consume newline after choice

                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID to insert at head: ");
                        int id1 = scanner.nextInt();
                        scanner.nextLine();
                        list.insertFirst(getStudentInput(id1));
                        break;
                    case 2:
                        System.out.print("Enter Student ID to insert at tail: ");
                        int id2 = scanner.nextInt();
                        scanner.nextLine();
                        list.insertLast(getStudentInput(id2));
                        break;
                    case 3:
                        Student deletedFirst = list.deleteFirst();
                        if (deletedFirst != null) {
                            System.out.println("Deleted Student ID: " + deletedFirst.getId());
                        } else {
                            System.out.println("List is empty. Cannot delete.");
                        }
                        break;
                    case 4:
                        Student deletedLast = list.deleteLast();
                        if (deletedLast != null) {
                            System.out.println("Deleted Student ID: " + deletedLast.getId());
                        } else {
                            System.out.println("List is empty. Cannot delete.");
                        }
                        break;
                    case 5:
                        System.out.print("Enter Index to update: ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter NEW Student ID for index " + index + ": ");
                        int newId = scanner.nextInt();
                        scanner.nextLine();
                        Student newStudentData = getStudentInput(newId);
                        list.updateById(index, newStudentData);
                        break;
                    case 6:
                        System.out.print("Enter Student Name to search: ");
                        String searchName = scanner.nextLine();
                        ArrayList<Student> foundNames = list.searchByName(searchName);
                        if (foundNames != null && !foundNames.isEmpty()) {
                            for (Student foundName : foundNames) {
                                System.out.println(foundName);;
                            }
                        } else {
                            System.out.println("Student Name " + searchName + " not found.");
                        }
                        break;
                    case 7:
                        list.display();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("[!] Invalid choice. Please select again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("[!] Error: Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }
}
