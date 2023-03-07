
public class MergeSort2 {

    public static void main(String[] args) {
        int[] arr1 = { 2, 6, 8, 9, 1, 5, 9, 11 };
        int[] arr2 = { 8, 6, 2, 9, 1, 5, 11, 9 };
        System.out.println("Array 1:");
        margesort(arr1, 0, arr1.length - 1);
        System.out.println("Array 2:");
        margesort(arr2, 0, arr2.length - 1);

        // create an array of size arr1+arr2 and copy the elements of arr1 and arr2 into
        // it
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[arr1.length + i] = arr2[i];
        }
        //
        System.out.println("Combined array:");
        for (int elements : arr3) {
            System.out.print(elements + " ");
        }
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
        for (int l = 0; l < temp.length; l++) {
            System.out.print(temp[l] + " ");
        }
        System.out.println();
    }
}
