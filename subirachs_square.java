import java.util.ArrayList;
import java.util.List;

public class subirachs_square {
    private static final int[][] SQUARE = {
        {1, 14, 14, 4},
        {11, 7, 6, 10},
        {8, 10, 5, 10},
        {13, 2, 3, 15}
    };

    public static void main(String args[]) {
        int targetSum = calc_row_sum(0); //should be 33 fingers crossed
        int maxSum = calc_max_sum();
        
        int 

        int rowCount = count_row_sum(targetSum);
        int colCount = count_col_sum(targetSum);
        int diagCount = count_diag_sum(targetSum);
        int postageCount = count_postage_sum(targetSum);

        System.out.println("Target Sum: " + targetSum);
        System.out.println("Number of rows with target sum: " + rowCount);
        System.out.println("Number of columns with target sum: " + colCount);
        System.out.println("Number of diagonals with target sum: " + diagCount);
        System.out.println("Number of 2x2 postage stamps with target sum: " + postageStampCount);

        int totalCount = rowCount + colCount + diagCount + postageStampCount;
        System.out.println("Total count of all specified 4-element combinations with target sum: " + totalCount);
    }

    private static int calc_row_sum(int row){
        int sum = 0;
        for (int col  = 0; col < SQUARE[row].length; col++) { 
            sum += SQUARE[row][col]
        }
    }

    private static int count_row_sum(int targetSum){
        int count = 0
        for (int row = 0; row < SQUARE.length; row++) {
            if (calc_row_sum(row) == targetSum) {
                count++;
            }

        }
        return count;
    }

    private static int count_col_sum(int targetSum){
        int count = 0;
        for (int col = 0; col < SQUARE[0].length; col++) {
            int sum = 0;
            for (int row = 0; row < SQUARE.length; row++) {
                sum += square[row][col];
            }
            if (sum == targetSum) {
                count++;
            }
        }
        return count;
    }

    private static int calc_diag_sum(int targetSum) {
        int count = 0;

        int normDiagSum = 0; // (0,0); (1,1); (2,2), (3,3) assuming 0 indexing
        for (int i = 0; i < SQUARE.length, i++) {
            normDiagSum +=  SQUARE[i][i];
        }
        if (normDiagSum == targetSum) {
            count++;
        }

        int oppDiagSum = 0;
        for (int i = 0; i < SQUARE.length; i++) {
                oppDiagSum += SQUARE[i][SQUARE.length - 1 -i];
        }
        if (antiDiagonalSum == targetSum) {
            count++;
        }
        return count;
    }

    private static int post_sum(int top_row, int left_col){
        return SQUARE[top_row][left_col] + 
        SQUARE[top_row][left_col + 1] + 
        SQUARE[top_row+1][left_col + 1] + 
        SQUARE[top_row + 1] [left_col + 1];
    }

    private static calc_postage_sum(int targetSum) {
        int count = 0;
        for (int row = 0; row < 2; row ++) { // since only row 0, 1, and 2 count for "postages", as we account for the +1 case in both scenarios
            for (int col = 0; col < 2; col ++){  // see above 
                if (post_sum(row,col) == targetSum){
                    count++;
                }
            }
        }
        return count;
    }
    
}
   