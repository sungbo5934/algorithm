package com.algorithm.run.programmers;

public class SkilTree {
	
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String tree : skill_trees) {
        	int index = 0;
        	answer++;
        	for(int i = 0 ;  i < skill.toCharArray().length ; i++) {
        		int curIndex = tree.indexOf(String.valueOf(skill.toCharArray()[i]));;
        		if(i != 0 ) {
        			if(index == -1) {
        				if(curIndex > -1) {
        					answer--;
        					break;
        				}
        			}else {
        				if(curIndex == -1 || curIndex > index) {

        				}else {
        					answer--;
        					break;
        				}
        			}
        		}
        		index = curIndex;

        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		String[] str = {"BADE", "BADF", "ACEB", "BDA"};
		System.out.println(solution("CB",str));
	}

}
