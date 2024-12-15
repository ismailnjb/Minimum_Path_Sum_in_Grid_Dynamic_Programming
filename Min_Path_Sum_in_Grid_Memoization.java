package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Min_Path_Sum_in_Grid_Memoization {



    public Integer f(Integer i,Integer j,List<List<Integer>>grid,List<List<Integer>>memo){
        if(i==0 && j==0){
            return grid.get(i).get(j);
        }

        if(i<0 || j<0){
            return Integer.MAX_VALUE/2;
        }

        if (memo.get(i).get(j) != -1) {
            return memo.get(i).get(j);
        }

        int up = f(i - 1, j, grid,memo); // Path from above
        int left = f(i, j - 1, grid,memo); // Path from the left

        memo.get(i).set(j,grid.get(i).get(j) + Math.min(up, left));
        // Return the minimum path sum to reach (i, j)
        return memo.get(i).get(j);
    }

    public Integer minPathSum(List<List<Integer>> grid){
        int n=grid.size();
        int m=grid.get(0).size();
        List<List<Integer>> memo = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(-1);  // Initially, no cell is calculated
            }
            memo.add(row);
        }
        return f(n-1,m-1,grid,memo);

    }

    public static void main(String[] args){
        Min_Path_Sum_in_Grid_Memoization min_Path_Sum_in_Grid=new Min_Path_Sum_in_Grid_Memoization();
        List<List<Integer>>grid=new ArrayList<>();

        grid.add(Arrays.asList(10, 2, 8));
        grid.add(Arrays.asList(10, 2, 8));
        grid.add(Arrays.asList(4, 9, 11));
        grid.add(Arrays.asList(4, 13, 6));


        int minSum=min_Path_Sum_in_Grid.minPathSum(grid);
        System.out.println("The Minimum path sum in the Grid is :"+ minSum);

    }


}