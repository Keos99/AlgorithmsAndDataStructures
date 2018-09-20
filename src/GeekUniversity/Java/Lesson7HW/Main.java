package GeekUniversity.Java.Lesson7HW;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        char lable = 'A';

        for (int i = 0; i < 10; i++) {
            graph.addVertex(lable);
            lable++;
        }

        setEdges(graph);

        //for (int i = 0; i < 10; i++) {
        //    graph.showVertex(i);
        //}
    }

    public static void setEdges(Graph graph){
        graph.addEdge(0,3);
        graph.addEdge(3,1);
        graph.addEdge(1,2);
        graph.addEdge(2,1);
        graph.addEdge(4,3);
        graph.addEdge(4,8);
        graph.addEdge(8,4);
        graph.addEdge(2,9);
        graph.addEdge(8,7);
        graph.addEdge(6,9);
        graph.addEdge(9,6);
        graph.addEdge(0,6);
        graph.addEdge(5,3);
        graph.addEdge(3,5);
        graph.addEdge(5,6);
        graph.addEdge(6,5);
    }
}
