package concepts;
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 5, 6, 20, 44, };
        int num = 20;
        
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            System.out.println("Iterating...");
            int m = l + (r - l) / 2;

            if (arr[m] == num) {
                System.out.println("Found the element index : " + m);
                break;
            } else if (arr[m] < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    }
}
