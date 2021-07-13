package com.algorithm.run.bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FamilyTree {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int totalCnt = Integer.parseInt(sc.nextLine());
		String twoPeople = sc.nextLine();
		int twoPeopleOne = Integer.parseInt(twoPeople.split(" ")[0]);
		int twoPeopletwo = Integer.parseInt(twoPeople.split(" ")[1]);
		int totalLength = Integer.parseInt(sc.nextLine());
		
		int[] parent = new int[totalLength];
		int[] child = new int[totalLength];
		for(int i = 0 ; i < totalLength ; i++) {
			String str = sc.nextLine();
			parent[i] = Integer.parseInt(str.split(" ")[0]);
			child[i] = Integer.parseInt(str.split(" ")[1]);
		}
		
		PriorityQueue<String> qu = new PriorityQueue();
		qu.add(twoPeopleOne +  "," + 0);
		int depth = 0;
		List<Integer> visit = new ArrayList<Integer>();
		boolean check = false;
		loopOut:
		while(!qu.isEmpty()) {
			String cur = qu.poll();
			
			for(int i = 0 ; i < totalLength ; i++) {
				if(parent[i] == Integer.parseInt(cur.split(",")[0]) && !visit.contains(i)) {
					if(child[i] == twoPeopletwo) {
						check = true;
						System.out.println(Integer.parseInt(cur.split(",")[1]) + 1);
						break loopOut;
					}
					qu.add(child[i] + "," + (Integer.parseInt(cur.split(",")[1]) + 1));
					visit.add(i);
					
				}else if(child[i] == Integer.parseInt(cur.split(",")[0]) && !visit.contains(i)) {
					if(parent[i] == twoPeopletwo) {
						check = true;
						System.out.println(Integer.parseInt(cur.split(",")[1]) + 1);
						break loopOut;
					}
					qu.add(parent[i] + "," + (Integer.parseInt(cur.split(",")[1]) + 1));
					visit.add(i);
				}
			}
			
		}
		
		if(!check) {
			System.out.println(-1);
		}

	}

}
