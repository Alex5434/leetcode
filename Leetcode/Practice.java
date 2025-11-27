import java.util.Arrays;

class Solution {
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
        // int arr[] = { 13, 46, 24, 52, 20, 24, 9 };

        // int result[] = insertionSort(arr);
        // System.out.println("THE SORTED ARRYA IS :: " + Arrays.toString(result));


        // int i = 123;

        // boolean result = (i & 1) == 0;

        // System.out.println("RESULT isss :: " + (i & (i - 1)));

        // while (i > 0) {
        //     i = i & (i - 1);
        //     System.out.println(i);
        //     System.out.println("+++");
        // }
        

        // if((i & 1) == 0){
        // } else{
        //     System.out.println("EVEN :::");
        // }
        int[] a = {38,27,43,3,9,82,10, 11};

        MergeSort me = new MergeSort();

        me.mergeSort(a);

    }
}


// MERGER SORT IS LIKE A MAGIC
class MergeSort {

    public static void mergeSort(int arr[]){
        if(arr == null || arr.length <= 1){
            return;
        }

        int[] aux = new int[arr.length];
        mergeSortHelper(arr, aux, 0, arr.length - 1);
    }

    public static void mergeSortHelper(int[] arr, int[] aux, int left, int right){
        // condition to handle left and right
        int mid =  left + (right - left) / 2;

        // System.out.println("GOING TO SPLIT << " + left + " || " + mid + " >> " + right);
        if(left >= right){
            // System.out.println("GOING TO RETURN << " + left + " || " + mid + " >> " + right + " ## " + arr[left]);
            return;
        } 

        // find mid to split
        // int mid =  (left + right) / 2;
        // System.out.println("MID ::: " + mid);
        mergeSortHelper(arr, aux, left, mid);
        mergeSortHelper(arr, aux, mid + 1, right);

        // System.out.println("CAME UNDER THE ORIGINAL MERGE ::: " + Arrays.toString(arr) + " :: " + left + " :: " + mid + " :: " + right);
        // merge
        originalMerge(arr, aux, left, mid, right);
    }

    public static void originalMerge(int[] arr, int[] aux, int left, int mid, int right){
        // copy the array in the AUX array
        
        for (int i = left; i <= right; i++) {
            aux[i] = arr[i];
        }
        
        // Assign the pointer
        int i = left; // pointer for first array
        int j = mid + 1; // pointer for right array
        int k = left; // for index
        
        while(i <= mid && j <= right){
            if(aux[i] <= aux[j]){
                arr[k++] = aux[i++];
            } else{
                arr[k++] = aux[j++];
            }
        }
        
        while(i <= mid){
            arr[k++] = aux[i++];
        }
        while(j <= right){
            arr[k++] = aux[j++];
        }
        System.out.println("AFTER MERGE :::::: " + Arrays.toString(arr) + " :: " + " :: " + left + " :: " + mid + " :: " + right);
    }


    public static void main(String[] args){
        int[] a = {38,27,43,3,9,82,10};
        mergeSort(a);
        System.out.println(Arrays.toString(a));

    }
}