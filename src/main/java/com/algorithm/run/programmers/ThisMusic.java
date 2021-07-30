package com.algorithm.run.programmers;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ThisMusic {
	
	public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxMinute = 0;
        
        for(String music : musicinfos) {
        	String start = music.split(",")[0];
        	String end = music.split(",")[1];
        	
        	LocalTime startTime = LocalTime.of(Integer.parseInt(start.split(":")[0]),Integer.parseInt(start.split(":")[1]),00,00); 
        	LocalTime endTime   = LocalTime.of(Integer.parseInt(end.split(":")[0]),Integer.parseInt(end.split(":")[1]),00,00);
        	
        	int minute = (int)ChronoUnit.MINUTES.between(startTime, endTime);

        	String name = music.split(",")[2];
        	
        	String detail = music.split(",")[3];
        	
        	String allDetail = "";
        	
        	List<String> list =new ArrayList<String>();
        	for(int i = 0 ; i < detail.length() ; i++) {
        		if(String.valueOf(detail.toCharArray()[i]).equals("#")) {
        			list.set(list.size() -1, list.get(list.size() -1) + "#");
        		}else {
        			list.add(String.valueOf(detail.toCharArray()[i]));
        		}
        	}
        	
        	for(int i = 0 ; i < minute ; i++) {
    			allDetail += list.get(i % list.size());
    		}
        	
        	int index = allDetail.replace(m, "0").replace("0#", "").indexOf("0");

        	if(index > -1 ) {
        		if(minute > maxMinute) {
        			answer = name;
        			maxMinute = (int)minute;
        		}
        	}

        	
        }
        return answer;
    }

	public static void main(String[] args) {
		String[] str = {"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"};
		
		System.out.println(solution("CCB",str));

	}

}
