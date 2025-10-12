import java.util.*;

public class SumBasedOnFrequency {

    // Not optimal
    // static void sumOnFrequency(int arr[]) {
    //     Map<Integer, Integer> frequencyArray = new HashMap<>();
    //     Map<Integer, Integer> resultMap = new HashMap<>();

    //     for (int i = 0; i < arr.length; i++) {
    //         if (frequencyArray.containsKey(arr[i])) {
    //             int frequencyCount = frequencyArray.get(arr[i]);
    //             frequencyArray.put(arr[i], ++frequencyCount);
    //             continue;
    //         }
    //         frequencyArray.put(arr[i], 1);
    //     }

    //     for (int i : frequencyArray.keySet()) {
    //         int mapValue = frequencyArray.get(i);
    //         if (resultMap.containsKey(mapValue)) {
    //             int frequencyCount = resultMap.get(mapValue);
    //             resultMap.put(mapValue, frequencyCount + i);
    //             continue;
    //         }

    //         resultMap.put(mapValue, i);
    //     }

    //     for (int i : resultMap.keySet()) {
    //         System.out.print(i + " -> " + resultMap.get(i) + "  ");
    //     }
    //     System.out.println();
    // }



    // Optimal given by chatgpt
    static void sumOnFrequency(int arr[]) {
        Map<Integer, Integer> frequencyArray = new HashMap<>();
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            frequencyArray.merge(arr[i], 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : frequencyArray.entrySet()) {
            int mapKey = entry.getKey();
            int mapValue = entry.getValue();
            resultMap.merge(mapValue, mapKey, Integer::sum);
        }

        resultMap.forEach((k, v)->System.out.print(k + " -> " + v + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3, 4};
        sumOnFrequency(arr);
    }
}
