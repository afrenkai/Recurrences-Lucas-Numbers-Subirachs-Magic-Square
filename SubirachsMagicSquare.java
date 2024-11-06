import java.util.ArrayList;
import java.util.List;

public class SubirachsMagicSquare {
    static int[] square = {1, 14, 14, 4, 11, 7, 6, 9, 8, 10, 10, 5, 13, 2, 3, 15};

    public static void main(String[] args) {
        int targetSum = findTargetSum();  // Finds the target sum, which should be 33 if i can count
        int count4ElementCombinations = countCombinations(4, targetSum);
        System.out.println("4-element combinations with sum " + targetSum + ": " + count4ElementCombinations);

        int countAllCombinations = countCombinations(-1, targetSum);  // -1 to get to end of combos
        System.out.println("All combinations with sum " + targetSum + ": " + countAllCombinations);

        countAllPossibleSums();

        findSumWithMostCombinations();
    }

    static int findTargetSum() {
        return square[0] + square[1] + square[2] + square[3]; // fingers crossed its 33
    }

    static int countCombinations(int elementCount, int targetSum) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(new ArrayList<>(), 0, targetSum, elementCount, combinations);

        System.out.println("Matching combos: " + combinations);

        return combinations.size();
    }

    static void generateCombinations(List<Integer> current, int start, int targetSum, int elementCount, List<List<Integer>> result) {
        int sum = current.stream().mapToInt(Integer::intValue).sum();

        if ((elementCount == -1 || current.size() == elementCount) && sum == targetSum) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (sum >= targetSum || (elementCount != -1 && current.size() >= elementCount)) {
            return;  // if the sum is greater than target, or the element count isnt -1 and the current size is greater than the amount of elements (end of process)
        }

        for (int i = start; i < square.length; i++) {
            current.add(square[i]);
            generateCombinations(current, i + 1, targetSum, elementCount, result);
            current.remove(current.size() - 1); // W recursion
        }
    }

    static void countAllPossibleSums() {
        int maxSum = 0;

        for (int val : square) {
            maxSum += val;
        }

        int[] sumCount = new int[maxSum + 1];

        generateAllSums(new ArrayList<>(), 0, sumCount);

        for (int sum = 0; sum <= maxSum; sum++) {
            if (sumCount[sum] > 0) {
                System.out.println("The sum " + sum + " can be made " + sumCount[sum] + " way(s).");
            }
        }
    }

    static void generateAllSums(List<Integer> current, int start, int[] sumCount) {
        int sum = current.stream().mapToInt(Integer::intValue).sum();
        if (sum > 0) {  //i forget what canvas said about 0
            sumCount[sum]++;
        }

        for (int i = start; i < square.length; i++) {
            current.add(square[i]);
            generateAllSums(current, i + 1, sumCount);
            current.remove(current.size() - 1);  // W recursion
        }
    }

    static void findSumWithMostCombinations() {
        int maxSum = 0;

        for (int val : square) {
            maxSum += val;
        }

        int[] sumCount = new int[maxSum + 1];

        // just counts combos that add up to each sum
        generateAllSums(new ArrayList<>(), 0, sumCount);

        int maxCombinationSum = 0;
        int maxCombinationCount = 0;
        for (int sum = 0; sum <= maxSum; sum++) {
            if (sumCount[sum] > maxCombinationCount) {
                maxCombinationSum = sum;
                maxCombinationCount = sumCount[sum];
            }
        }

        System.out.println("Sum with the most combinations: " + maxCombinationSum + " (" + maxCombinationCount + " combinations)");
    }
}
