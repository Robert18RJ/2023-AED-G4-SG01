public class Test {
    public static void main(String[] args) {
        // Crear dos árboles binarios diferentes
        BSTree<Integer> tree1 = new BSTree<>();
        BSTree<Integer> tree2 = new BSTree<>();
        
        // Agregar elementos a los árboles
        try {
            tree1.insert(5);
            tree1.insert(3);
            tree1.insert(7);
            
            tree2.insert(8);
            tree2.insert(4);
            tree2.insert(6);
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Verificar si los árboles tienen la misma área
        boolean sameArea = isSameArea(tree1, tree2);
        
        System.out.println("Los dos árboles tienen la misma área: " + sameArea);  
    }
    
    public static boolean isSameArea(BSTree<?> tree1, BSTree<?> tree2) {
        int area1 = 0;
        int area2 = 0;
        
        area1 = tree1.getArea();
        area2 = tree2.getArea();

        return area1 == area2;
    }
}

