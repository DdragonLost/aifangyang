package com.aifangyang.study.cal;

import java.util.HashMap;
import java.util.Map;

public class IslandSolution {

    public void findLast(){

    }


    public int numIslands(char[][] grid) {
        int islandNum = 0;
        Map<String,Boolean> isAddMap = new HashMap<>();
        for(int i = 0;i<grid.length;i++){
            char[] chars = grid[i];
            for (int j = 0;j<chars.length;j++){
                char front = '0';
                char upper = '0';
                if(j>0){
                    front = chars[j-1];
                }
                if(i>0){
                    upper = grid[i-1][j];
                }

                isAddMap.put(i+"&"+j,false);
                if('1'==chars[j]){
                    if(chars[j]!=front&&chars[j]!=upper){
                        isAddMap.put(i+"&"+j,true);
                        islandNum++;
                    }
                    if((null!= isAddMap.get((i-1)+"&"+j)&&isAddMap.get((i-1)+"&"+j) )
                    && (null!= isAddMap.get(i+"&"+(j-1))&&!isAddMap.get(i+"&"+(j-1)))){
                        islandNum--;
                    }
                }
                // System.out.println("element index is :["+i+"," +j+"],value is :"+chars[j]);
            }
        }
        return islandNum;
    }

    public static void main(String[] args) {
        char[][] grid = {
                            {'1','0','1','1','0','1'},
                            {'0','1','0','1','0','1'},
                            {'1','0','1','1','0','1'}
                        };
        IslandSolution test = new IslandSolution();
        System.out.println(test.numIslands(grid));

    }
}
