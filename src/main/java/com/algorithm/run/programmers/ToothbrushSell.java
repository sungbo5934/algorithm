package com.algorithm.run.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class ToothbrushSell {
	
	static Map<String, Integer> enrollList = new LinkedHashMap<String, Integer>();
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
	    int[] answer = new int[enroll.length];
	    Map<String, List<String>> map = new HashMap<String, List<String>>();
	    
	    for(int i = 0 ; i < enroll.length ; i++) {
	    	enrollList.put(enroll[i], i);
	    }
	    
	    for(int i = 0 ; i < enroll.length ; i++) {
	    	List<String> list = new ArrayList<String>();
	    	list.add(enroll[i]);
	    	findParent(list, referral, enroll[i]);
	    	map.put(enroll[i], list);
	    }
	    
	    Map<String, Integer> answerMap = new HashMap<String, Integer>();
	    for(int i = 0 ; i < seller.length ; i++) {
	    	String sellerNm = seller[i];
	    	int amountCh = amount[i] * 100;
	    	List<String> list = map.get(sellerNm);
	    	
	    	for(String member : list) {
	    		if(amountCh / 10 > 0) {
	    			answerMap.put(member, answerMap.getOrDefault(member, 0) + (amountCh - (amountCh / 10)));
	    			amountCh = (amountCh / 10);
	    		}else {
	    			answerMap.put(member, answerMap.getOrDefault(member, 0) + amountCh);
	    			break;
	    		}
	    	}
	    }
	    int j = 0;
	    for(String key : enrollList.keySet()) {
	    	answer[j] = answerMap.getOrDefault(key, 0);
	    	j++;
	    }
	    
	    return answer;
	}
	
	public static void findParent(List<String> list, String[] referral, String key) {
		int index = enrollList.get(key);
		if(index >= 0 && !referral[index].equals("-")) {
			list.add(referral[index]);
			findParent(list, referral, referral[index]);
		}else {
			return;
		}
	}

	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));;

	}

}
