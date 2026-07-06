import java.util.*;

public class HeapSortResponseTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextDouble();
        }

        // Heap Sort
        heapSort(arr);

        // 1. Display sorted response times
        for (double val : arr) {
            System.out.print((int)val + " ");
        }
        System.out.println();

        // 2. Fastest response time
        System.out.println("Fastest: " + (int)arr[0]);

        // 3. Slowest response time
        System.out.println("Slowest: " + (int)arr[N - 1]);

        // 4. Average response time
        double sum = 0;
        for (double val : arr) sum += val;
        double avg = sum / N;
        System.out.println("Average: " + avg);

        // 5. Count cases faster than average
        int count = 0;
        for (double val : arr) {
            if (val < avg) count++;
        }
        System.out.println("Cases Faster Than Average: " + count);

        // 6. Percentage faster than average
        double percentage = ((double)count / N) * 100;
        System.out.println("Percentage Faster Than Average: " + percentage + "%");
    }

    public static void heapSort(double[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            double temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(double[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            double swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}

