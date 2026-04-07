package org.yhc.lld.ratelimiter;

import java.util.*;

public class RateLimiter {

    /**
     * Sliding window Log Algo
     */
    private final int maxRequest;
    private final long windowSize;
    private final Map<String, Deque<Long>> userRequests;

    public RateLimiter(int maxRequest, long windowSize){
        this.maxRequest = maxRequest;
        this.windowSize = windowSize;
        userRequests = new HashMap<>();
    }

    public synchronized boolean allowRequest(String userId, long timestamp){

        userRequests.putIfAbsent(userId, new ArrayDeque<>());
        Deque<Long> timestamps = userRequests.get(userId);

        // Remove expired timestamps
        while (!timestamps.isEmpty() && timestamp - timestamps.peekFirst() >= windowSize){
            timestamps.pollFirst();
        }

        if (timestamps.size() < maxRequest){
            timestamps.addLast(timestamp);
            return true;
        }
        return false;
    }
}
