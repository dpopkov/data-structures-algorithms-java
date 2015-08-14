package dsalgjava.ch13.progproj.pp1304;

import java.util.ArrayDeque;
import java.util.Deque;

import dsalgjava.ch13.lst1301.Vertex;

public class GraphWarshall {
    protected final int MAX_VERTS = 20;
    
    protected Vertex[] vertexList;
    protected int[][] adjMat;
    protected int nVerts;
    protected Deque<Integer> stack;
    
    public GraphWarshall() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        stack = new ArrayDeque<>();
    }
    
    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }
    
    public void addEdgeDirected(int start, int end) {
        adjMat[start][end] = 1;
    }
    
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
    
    public void makeTransitiveClosure() {
        for (int r = 0; r < nVerts; r++) {
            for (int c = 0; c < nVerts; c++) {
                if (adjMat[r][c] == 1) {
                    for (int k = 0; k < nVerts; k++) {
                        if (k == r) {
                            continue;
                        }
                        if (adjMat[k][r] == 1) {
                            adjMat[k][c] = 1;
                        }
                    }
                }
            }
        }
    }
    
    public void displayAdjacencyMatrix() {
        System.out.print("  ");
        for (int j = 0; j < nVerts; j++) {
            System.out.print(vertexList[j].label + " ");
        }
        System.out.println();
        for (int k = 0; k < nVerts; k++) {
            System.out.print(vertexList[k].label + " ");
            for (int j = 0; j < nVerts; j++) {
                System.out.print(adjMat[k][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Depth-first search.
     */
    public void dfs(int start) {
        vertexList[start].setVisited(true);
        displayVertex(start);
        stack.push(start);
        
        while (!stack.isEmpty()) {
            int v = findAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].setVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }
        System.out.println();
        resetVisitedVerteces();
    }

    protected void resetVisitedVerteces() {
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].setVisited(false);
        }
    }

    protected int findAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexList[j].isVisited()) {
                return j;
            }
        }
        return -1;
    }
}
