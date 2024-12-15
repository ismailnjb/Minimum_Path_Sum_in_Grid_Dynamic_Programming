package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Min_Path_Sum_in_Grid{



    public Integer f(Integer i,Integer j,List<List<Integer>>grid){
        if(i==0 && j==0){
            return grid.get(i).get(j);
        }

        if(i<0 || j<0){
            return Integer.MAX_VALUE/2;
        }

        int up = f(i - 1, j, grid); // Path from above
        int left = f(i, j - 1, grid); // Path from the left


        // Return the minimum path sum to reach (i, j)
        return grid.get(i).get(j) + Math.min(up, left);
    }

    public Integer minPathSum(List<List<Integer>> grid){
        int n=grid.size();
        int m=grid.get(0).size();
        return f(n-1,m-1,grid);

    }

    public static void main(String[] args){
        Min_Path_Sum_in_Grid min_Path_Sum_in_Grid=new Min_Path_Sum_in_Grid();
        List<List<Integer>>grid=new ArrayList<>();

        grid.add(Arrays.asList(10, 2, 8));
        grid.add(Arrays.asList(10, 2, 8));
        grid.add(Arrays.asList(4, 9, 11));
        grid.add(Arrays.asList(4, 13, 6));


        int minSum=min_Path_Sum_in_Grid.minPathSum(grid);
        System.out.println("The Minimum path sum in the Grid is :"+ minSum);

    }


}