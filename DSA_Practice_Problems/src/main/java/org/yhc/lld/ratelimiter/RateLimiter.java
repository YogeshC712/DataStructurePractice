package org.yhc.lld.ratelimiter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RateLimiter {
    private Map<String, Queue<Long>> map = new HashMap<>();
    private final int LIMIT = 10;
    private final int WINDOW = 60000; //1 minute

    public synchronized boolean allowRequest(String userId){
        Long now = System.currentTimeMillis();

        map.putIfAbsent(userId, new LinkedList<>());
        Queue<Long> queue = map.get(userId);

        while (!queue.isEmpty() && now - queue.peek() > WINDOW){
            queue.poll();
        }

        if (queue.size() < LIMIT){
            queue.offer(now);
            return true;
        }
        return false;
    }
}
