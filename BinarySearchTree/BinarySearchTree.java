
package BinarySearchTree;
import Main.Student;


public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(Student student) {
        this.root = insertRec(this.root, student);
    }

    private Node insertRec(Node root, Student student) {
        if (root == null) {
            root = new Node(student);
            return root;
        }
        
        if (student.getId() < root.getData().getId()) {
            root.setLeft(insertRec(root.getLeft(), student));
        } else if (student.getId() > root.getData().getId()) {
            root.setRight(insertRec(root.getRight(), student));
        } else {
            System.out.println("Student with ID: " + student.getId() + " is already existed!");
        }
        return root;
    }

    private Node findMin(Node root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

    public void delete(int id) {
        root = deleteRec(this.root, id);
    }

    private Node deleteRec(Node root, int id) {
        if (root == null) {
            return null;
        }
        
        int rootId = root.getData().getId();

        if (id < rootId) {
            root.setLeft(deleteRec(root.getLeft(), id));
        } else if (id > rootId) {
            root.setRight(deleteRec(root.getRight(), id));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            
            Node successor = findMin(root.getRight());
            
            root.setData(successor.getData()); 
            root.setRight(deleteRec(root.getRight(), successor.getData().getId()));
        }
        return root;
    }

    public boolean update(int oldId, Student newStudent) {
        Node node = search(root, oldId);
        if (node != null) {
            node.setData(newStudent);
            System.out.println("Update successfully: Changed Student with ID " + oldId + " to Student ID " + newStudent.getId());
            return true;
        } else {
            System.out.println("Not found Student with ID: " + oldId);
            return false;
        }
    }


    public Student search(int id) {
        Node resultNode = search(root, id);
        if (resultNode != null) {
            // Giả định Student có toString() hoặc hiển thị ID
            System.out.println("Found Student ID: " + resultNode.getData().getId() + " | Name: " + resultNode.getData().getName());
            return resultNode.getData();
        } else {
            System.out.println("Student with ID " + id + " not found.");
            return null;
        }
    }
    
    private Node search(Node root, int id) {
        if (root == null || root.getData().getId() == id) {
            return root;
        }
        if (id < root.getData().getId()) {
            return search(root.getLeft(), id);
        }
        return search(root.getRight(), id);
    }

    public void inOrder() {
        System.out.println("BST (In-Order by ID): ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.getLeft());
            System.out.println(root.getData().toString());
            inOrderRec(root.getRight());
        }
    }

    public void preOrder() {
        System.out.println("BST (Pre-Order by ID): ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            // Hiển thị ID
            System.out.println(root.getData().toString());
            preOrderRec(root.getLeft());
            preOrderRec(root.getRight());
        }
    }
    
    public void postOrder() {
        System.out.println("BST (Post-Order by ID): ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.getLeft());
            postOrderRec(root.getRight());
            System.out.println(root.getData().toString());
        }
    }
}