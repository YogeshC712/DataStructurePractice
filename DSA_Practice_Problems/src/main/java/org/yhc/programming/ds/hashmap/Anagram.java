package org.yhc.programming.ds.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Two strings are anagrams if:
 * They contain the same characters
 * With the same frequency
 * Order does NOT matter
 */
public class Anagram {
    /*
    Questions should get clarified -
        Are strings case-sensitive?
        Should spaces be ignored?
        Should special characters be ignored?
        Can input contain Unicode?
        What is maximum input size?
     */
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        System.out.println("Is Anagram? -> " + isAnagram(s1, s2));
        System.out.println("Is Anagram using Map? -> " + isAnagramUsingHashMap(s1, s2));
    }

    /**
     * This method can be used when strings are case-insensitive and the Unicode characters NOT present
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isAnagram(String s1, String s2) {
        if(s1 == null || s2 == null) return false;

        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        if(s1.length() != s2.length()) return false;

        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 'a']++;
            chars[s2.charAt(i) - 'a']--;
        }

        for (int i: chars) {
            if(i != 0) return false;
        }
        return true;
    }

    private static boolean isAnagramUsingHashMap(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if(!map.containsKey(c)) return false;

            map.put(c, map.get(c) - 1);
            if(map.get(c) == 0){
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}
