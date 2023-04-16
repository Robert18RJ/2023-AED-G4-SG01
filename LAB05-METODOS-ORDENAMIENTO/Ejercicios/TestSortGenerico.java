public class TestSortGenerico {

    public static <T> void showArray(T[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Prueba con Integer
        Integer[] a = { 5, 2, 8, 3, 1, 4 };
        System.out.println("Original array:");
        showArray(a);

        GenericSort.bubbleSort(a);
        System.out.println("Matriz ordenada por bubbleSort:");
        showArray(a);

        GenericSort.insertionSort(a);
        System.out.println("Matriz ordenada por insertionSort:");
        showArray(a);

        GenericSort.selectionSort(a);
        System.out.println("Matriz ordenada por selectionSort:");
        showArray(a);

        GenericSort.shellSort(a);
        System.out.println("Matriz ordenada por shellSort:");
        showArray(a);

        GenericSort.quickSort(a, 0, a.length - 1);
        System.out.println("Matriz ordenada por quickSort:");
        showArray(a);

        // Prueba con Character
        Character[] b = { 'f', 'e', 'd', 'c', 'b', 'a' };
        System.out.println("Original array:");
        showArray(b);

        GenericSort.bubbleSort(b);
        System.out.println("Matriz ordenada por bubbleSort:");
        showArray(b);

        GenericSort.insertionSort(b);
        System.out.println("Matriz ordenada por insertionSort:");
        showArray(b);

        GenericSort.selectionSort(b);
        System.out.println("Matriz ordenada por selectionSort:");
        showArray(b);

        GenericSort.shellSort(b);
        System.out.println("Matriz ordenada por shellSort:");
        showArray(b);

        GenericSort.quickSort(b, 0, b.length - 1);
        System.out.println("Matriz ordenada por quickSort:");
        showArray(b);

        // Prueba con String
        String[] c = { "hola", "adios", "como", "estas", "yo", "bien" };
        System.out.println("Original array:");
        showArray(c);

        GenericSort.bubbleSort(c);
        System.out.println("Matriz ordenada por bubbleSort:");
        showArray(c);

        GenericSort.insertionSort(c);
        System.out.println("Matriz ordenada por insertionSort:");
        showArray(c);

        GenericSort.selectionSort(c);
        System.out.println("Matriz ordenada por selectionSort:");
        showArray(c);

        GenericSort.shellSort(c);
        System.out.println("Matriz ordenada por shellSort:");
        showArray(c);

        GenericSort.quickSort(c, 0, c.length - 1);
        System.out.println("Matriz ordenada por quickSort:");
        showArray(c);

        Golosinas[] d = { new Golosinas("Chocolates"), new Golosinas("Gomitas"), new Golosinas("Paletas"),
                new Golosinas("Caramelos"), new Golosinas("Chicles") };
        System.out.println("Original array:");
        showArray(d);

        GenericSort.bubbleSort(d);
        System.out.println("Matriz ordenada por bubbleSort:");
        showArray(d);

        GenericSort.insertionSort(d);
        System.out.println("Matriz ordenada por insertionSort:");
        showArray(d);

        GenericSort.selectionSort(d);
        System.out.println("Matriz ordenada por selectionSort:");
        showArray(d);

        GenericSort.shellSort(d);
        System.out.println("Matriz ordenada por shellSort:");
        showArray(d);

        GenericSort.quickSort(d, 0, d.length - 1);
        System.out.println("Matriz ordenada por quickSort:");
        showArray(d);
    }

}
