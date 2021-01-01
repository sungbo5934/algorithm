package com.algorithm.run.git;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static int N;
	static int K;
	static Diamond[] nInfo;
	static Integer[] kInfo;
	static long totalPrice = 0;
	static int giveCnt = 0;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		nInfo = new Diamond[N];
		kInfo = new Integer[K];
		
		for( int i = 0 ; i < N ; i++ ) {
			st = new StringTokenizer(br.readLine());
			nInfo[i] = new Diamond(Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken()));
		}
		
		for( int i = 0 ; i < K ; i++ ) {
			st = new StringTokenizer(br.readLine());
			kInfo[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nInfo,  new ComparatorDiaWit());
		Arrays.sort(kInfo);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int index = 0;
		for(int i : kInfo) {
			while(index < N && nInfo[index].weight <= i) {
				pq.add(nInfo[index].price);
				index++;
			}
			if(!pq.isEmpty()) {
				totalPrice += pq.poll();
			}

		}
		
		System.out.println(totalPrice);

	}
	static class Diaindex implements Comparable<Diaindex> {
		int index;
		int weight;
		int price;
		
		public Diaindex(int index ,int weight,  int price) {
			this.index =index;
			this.weight =  weight;
			this.price = price;
		}

		@Override
		public int compareTo(Diaindex o) {
			 if (this.price < o.price) {
				 return 1;
			 }else if(this.price > o.price) {
				 return -1;
			 }else{
				 if(this.weight < o.weight) {
					 return -1;
				 }else if(this.weight > o.weight){
					 return 1;
				 }else {
					 return 0;
				 }
			 }
		}
		
	}
	
	static class Diamond{
		int index;
		int weight;
		int price;
		
		public Diamond( int weight , int price) {
			this.weight = weight;
			this.price = price;
		}
		
		public Diamond(int index , int weight , int price) {
			this.index =index;
			this.weight = weight;
			this.price = price;
		}
		
		
	}
	
	static class Bag{
		int limit;
		public Bag(int limit) {
			this.limit = limit;
		}
		
		public int getLimit(){
			return this.limit;
		}
	}
	
	static class ComparatorDia implements Comparator<Diamond>{
		
		public int compare(Diamond o1, Diamond o2) {
			int firstPrice = o1.price;
			int secondPrice = o2.price;
			if (firstPrice > secondPrice) {
				return -1;
			}else if(firstPrice < secondPrice) {
				return 1;
			}else {
				return 0;
			}
		}
		
	}
	
	static class ComparatorDiaWit implements Comparator<Diamond>{
		
		public int compare(Diamond o1, Diamond o2) {
			int firstPrice = o1.weight;
			int secondPrice = o2.weight;
			if (firstPrice > secondPrice) {
				return 1;
			}else if(firstPrice < secondPrice) {
				return -1;
			}else {
				return 0;
			}
		}
		
	}
	
	static class ComparatorBag implements Comparator<Bag>{
			
			public int compare(Bag o1, Bag o2) {
				int firstPrice = o1.getLimit();
				int secondPrice = o2.getLimit();
				if (firstPrice > secondPrice) {
					return 1;
				}else if(firstPrice < secondPrice) {
					return -1;
				}else {
					return 0;
				}
			}
			
		}

}

