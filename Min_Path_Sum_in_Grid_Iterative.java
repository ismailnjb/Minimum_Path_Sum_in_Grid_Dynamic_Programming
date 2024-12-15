package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Min_Path_Sum_in_Grid_Iterative {

    public Integer fIterative(int n, int m, List<List<Integer>> grid) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{n - 1, m - 1, 0}); // Push initial state [i, j, minSumSoFar]

        int minPathSum = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int i = current[0];
            int j = current[1];
            int currentSum = current[2];

            // If we reach (0, 0), update minPathSum
            if (i == 0 && j == 0) {
                minPathSum = Math.min(minPathSum, currentSum + grid.get(i).get(j));
                continue;
            }

            // If out of bounds, skip this path
            if (i < 0 || j < 0) {
                continue;
            }

            // Add current cell value and push neighbors to the stack
            currentSum += grid.get(i).get(j);

            // Push the path from above
            stack.push(new int[]{i - 1, j, currentSum});

            // Push the path from the left
            stack.push(new int[]{i, j - 1, currentSum});
        }

        return minPathSum;
    }

    public Integer minPathSum(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        return fIterative(n, m, grid);
    }

    public static void main(String[] args) {
        Min_Path_Sum_in_Grid min_Path_Sum_in_Grid = new Min_Path_Sum_in_Grid();
        List<List<Integer>> grid = new ArrayList<>();

        grid.add(Arrays.asList(10, 2, 8));
        grid.add(Arrays.asList(10, 2, 8));
        grid.add(Arrays.asList(4, 9, 11));
        grid.add(Arrays.asList(4, 13, 6));

        int minSum = min_Path_Sum_in_Grid.minPathSum(grid);
        System.out.println("The Minimum path sum in the Grid is :" + minSum);
    }
}

