package com.algorithm.run.backjun;

import java.util.*;

public class MapTest {

	static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
//	public static int[] solution(int[] prices) {
//        int[] answer = new int[prices.length];
//        for(int i = 0 ; i < prices.length ; i++) {
//        	List<Integer> indexList = map.getOrDefault(prices[i], new ArrayList<Integer>());
//        	indexList.add(i);
//        	map.put(prices[i], indexList);
//        }
//        
//        for(int i = 0 ; i < prices.length ; i++) {
//        	answer[i] = findPrice(prices[i], i);
//        }
//        
//        return answer;
//    }
//	
//    public static int findPrice(int num,  int index) {
//        int cnt = 0;
//        for(int key : map.keySet()) {
//        	if(key > num) {
//        		List<Integer> list = map.get(key);
//        		cnt += (int)list.stream().filter(data -> data > index).count();
//        	}
//        }
//        return cnt;
//    }
    
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0 ; i < prices.length ; i++) {
            findPrice(answer, prices, i, prices[i]);
        }
        return answer;
    }
    public static void findPrice(int[] answer, int[] prices, int index, int price) {
        int cnt = 0;
        int[] arr = Arrays.copyOfRange(prices, index + 1, prices.length);
        Arrays.sort(arr);
        for(int i = arr.length - 1 ; i >= 0 ; i--) {
            if(arr[i] > price) {
                cnt++;
            }else {
                break;
            }
        }
        answer[index] = cnt;
    }
    
    public static void main(String[] args) {
    	int[] arr = {1,2,3,52,62,46,2346,24,62,46,2,4,213,4,31,5,3,51,2,41,25,412,5,15,1,3,342,3,12,3,12,5,1241,5,4,6,435,7,4538,32,3,5472,345,13,4,12,4,12,3,12,312,3,13,1,254,1,256,165,1,123,12,54,12,51,35,24,6,3,734,7,34,5,34,534,6,34,7,37,347,35,73,1,2,3,52,62,46,2346,24,62,46,2,4,213,4,31,5,3,51,2,41,25,412,5,15,1,3,342,3,12,3,12,5,1241,5,4,6,435,7,4538,32,3,5472,345,13,4,12,4,12,3,12,312,3,13,1,254,1,256,165,1,123,12,54,12,51,35,24,6,3,734,7,34,5,34,534,6,34,7,37,347,35,73,1,2,3,52,62,46,2346,24,62,46,2,4,213,4,31,5,3,51,2,41,25,412,5,15,1,3,342,3,12,3,12,5,1241,5,4,6,435,7,4538,32,3,5472,345,13,4,12,4,12,3,12,312,3,13,1,254,1,256,165,1,123,12,54,12,51,35,24,6,3,734,7,34,5,34,534,6,34,7,37,347,35,73,1,2,3,52,62,46,2346,24,62,46,2,4,213,4,31,5,3,51,2,41,25,412,5,15,1,3,342,3,12,3,12,5,1241,5,4,6,435,7,4538,32,3,5472,345,13,4,12,4,12,3,12,312,3,13,1,254,1,256,165,1,123,12,54,12,51,35,24,6,3,734,7,34,5,34,534,6,34,7,37,347,35,73,1,2,3,52,62,46,2346,24,62,46,2,4,213,4,31,5,3,51,2,41,25,412,5,15,1,3,342,3,12,3,12,5,1241,5,4,6,435,7,4538,32,3,5472,345,13,4,12,4,12,3,12,312,3,13,1,254,1,256,165,1,123,12,54,12,51,35,24,6,3,734,7,34,5,34,534,6,34,7,37,347,35,73,1,2,3,52,62,46,2346,24,62,46,2,4,213,4,31,5,3,51,2,41,25,412,5,15,1,3,342,3,12,3,12,5,1241,5,4,6,435,7,4538,32,3,5472,345,13,4,12,4,12,3,12,312,3,13,1,254,1,256,165,1,123,12,54,12,51,35,24,6,3,734,7,34,5,34,534,6,34,7,37,347,35,73};
    	long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
    	System.out.println(Arrays.toString(solution(arr)));;
    	long afterTime = System.currentTimeMillis();
    	long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
    	System.out.println("시간차이(m) : "+secDiffTime);
    }

}
