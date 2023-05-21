public class Test1 {
    public static void main(String[] args) {
        // Crear los nodos
        Node sales = new Node("Sales");
        Node domestic = new Node("Domestic");
        Node international = new Node("International");
        Node canada = new Node("Canada");
        Node sAmerica = new Node("S.America");
        Node overseas = new Node("Overseas");
        Node africa = new Node("Africa");
        Node europe = new Node("Europe");
        Node asia = new Node("Asia");
        Node australia = new Node("Australia");

        // Establecer las relaciones entre los nodos
        sales.addChildren(domestic, international);
        international.addChildren(canada, sAmerica, overseas);
        overseas.addChildren(africa, europe, asia);
        asia.addChild(australia);

        // Llama a la función de recorrido DFS
        dfs(sales, "");
    }

    // Define la función de recorrido DFS
    public static void dfs(Node node, String indentation) {
        System.out.println(indentation + node.data);

        for (Node child : node.children) {
            dfs(child, indentation + "+");
        }
    }
}