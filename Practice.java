import java.util.Arrays;

class Practice {
    public static int[] bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    public static int[] selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int swapIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[swapIndex]) {
                    swapIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[swapIndex];
            arr[swapIndex] = temp;
        }
        return arr;
    }

    public static int[] insertionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 24, 9 };

        int result[] = insertionSort(arr);
        System.out.println("THE SORTED ARRYA IS :: " + Arrays.toString(result));
    }
}