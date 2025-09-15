import java.util.*;

public class SumBasedOnFrequency {

    static void sumOnFrequency(int arr[]) {
        Map<Integer, Integer> frequencyArray = new HashMap<>();
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (frequencyArray.containsKey(arr[i])) {
                int frequencyCount = frequencyArray.get(arr[i]);
                frequencyArray.put(arr[i], ++frequencyCount);
                continue;
            }
            frequencyArray.put(arr[i], 1);
        }

        for (int i : frequencyArray.keySet()) {
            int mapValue = frequencyArray.get(i);
            if (resultMap.containsKey(mapValue)) {
                int frequencyCount = resultMap.get(mapValue);
                resultMap.put(mapValue, frequencyCount + i);
                continue;
            }

            resultMap.put(mapValue, i);
        }

        for (int i : resultMap.keySet()) {
            System.out.print(i + " -> " + resultMap.get(i) + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 4};
        sumOnFrequency(arr);
    }
}

// OPTMISED GIVEN BY CHATGPT, NEED TO LOOK AFTER
// import java.util.*;

// public class SumBasedOnFrequency {
//     static void sumOnFrequency(int arr[]) {
//         Map<Integer, Integer> freq = new HashMap<>();
//         Map<Integer, Integer> result = new HashMap<>();

//         // Step 1: Count frequencies
//         for (int num : arr) {
//             freq.merge(num, 1, Integer::sum);
//         }

//         // Step 2: Group by frequency and sum keys
//         for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
//             int number = entry.getKey();
//             int frequency = entry.getValue();
//             result.merge(frequency, number, Integer::sum);
//         }

//         // Step 3: Print result
//         result.forEach((f, sum) -> System.out.print(f + " -> " + sum + " "));
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         int arr[] = { 1, 1, 2, 3, 4 };
//         sumOnFrequency(arr);
//     }
// }
