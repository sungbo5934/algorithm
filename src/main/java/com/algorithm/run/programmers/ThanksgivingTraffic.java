package com.algorithm.run.programmers;

import java.time.LocalDateTime;
import java.util.*;

public class ThanksgivingTraffic {
	
	public static int solution(String[] lines) {
        int answer = 0;
        Queue<LocalDateTime> que = new LinkedList<LocalDateTime>();
        
        for(int i = 0 ; i < lines.length ; i++) {
        	LocalDateTime lt2 = getTime(lines[i].split(" ")[1]);
        	LocalDateTime lt1 = getEndTime(lt2, lines[i].split(" ")[2]);
        	que.add(lt1);
        	que.add(lt2);
        	
        }
        
        while(!que.isEmpty()) {
        	int num = 0;
        	LocalDateTime start = que.poll();
        	LocalDateTime end = start.plusNanos(999*1000000);
        	
        	for(int i = 0 ; i < lines.length ; i++) {
        		LocalDateTime lt2 = getTime(lines[i].split(" ")[1]);
            	LocalDateTime lt1 = getEndTime(lt2, lines[i].split(" ")[2]);
            	if(!(lt1.isAfter(end) || lt2.isBefore(start))){
            		num++;
            	}
            }
        	answer = Math.max(answer, num);
        }
        
        
        return answer;
    }
	public static LocalDateTime getTime(String str) {
		
		int hour = Integer.parseInt(str.split(":")[0]);
		int min = Integer.parseInt(str.split(":")[1]);
		int sec = Integer.parseInt(str.split(":")[2].split("\\.")[0]);
		int milSec = Integer.parseInt(str.split(":")[2].split("\\.")[1]); 
		
		LocalDateTime lt = LocalDateTime.of(2019,9,15,hour, min, sec, milSec*1000000); 
		
		return lt;
	}
	
	public static LocalDateTime getEndTime(LocalDateTime lt, String str) {
		str = str.replace("s", "");
		double time = Double.valueOf(str) * 1000 -1;
		return lt.minusNanos((long) (time * 1000000));
	}
	
	public static void main(String[] args) {
		String[] str = {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
		
		//System.out.println(first.equals(end));
		System.out.println(solution(str));
		
		//LocalTime lt = LocalTime.of(12, 12, 12, 1000000);
		//System.out.println(lt);
		//System.out.println(lt.plusNanos(1 * 1000000000));
		
	}

}
