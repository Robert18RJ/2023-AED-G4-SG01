public class Sort {
    public static void bubbleSort(int a[]) {
        boolean fl = true; //
        int pass = 0;
        int n = a.length;
        for (pass = 0; pass < n - 1 && fl; pass++) { // bucle externo controla la cantidad de pasadas
            fl = false;
            for (int j = 0; j < n - pass - 1; j++) {
                // elementos desordeados, es necesario intercambio
                if (a[j] > a[j + 1]) {
                    fl = true;
                    int aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                }
            }
        }
    }
    //Complejidad O(n^2) 
    public static void insertionSort(int a[]) {
        int i, j, aux;
        for (i = 1; i < a.length; i++) { // el indice i explora sublista a[a-1]..a[0]
            // buscando posición correcta del elemento destion, para asignarlo en a[j]
            j = i;
            aux = a[i];
            // se localiza el punto de inserción explorando hacia atrás.
            while (i > 0 && aux < a[j - 1]) {
                a[j] = a[j - 1];
            }
            a[j] = aux;
        }
    }

    public static void selectionSort(int a[]) {
        int min;

        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j])
                    min = j;
            }
            int aux = a[min];
            a[min] = a[i];
            a[i] = aux;
        }
    }

    public static void shellSort(int a[]) {
        int interval = a.length / 2;
        int i, j, aux;

        while (interval > 0) {

            for (i = interval; i < a.length; i++) {
                j = i;
                aux = a[i];
                while ((j >= interval) && (a[j - interval] > aux)) {
                    a[j] = a[j - interval];
                    j = j - interval;
                }
                a[j] = aux;
            }
            interval = interval / 2;
        }
    }

    public static void quickSort(int a[], int l, int r) {
        int i = l;
        int j = r;
        int pivot = a[(l + r) / 2];
        do {
            while (a[i] < pivot)
                i++;
            while (pivot < a[j])
                j--;
            if (i <= j) {
                if (i != j) {
                    int aux = a[i];
                    a[i] = a[j];
                    a[j] = aux;
                }
                i++;
                j--;
            }
        } while (i <= j);
        if (l < j) {
            quickSort(a, l, j);
        }
        if (i < r) {
            quickSort(a, i, r);
        }
    } 
    public static void brickSort(int[] arr) {
        boolean isSorted = false;
        int left = 0, right = arr.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = left; i < right; i += 2) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    isSorted = false;
                }
            }
            for (int i = right - 1; i > left; i -= 2) {
                if (arr[i-1] > arr[i]) {
                    swap(arr, i-1, i);
                    isSorted = false;
                }
            }
            left++;
            right--;
        }
    }
    
    public static void shakerSort(int[] arr) {
        boolean isSorted = false;
        int left = 0, right = arr.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    isSorted = false;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i-1] > arr[i]) {
                    swap(arr, i-1, i);
                    isSorted = false;
                }
            }
            left++;
        }
    }
    
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
    
}
