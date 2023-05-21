import java.util.ArrayList;
import java.util.List;

// Define la clase Node
public class Node {
    String data;
    List<Node> children;

    public Node(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public void addChildren(Node... children) {
        for (Node child : children) {
            this.addChild(child);
        }
    }
}