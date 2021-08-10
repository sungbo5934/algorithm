package com.algorithm.run.programmers;


import java.time.LocalTime;
import java.util.*;

public class ShuttleBus {

	public static String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
        LocalTime lt = LocalTime.of(9, 0);
        LocalTime answerLt = null;
        int index = 0;
        for(int i = 1 ; i <= n ; i++) {
        	int total = 0;
        	if(i != 1) {
        		lt = lt.plusMinutes(t );
        	}
        	
        	for(int j = index ; j < timetable.length ; j++ ) {
        		LocalTime timeLt = LocalTime.of(Integer.parseInt(timetable[j].split(":")[0]), Integer.parseInt(timetable[j].split(":")[1]));
        		if( i ==  n ) {
        			if(lt.equals(timeLt) || lt.isAfter(timeLt)) {
            			total++;
            			if(total == m) {
            				answerLt = timeLt.minusMinutes(1);
            				break;
            			}
            		}
        			
        			if(total < m && j == timetable.length - 1) {
        				answerLt = lt;
        			}
        			
        		}else {
        			if(lt.equals(timeLt) || lt.isAfter(timeLt)) {
        				index = j + 1;
            			total++;
            			if(total == m) {
            				break;
            			}
            		}
        		}
        	}
        	
        }
        
        if(answerLt == null) {
        	lt = LocalTime.of(9, 0);
        	answerLt = lt.plusMinutes(t * (n - 1));
        }
        return answerLt.toString();
    }
	
	public static void main(String[] args) {
		String[] str = {"08:00", "08:01", "08:02", "08:03","09:00","09:00","09:00","09:00","09:00","09:00","09:00"};
		System.out.println(solution(3,5,5,str));;

	}

}
