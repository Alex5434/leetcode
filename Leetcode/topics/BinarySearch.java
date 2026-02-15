class Solution {

    public static int findLastOccurenece(int arr[], int target){
        int l = 0, r = arr.length - 1;
        int ans = -1;

        while (l <= r) {
            int m = (r -l) / 2 + l;
            if(arr[m] == target){
                ans = m;
                l = m + 1;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    }

    public static int findFirstOccurenece(int arr[], int target){
        int l = 0, r = arr.length - 1;
        int ans = -1;

        while (l <= r) {
            int m = (r -l) / 2 + l;
            if(arr[m] == target){
                ans = m;
                r = m - 1;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    }

    public static int findOccurence(int[] arr, int target){
        int first = findFirstOccurenece(arr, target);
        int last = findLastOccurenece(arr, target);
        System.out.println("FIND THE FIRST IS :: " + last + "  " + first + " " + (last - first + 1));

        if(last == -1 && first == -1){
            return 0;
        }

        return last - first + 1;
    }
    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 6, 20, 44, };
        int num = 3;

        findOccurence(arr, num);
        
        // int l = 0, r = arr.length - 1;
        // while (l <= r) {
        //     System.out.println("Iterating...");
        //     int m = l + (r - l) / 2;

        //     if (arr[m] == num) {
        //         System.out.println("Found the element index : " + m);
        //         break;
        //     } else if (arr[m] < num) {
        //         l = m + 1;
        //     } else {
        //         r = m - 1;
        //     }
        // }
    }
}
