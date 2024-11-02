import java.util.ArrayList;
import java.util.List;

public class subirachs_square {
    private final int[] squareObjs = {
        1, 14, 14, 4,
        11, 7, 6, 9,
        8, 10, 10, 5,
        13, 2, 3, 15
    };
    private final int target = 34;

    public List<List<Integer>> findFourElemCombo(){
        List<List<Integer>> res = new ArrayList<>();
        findCombo(res, new ArrayList<>(), 0, 4, target);
        return res;
    };

    private void findCombo(List<List<Integer>> res, List<Integer> tempList, int start, int n, int target) {
        if (tempList.size() == n && target == 0){
            res.add(new ArrayList<>(tempList));
        } else if (tempList.size() < n){
            for (int i = start; i < squareObjs.length; i++) {
                tempList.add(squareObjs[i]);
                findCombo(res, tempList, i + 1, n, target-squareObjs[i]);
                
                // checking to make sure temp list isnt empty
                if (!tempList.isEmpty()) {
                    tempList.remove(tempList.size() - 1 );
                }

            }
        }
    }
    public List<Integer> countAllSums() {
        List<Integer> allSums = new ArrayList<>();
        for (int n = 1; n <= squareObjs.length; n++) {
            List<List<Integer>> combinations = new ArrayList<>();
            findCombo(combinations, new ArrayList<>(), 0, n, Integer.MAX_VALUE);
            for (List<Integer> combination : combinations) {
                int sum = combination.stream().mapToInt(Integer::intValue).sum();
                allSums.add(sum);
            }
        }
        return allSums;
    }
    
    public int findMostCommonSum(List<Integer> allSums) {
        int maxCount = 0;
        int mostCommonSum = 0;
        
        for (int sum : allSums) {
            int count = 0;
            for (int s : allSums) {
                if (s == sum) count++;
            }
            if (count > maxCount) {
                maxCount = count;
                mostCommonSum = sum;
            }
        }
        
        System.out.println("Most common sum: " + mostCommonSum + " with " + maxCount + " combinations");
        return mostCommonSum;
    }
    
    public static void main(String[] args) {
        subirachs_square square = new subirachs_square();

        List<List<Integer>> fourElementCombinations = square.findFourElemCombo();
        System.out.println("4-element combinations with target sum " + square.target + ": " + fourElementCombinations);

        List<Integer> allSums = square.countAllSums();
        System.out.println("All sums: " + allSums);

        square.findMostCommonSum(allSums);
    }
}
