package it.unibo.generics.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N>{

    private Map<N, Set<N>> nodeMap = new HashMap<N, Set<N>>();

    // Adds a node: nothing happens if node is null or already there
    public void addNode(N node){
        nodeMap.put(node, new TreeSet<>());
    }
    
    // Adds an edge: nothing happens if source or target are null
    public void addEdge(N source, N target){
        nodeMap.get(source).add(target);
    }
        
    // Returns all the nodes
    public Set<N> nodeSet(){
        return nodeMap.keySet();
    }
        
    // Returns all the nodes directly targeted from node
    public Set<N> linkedNodes(N node){
        return nodeMap.get(node);
    }

    // DFS to find a path from start to goal
    public List<N> dfs(N surce, N target) {
        List<N> path = new ArrayList<>();
        Set<N> visited = new TreeSet<>();
        if (dfsUtil(surce, target, visited, path)) {
            return path;
        }
        return Collections.emptyList(); // return empty if no path is found
    }

    private boolean dfsUtil(N current, N target, Set<N> visited, List<N> path) {
        visited.add(current);
        path.add(current);

        if (current == target) {
            return true;
        }

        for (N neighbor : nodeMap.get(current)) {
            if (!visited.contains(neighbor)) {
                if (dfsUtil(neighbor, target, visited, path)) {
                    return true;
                }
            }
        }

        return false;
    }
            
    // Gets one sequence of nodes connecting source to path
    public List<N> getPath(N source, N target){
        return dfs(source, target);
    }
}
