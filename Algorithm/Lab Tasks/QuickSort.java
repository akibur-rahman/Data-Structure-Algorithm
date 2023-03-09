public class QuickSort {
    // write me quicksort with a dummy data of 10 array elements
    public static void main(String[] args) {
        int[] arr = { 1, 5, 2, 4, 3, 9, 8, 7, 6, 0 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            System.out.println("First pertioion: ");
            printArray(arr, left, right);
            quickSort(arr, left, pivot - 1);
            System.out.println("Second pertioion: ");
            printArray(arr, left, right);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // printArray(arr, left, right);
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

    static void printArray(int[] arr, int left_index, int right_index) {
        int i;
        for (i = left_index; i <= right_index; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
