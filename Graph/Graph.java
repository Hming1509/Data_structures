/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import Main.Student; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author TienthDung
 */
public class Graph {

    private Map<Integer, Student> students; 
    private Map<Integer, Set<Integer>> adj;

    public Graph(Map<Integer, Student> students, Map<Integer, Set<Integer>> adj) {
        this.students = students;
        this.adj = adj;
    }

    public Graph() {
        this.students = new HashMap<>();
        this.adj = new HashMap<>();
    }

    public void addVertex(Student student) {
        int id = student.getId();
        if (students.containsKey(id)) {
            System.out.println("[!] Error: Vertex (Student ID " + id + ") already exists.");
            return;
        }
        students.put(id, student);
        adj.put(id, new HashSet<>());
        System.out.println("Successfully added vertex (Student ID): " + id);
    }

    public void removeVertex(int id) {
        if (!students.containsKey(id)) {
            System.out.println("[!] Error: Vertex (Student ID " + id + ") not found.");
            return;
        }

        for (int neighborId : adj.keySet()) {
            adj.get(neighborId).remove(id);
        }

        students.remove(id);
        adj.remove(id);
        System.out.println("Successfully removed vertex (Student ID): " + id);
    }

    public void updateVertex(int oldId, Student newStudent) {
        if (!students.containsKey(oldId)) {
            System.out.println("[!] Error: Vertex (Student ID " + oldId + ") not found.");
            return;
        }
        int newId = newStudent.getId();
        if (students.containsKey(newId) && oldId != newId) {
            System.out.println("[!] Error: New Student ID " + newId + " already exists.");
            return;
        }

        Set<Integer> neighbors = adj.get(oldId);
        students.remove(oldId);
        adj.remove(oldId);

        students.put(newId, newStudent);
        adj.put(newId, neighbors);

        if (oldId != newId) {
             for (int neighborId : neighbors) {
                if (adj.containsKey(neighborId)) {
                    adj.get(neighborId).remove(oldId);
                    adj.get(neighborId).add(newId);
                }
            }
        }
       
        System.out.println("Updated vertex (Student ID " + oldId + " to " + newId + ") successfully.");
    }

    public void addEdge(int id1, int id2) {
        if (!students.containsKey(id1) || !students.containsKey(id2)) {
            System.out.println("[!] Error: One or both vertices are not found.");
            return;
        }

        adj.computeIfAbsent(id1, k -> new HashSet<>()).add(id2);
        adj.computeIfAbsent(id2, k -> new HashSet<>()).add(id1);
        System.out.println("Connected (IDs): " + id1 + " <-> " + id2);
    }

    public void removeEdge(int id1, int id2) {
        if (!students.containsKey(id1) || !students.containsKey(id2)) {
            System.out.println("[!] Error: One or both vertices are not found.");
            return;
        }

        if (adj.containsKey(id1)) adj.get(id1).remove(id2);
        if (adj.containsKey(id2)) adj.get(id2).remove(id1);
        System.out.println("Disconnected (IDs): " + id1 + " -/- " + id2);
    }

    public boolean contains(int id) {
        return students.containsKey(id);
    }

    public List<Integer> dfs(int startId) {
        List<Integer> result = new ArrayList<>();
        if (!students.containsKey(startId)) {
            System.out.println("[!] Error: Starting vertex (ID " + startId + ") not found! DFS unsuccessful!");
            return result;
        }
        Set<Integer> visited = new HashSet<>();
        dfsHelper(startId, visited, result);
        return result;
    }

    private void dfsHelper(int id, Set<Integer> visited, List<Integer> result) {
        visited.add(id);
        result.add(id);

        Set<Integer> sortedNeighbors = new TreeSet<>(adj.get(id));
        
        for (int neighborId : sortedNeighbors) {
            if (!visited.contains(neighborId)) {
                dfsHelper(neighborId, visited, result);
            }
        }
    }

    public List<Integer> bfs(int startId) {
        List<Integer> result = new ArrayList<>();
        if (!students.containsKey(startId)) {
            System.out.println("[!] Error: Starting vertex (ID " + startId + ") not found! BFS unsuccessful!");
            return result;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startId);
        queue.add(startId);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);

            Set<Integer> sortedNeighbors = new TreeSet<>(adj.get(u));

            for (int neighborId : sortedNeighbors) {
                if (!visited.contains(neighborId)) {
                    visited.add(neighborId);
                    queue.add(neighborId);
                }
            }
        }
        return result;
    }

    public void showAll() {
        if (students.isEmpty()) {
            System.out.println("[!] Graph is empty!");
            return;
        }

        System.out.println("\n--- Current Student Graph (by ID) ---");
        
        List<Integer> sortedVertices = new ArrayList<>(students.keySet());
        Collections.sort(sortedVertices);
        
        for (int vertexId : sortedVertices) {
            Set<Integer> neighbors = adj.get(vertexId);
            
            List<Integer> sortedNeighborIds = new ArrayList<>(neighbors);
            Collections.sort(sortedNeighborIds);
            
            String conn = sortedNeighborIds.isEmpty() ? "None" : sortedNeighborIds.toString();
            Student student = students.get(vertexId);
            String name = (student != null) ? student.getName() : "N/A";
            
            System.out.println("Vertex ID " + vertexId + " (Name: " + name + ") | Edges to IDs: " + conn);
        }
        System.out.println("-----------------------------");
    }
}