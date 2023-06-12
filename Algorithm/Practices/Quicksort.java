package Algorithm.Practices;

public class Quicksort {

    public static void quicksort(int[] data, int low, int high) {
        if (low < high) {
            int pivot = partition(data, low, high);
            quicksort(data, low, pivot - 1);
            quicksort(data, pivot + 1, high);
        }
    }

    static int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] data = { 3, 5, 1, 2, 4, 6, 7, 8, 9, 10, 11, 15, 13, 12, 14 };
        quicksort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }

    }

}
