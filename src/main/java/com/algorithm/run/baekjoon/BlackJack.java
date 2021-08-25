package com.algorithm.run.backjun;

import java.util.Arrays;
import java.util.Scanner;

public class BlackJack {
	//5 21
	//5 6 7 8 9
	static int N;
	static int[] nArr;
	static int M;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nw = sc.nextLine();
		String nStr = sc.nextLine();
		N = Integer.parseInt(nw.split(" ")[0]);
		M = Integer.parseInt(nw.split(" ")[1]);
		String[] nStrArr = nStr.split(" ");
		nArr = Arrays.stream(nStrArr).mapToInt(data -> Integer.parseInt(data)).toArray();
		boolean[] visited = new boolean[nArr.length];
		find(visited, 0, 3);
		System.out.println(answer);
	}
	
	public static void find(boolean[] visited, int start, int r) {
		if(r == 0) {
			int cnt = 0;
			for(int i = 0 ; i < visited.length ; i++) {
				if(visited[i]) {
					cnt += nArr[i];
				}
			}
			if(cnt <= M) {
				answer = Math.max(answer, cnt);
			}
			return;
		}
		
		for(int i = start ; i < nArr.length ; i++) {
			visited[i] = true;
			if(answer != M) {
				find(visited, i + 1 , r- 1 );
			}
			visited[i] = false;
		}
	}

}
