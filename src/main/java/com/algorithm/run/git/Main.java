package com.algorithm.run.git;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {
	static int N;
	static int K;
	static List<Diamond> nInfo;
	static List<Bag> kInfo;
	static Boolean[] visited;
	static long totalPrice = 0;
	static int giveCnt = 0;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nInfo = new ArrayList<Diamond>();
		kInfo = new ArrayList<Bag>();
		
		for( int i = 0 ; i < N ; i++ ) {
			st = new StringTokenizer(br.readLine());
			nInfo.add(new Diamond(i ,Integer.parseInt(st.nextToken()) , Integer.parseInt(st.nextToken())));
		}
		
		for( int i = 0 ; i < K ; i++ ) {
			st = new StringTokenizer(br.readLine());
			kInfo.add(new Bag(Integer.parseInt(st.nextToken())));
		}
		
		//Collections.sort(nInfo, new ComparatorDia());
		Collections.sort(kInfo, new ComparatorBag());

		/*
		 * for(Diamond dia : nInfo) { if(giveCnt < K ) { for(int i = 0 ; i <
		 * kInfo.size() ; i++) { if(dia.getWeight() <= kInfo.get(i).getLimit()) {
		 * totalPrice += dia.getPrice(); giveCnt++; kInfo.remove(i); break; } } }else {
		 * break; } }
		 */
		
//		for(Bag bag : kInfo) {
//			if(giveCnt < K ) {
//				for(int i=0 ; i < nInfo.size() ; i++) {
//					if(nInfo.get(i).getWeight() <= bag.getLimit()) {
//						totalPrice += nInfo.get(i).getPrice();
//						giveCnt++;
//						nInfo.remove(i);
//						break;
//					}
//				}
//			}else {
//				break;
//			}
//		}
		for(Bag bag : kInfo) {
			if(giveCnt < K ) {
				List<Diamond> list = nInfo.stream().filter(data -> data.getWeight() <= bag.getLimit()).collect(Collectors.toList());
				if(list != null) {
					Collections.sort(list, new ComparatorDia());
					for(int i=0 ; i < list.size() ; i++) {
						if(list.get(i).getWeight() <= bag.getLimit()) {
							totalPrice += list.get(i).getPrice();
							giveCnt++;
							nInfo.remove(list.get(i));
							break;
						}
					}
				}
			}else {
				break;
			}
		}
		
		System.out.println(totalPrice);

	}
	
	static class Diamond{
		int index;
		int weight;
		int price;
		public Diamond(int index ,int weight , int price) {
			this.index = index;
			this.weight = weight;
			this.price = price;
		}
		
		public int getIndex(){
			return this.index;
		}
		
		public int getWeight(){
			return this.weight;
		}
		
		public int getPrice(){
			return this.price;
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
			int firstPrice = o1.getPrice();
			int secondPrice = o2.getPrice();
			if (firstPrice > secondPrice) {
				return -1;
			}else if(firstPrice < secondPrice) {
				return 1;
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
