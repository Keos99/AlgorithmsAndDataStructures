package GeekUniversity.Java.Lesson7HW;

import GeekUniversity.Java.Lesson3HW.Queue;
import GeekUniversity.Java.Lesson3HW.Stack;



public class Graph {
    private class Vertex {
        public char label;
        Vertex pre;
        public boolean wasVisited;

        public Vertex(char label) {
            this.label = label;
            wasVisited = false;
        }

        @Override
        public String toString() {
            return "V:" + label;
        }
    }

    private final int MAX_VERTICES;
    private Vertex[] vertices;
    private int[][] adjMatrix;
    private int size;

    public Graph(int size) {
        this.MAX_VERTICES = size;
        vertices = new Vertex[size];
        adjMatrix = new int[size][size];
    }

    public void addVertex(char label) {
        vertices[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void showVertex(int vertex) {
        System.out.println(vertices[vertex]);
    }

    private int getUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[ver][i] == 1 && !vertices[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    private void resetFlags() {
        for (int i = 0; i < size; i++) {
            vertices[i].wasVisited = false;
        }
    }

    public void depthTravers() {
        Stack stack = new Stack(MAX_VERTICES);
        vertices[0].wasVisited = true;
        showVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedVertex(stack.peek());
            if (v == -1)
                stack.pop();
            else {
                vertices[v].wasVisited = true;
                showVertex(v);
                stack.push(v);
            }
        }
        resetFlags();
    }

    private int getIndex(char c) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].label == c)
                return i;
        }
        return -1;
    }

    Stack findeShortWay (char start, char stop){
        Stack stack = new Stack(MAX_VERTICES);
        Queue queue = new Queue(MAX_VERTICES);

        int startint =  getIndex(start);
        int stopint = getIndex(stop);

        if (startint == -1 || stopint == -1 || startint == stopint){
            return null;
        }

        vertices[startint].wasVisited = true;
        queue.insert(startint);
        while (!queue.isEmpty()) {
            int nextverticle;
            int curentverticle = queue.remove();
            while ((nextverticle = getUnvisitedVertex(curentverticle)) != -1) {
                vertices[nextverticle].pre = vertices[curentverticle];
                vertices[nextverticle].wasVisited = true;
                if (nextverticle == stopint){
                    break;
                }
                queue.insert(nextverticle);
            }
            if (nextverticle == stopint){
                break;
            }
        }
        if (!vertices[stopint].wasVisited) return null;

        stack.push(vertices[stopint].label);
        int temp = stopint;
        while (vertices[temp].pre != null) {
            for (int i = 0; i < vertices.length; i++) {
                if (vertices[temp].pre == vertices[i]){
                    stack.push(vertices[i].label);
                    temp = i;
                    break;
                }
            }
            for (int j = 0; j < size; j++) {
                vertices[j].wasVisited = false;
                vertices[j].pre = null;
            }
        }
        return stack;
    }

    public void widthTravers(){
        Queue queue = new Queue(MAX_VERTICES);
        vertices[0].wasVisited = true;
        showVertex(0);
        queue.insert(0);
        while (!queue.isEmpty()){
            int vCurr = queue.remove();
            int vNext;
            while ((vNext = getUnvisitedVertex(vCurr)) != -1){
                vertices[vNext].wasVisited = true;
                showVertex(vNext);
                queue.insert(vNext);
            }
        }
        resetFlags();
    }
}