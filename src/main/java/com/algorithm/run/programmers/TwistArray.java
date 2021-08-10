package com.algorithm.run.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class TwistArray {

	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        int num = 1; 
        for(int i = 0 ; i < rows ; i++) {
        	for(int j = 0 ; j < columns ; j++) {
        		arr[i][j] = num;
        		num++;
            }
        }
        
        int cnt = 0;
        for(int[] query : queries) {
        	List<Integer> list = new ArrayList<Integer>();
        	int y1 =  query[0] - 1;
        	int x1 =  query[1] - 1;
        	int y2 =  query[2] - 1;
        	int x2 =  query[3] - 1;
        	int fisrt = arr[y1][x1];
        	
        	int most = 0;
        	for(int i = 1 ; i <= x2 - x1 ; i ++) {
        		list.add(arr[y1][x1  + i]);
        		int wait = arr[y1][x1  + i];
        		if(most == 0) {
        			arr[y1][x1  + i] = fisrt;
        		}else {
        			arr[y1][x1  + i] = most;
        		}
        		most = wait;
        	}
        	
        	for(int i = 1 ; i <= y2 - y1 ; i ++) {
        		list.add(arr[y1 + i][x2]);
        		int wait = arr[y1 + i][x2];
        		arr[y1 + i][x2] = most;
        		most = wait;
        	}
        	
        	for(int i = 1 ; i <= x2 - x1 ; i ++) {
        		list.add(arr[y2][x2  - i]);
        		int wait = arr[y2][x2  - i];
        		arr[y2][x2  - i] = most;
        		most = wait;
        	}
        	
        	for(int i = 1 ; i <= y2 - y1 ; i ++) {
        		list.add(arr[y2 - i][x1]);
        		int wait = arr[y2 - i][x1];
        		arr[y2 - i][x1] = most;
        		most = wait;
        	}
        	
        	answer[cnt] = list.stream().sorted().collect(Collectors.toList()).get(0);
        	cnt++;

        }
        return answer;
    }

	public static void main(String[] args) {
		int[][] query = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		System.out.println(Arrays.toString(solution(6,6,query)));;

	}

}
