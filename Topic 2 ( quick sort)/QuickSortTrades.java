import java.util.*;

public class QuickSortTrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        // Quick Sort (descending)
        quicksort(arr, 0, N - 1);

        // 1. Display sorted trade values
        for (long val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();

        // 2. Top 5 values
        System.out.print("Top 5: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 3. Average of Top 5
        long sumTop5 = 0;
        for (int i = 0; i < 5; i++) sumTop5 += arr[i];
        long avgTop5 = sumTop5 / 5;
        System.out.println("Average of Top 5: " + avgTop5);

        // 4. Count values greater than overall average
        long sumAll = 0;
        for (long val : arr) sumAll += val;
        long avgAll = sumAll / N;

        int count = 0;
        for (long val : arr) {
            if (val > avgAll) count++;
        }
        System.out.println("Values Above Overall Average: " + count);
    }

    public static void quicksort(long[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    public static int partition(long[] arr, int low, int high) {
        long pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // Note: >= pivot for descending order
            if (arr[j] >= pivot) {
                i++;
                long temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        long temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
}

