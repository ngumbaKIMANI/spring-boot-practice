package com.ngumba.november;

import java.util.HashMap;
import java.util.Map;

public class Solution14 {
    static char solution(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int num = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), num);
        }

        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }

        return '_';
    }

    public static void main(String[] args) {
        System.out.println(solution("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof"));
    }
}