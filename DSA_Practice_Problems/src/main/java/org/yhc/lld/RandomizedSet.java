package org.yhc.lld;

import java.util.*;

public class RandomizedSet {
    private List<Integer> list;

    //key - given val and value - index of list
    private Map<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val){
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val){
        if(!map.containsKey(val)){
            return false;
        }

        //Insert the last element at index of "val" and remove the last element to maintain O(1)
        int index = map.get(val);
        int lastElement = list.getLast();
        list.set(index, lastElement);
        map.put(lastElement, index);

        list.removeLast();
        map.remove(val);

        return true;
    }

    public int random(){
        int randomIdx = random.nextInt(list.size());
        return list.get(randomIdx);
    }
}
