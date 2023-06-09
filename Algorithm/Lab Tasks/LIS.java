
import java.util.Scanner;

// 10 9 2 5 3 7 11 8 10 13 6
public class LIS {

    static int size, arr[], length[], prev[];

    static int findMax() {
        int max = 0;
        int index = 0;
        for (int i = size; i >= 0; i--) {
            if (length[i] > max) { // find the maximum length
                max = length[i]; // update the maximum length
                index = i; // update the index of the maximum length
            }
        }
        return index;
    }

    static void printSequence(int max) {
        if (max == 0) {
            return;
        }
        printSequence(prev[max]);
        System.out.print(arr[max] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        arr = new int[size + 1];
        length = new int[size + 1];
        prev = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            arr[i] = sc.nextInt();
        }
        arr[0] = 0;
        length[0] = 0;
        prev[0] = -1; // -1 means no previous element

        for (int i = 1; i <= size; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    length[i] = length[j] + 1; // length of i is length of j + 1
                    prev[i] = j; // previous element of i is j
                    break;
                }
            }
        }

        System.out.println("Here is the sequence: ");
        printSequence(findMax());
        System.out.println("");
    }
}