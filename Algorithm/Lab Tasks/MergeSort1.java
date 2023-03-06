
public class MergeSort1 {
    public static void main(String[] args) {
        int[] arr = { 6, 2, 10, 1, 5, 4, 9, 8, 7, 3 };
        margesort(arr, 0, arr.length - 1);
    }

    public static void margesort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            margesort(arr, start, mid);
            margesort(arr, mid + 1, end);
            margesort(arr, start, mid, end);
        }
    }

    public static void margesort(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < temp.length; l++) {
            arr[start + l] = temp[l];
        }
        for (int l = 0; l < arr.length; l++) {
            System.out.print(arr[l] + " ");
        }
        System.out.println();
    }
}