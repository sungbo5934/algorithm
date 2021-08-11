package com.algorithm.run.programmers;

import java.util.*;
import java.util.Map.Entry;

public class BestAlbum {
	
	public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answerList = new ArrayList<Integer>();
        Map<String, Integer> playsMap = new HashMap<String, Integer>();
        
        for(int i = 0 ; i < plays.length ; i++) {
        	playsMap.put(genres[i], playsMap.getOrDefault(genres[i], 0) + plays[i] );
        }
        List<Entry<String, Integer>> entry = new ArrayList<>(playsMap.entrySet());
        entry.sort(Entry.comparingByValue(Collections.reverseOrder()));

        for(Entry<String, Integer> key : entry) {
        	Map<Integer, Integer> genreMap = new HashMap<Integer, Integer>();
        	for(int i = 0 ; i < genres.length ; i++) {
            	if(key.getKey().equals(genres[i])) {
            		genreMap.put(i, plays[i]);
            	}
            }
        	
        	List<Entry<Integer, Integer>> genreEntry = new ArrayList<>(genreMap.entrySet());
        	genreEntry.sort(Entry.comparingByValue(Collections.reverseOrder()));
        	int index = 0;
        	for(Entry<Integer, Integer> genreKey : genreEntry) {
        		answerList.add(genreKey.getKey());
        		index++;;
        		if(index >= 2) {
        			break;
        		}
        	}
        }
        
        return answerList.stream().mapToInt(data -> data).toArray();
    }	

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop", "action"};
		int[] plays = {2500, 600, 800, 800, 2500, 500};
		System.out.println(Arrays.toString(solution(genres, plays)));;

	}

}
