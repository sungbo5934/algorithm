package com.algorithm.run.programmers;

import java.util.*;

public class CarSell {
//	public static int[] solution(int[] prices) {
//        int[] answer = new int[prices.length];
//        for(int i = 0 ; i < prices.length ; i++) {
//            findPrice(answer, prices, i, prices[i]);
//        }
//        return answer;
//    }
//    public static void findPrice(int[] answer, int[] prices, int index, int price) {
//        int cnt = 0;
//        int[] arr = Arrays.copyOfRange(prices, index + 1, prices.length);
//        Arrays.sort(arr);
//        for(int i = arr.length - 1 ; i >= 0 ; i--) {
//            if(arr[i] > price) {
//                cnt++;
//            }else {
//                break;
//            }
//        }
//        answer[index] = cnt;
//    }


    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Map<Integer, Integer> priceMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
        
        answer[prices.length - 1] = 0;
        priceMap.put(prices[prices.length - 1], priceMap.getOrDefault(prices[prices.length - 1], 0) + 1);
        
        for(int i = prices.length - 2 ; i > -1 ; i--) {
        	priceMap.put(prices[i], priceMap.getOrDefault(prices[i], 0) + 1);
        	
        	if(prices[i] == prices[i+1]) {
        		answer[i] = answer[i+1];
        	}else {
        		int cnt = 0;
        		for(Integer key : priceMap.keySet()) {
        			if(key > prices[i]) {
        				cnt += priceMap.get(key);
        			}else {
        				break;
        			}
        		}
        		answer[i] = cnt;
        	}
        	
        }
        return answer;
    }
 
	public static void main(String[] args) {
		int[] prices = new int[1000000];
		for(int i = 0 ; i < prices.length ; i++) {
			prices[i] = (int)(Math.random() * 100);
		}
		//int[] prices = {5,2,1,5,9,1,5};
		//int[] prices = {5,2,1,5,9,1,5};
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        
		//실험할 코드 추가
		Arrays.toString(solution(prices));
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
	}

}
