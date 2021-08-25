package com.algorithm.run.baekjoon;

import java.util.*;
import java.util.stream.Collectors;

public class Bulk {
	
	public static class Person{
		private int weight;
		private int tall;
		
		public Person() {}
		
		public Person(int weight, int tall) {
			this.weight =  weight;
			this.tall = tall;
		}
		
		public String toString() {
			return " weight : "+ weight + ", tall : " + tall; 
		}
	}
	
	public static int find(List<Person> list, int weight, int tall, int index) {
		int cnt = 0;
		for(int i = 0 ; i < list.size() ; i++) {
			if(i != index) {
				if(list.get(i).weight > weight && list.get(i).tall > tall) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] answer = new int[n];
		List<Person> list = new ArrayList<Person>();
		for(int i = 0 ; i < n ; i++) {
			String str = sc.nextLine();
			String weight = str.split(" ")[0];
			String tall = str.split(" ")[1];
			list.add(new Person(Integer.parseInt(weight), Integer.parseInt(tall)));
		}
		
		for(int i = 0 ; i < list.size() ; i++) {
			int cnt = find(list, list.get(i).weight, list.get(i).tall, i);
			answer[i] = cnt + 1;
		}
		
		System.out.println(Arrays.stream(answer).mapToObj(data -> String.valueOf(data)).collect(Collectors.joining(" ")));
	}

}
