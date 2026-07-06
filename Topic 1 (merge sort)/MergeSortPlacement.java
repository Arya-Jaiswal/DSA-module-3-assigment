import java.util.*;

public class MergeSortPlacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // Merge Sort
        mergeSort(arr, 0, N - 1);

        // 1. Display sorted processing times
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();

        // 2. Median
        double median;
        if (N % 2 == 0) {
            median = (arr[N/2 - 1] + arr[N/2]) / 2.0;
        } else {
            median = arr[N/2];
        }
        System.out.println("Median: " + median);

        // 3. Count orders greater than median
        int count = 0;
        for (int val : arr) {
            if (val > median) count++;
        }
        System.out.println("Orders Greater Than Median: " + count);

        // 4. Difference between fastest and slowest
        int diff = arr[N - 1] - arr[0];
        System.out.println("Difference (Max - Min): " + diff);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}

