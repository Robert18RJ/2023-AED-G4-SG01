public class TestShort {

    // Implementación de "showArray"
    public static void showArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = { 5, 2, 8, 3, 1, 4 };
        System.out.println("Original array:");
        showArray(a);

        // Sort.bubbleSort(a);
        // System.out.println("Matriz ordenada por bubbleSort:");
        // showArray(a);

        // Sort.insertionSort(a);
        // System.out.println("Matriz ordenada por insertionSort:");
        // showArray(a);

        // Sort.selectionSort(a);
        // System.out.println("Matriz ordenada por selectionSort:");
        // showArray(a);

        // Sort.shellSort(a);
        // System.out.println("Matriz ordenada por shellSort:");
        // showArray(a);

        // Sort.quickSort(a, 0, a.length - 1);
        // System.out.println("Matriz ordenada por quickSort:");
        // showArray(a);

        Sort.brickSort(a);
        System.out.println("Matriz ordenada por brickSort:");
        showArray(a);

        // Sort.shakerSort(a);
        // System.out.println("Matriz ordenada por shakerSort:");
        // showArray(a);

    }
}
