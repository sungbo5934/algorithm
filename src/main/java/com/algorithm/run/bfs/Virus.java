package com.algorithm.run.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Virus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int totalCom = Integer.parseInt(sc.nextLine());
		int totalLength = Integer.parseInt(sc.nextLine());
		
		int[] xArr  = new int[totalLength];
		int[] yArr  = new int[totalLength];
		
		for(int i  = 0; i < totalLength; i++) {
			String comArr = sc.nextLine();
			xArr[i] = Integer.parseInt(comArr.split(" ")[0]);
			yArr[i] = Integer.parseInt(comArr.split(" ")[1]);
		}
		
		int firstCom = 1;
		int virusCnt = 0;
		List<Integer> visitList = new ArrayList<Integer>();
		
		Queue<Integer> que = new PriorityQueue<Integer>();
		HashSet<Integer> hs = new HashSet<Integer>();
		que.add(firstCom);
		
		while(!que.isEmpty()) {
			int curCom = que.poll();
			
			for(int i = 0 ; i < totalLength ; i ++) {
				if(xArr[i] == curCom && !visitList.contains(i)) {
					que.add(yArr[i]);
					visitList.add(i);
					virusCnt++;
					hs.add(yArr[i]);
				}
				if(yArr[i] == curCom && !visitList.contains(i)) {
					que.add(xArr[i]);
					visitList.add(i);
					virusCnt++;
					hs.add(xArr[i]);
				}
			}
			
		}
		
		System.out.println(hs.size());
		

	}

}
