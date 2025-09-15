package demo;
import java.util.Arrays;
import java.util.Scanner;

public class SortUsingPositions {
    static void swapElement(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] % 2 == 0 && arr[j] % 2 == 0 && arr[i] < arr[j]) {
                    swapElement(arr, j, i);
                } else {
                    if (arr[j] % 2 == 1 && arr[i] > arr[j]) {
                        swapElement(arr, i, j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int arraySize = sc.nextInt();
        int arr[] = new int[arraySize];

        System.out.println("Enter elements : ");
        for (int i = 0; i < arraySize; i++) {
            arr[i] = sc.nextInt();
        }
        sortArray(arr);
        System.out.println("THE SORTED ARRAY: " + Arrays.toString(arr));
    }
}