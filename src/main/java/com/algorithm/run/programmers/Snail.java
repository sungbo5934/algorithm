package com.algorithm.run.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Snail {
	static int[][] seil;
	static int cur;
	
	public static int[] solution(int n) {
        seil = new int[n][n];
        down(n, 0);
        List<Integer> list = new ArrayList<Integer>();
        for(int i = seil.length -1 ; i > -1 ; i--) {
        	list.addAll(Arrays.stream(seil[i]).filter(data -> data != 0).boxed().collect(Collectors.toList()));
        }
        return list.stream().mapToInt(data -> data).toArray();
    }
	//아래로
	public static void down(int y, int x) {
		boolean change = false;
		int curI = 0;
		for(int i = y-1 ; i > -1 ; i--) {
			if(seil[i][x] == 0) {
				cur++;
				seil[i][x] = cur;
				curI = i;
				change =true;
			}else {
				break;
			}
		}
		if(change) {
			right(curI, x);
			return;
		}
	}
	
	public static void right(int y, int x) {
		boolean change = false;
		int curI = 0;
		for(int i = x + 1 ; i < seil.length ; i++) {
			if(seil[y][i] == 0) {
				cur++;
				seil[y][i] = cur;
				curI = i;
				change =true;
			}else {
				break;
			}
		}
		if(change) {
			modi(y, curI);
			return;
		}
		
	}
	
	public static void modi(int y, int x) {
		boolean stop = true;
		int xIndex= x-1;
		int yIndex= y +1;
		while(stop) {
			if(xIndex >-1 && yIndex < seil.length && seil[yIndex][xIndex] == 0) {
				cur++;
				seil[yIndex][xIndex] = cur;
				xIndex = xIndex - 1;
				yIndex = yIndex + 1;
			}else {
				stop = false;
				down(yIndex-1, xIndex+1);
			}
		}
		
	}
	 public static void main(String[] args) {
		 String[] str = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		 String[] str2 = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		 int[] arr = {1, 2, 3, 2, 3, 1};
		 System.out.println(Arrays.toString(solution(1000)));
		 //{5, 4, 1, 2, 1, 0}
		// [5, 3, 1, 1, 0, 0]
		// System.out.println(Arrays.toString(solution(arr)));
	    }

}
