package Algorithm.Practices;

//write down the mergesort code with 15 dummy data and print out the result

public class MergeSort {

    public static void mergesort(int[] data, int[] temp, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(data, temp, low, middle);
            mergesort(data, temp, middle + 1, high);
            merge(data, temp, low, middle, high);
        }
    }

    static void merge(int[] data, int[] temp, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = data[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (temp[i] <= temp[j]) {
                data[k] = temp[i];
                i++;
            } else {
                data[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            data[k] = temp[i];
            k++;
            i++;
        }

    }

    public static void main(String[] args) {
        int[] data = { 3, 5, 1, 2, 4, 6, 7, 8, 9, 10, 11, 15, 13, 12, 14 };
        int[] temp = new int[data.length];
        mergesort(data, temp, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

}