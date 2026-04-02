package org.yhc.lld.ratelimiter;

import java.util.*;

public class RateLimiter {

    /**
     * Sliding window Algo
     */
    private final int maxRequest;
    private final long windowSizeInMillis;
    private final Map<String, Deque<Long>> userRequests;

    public RateLimiter(int maxRequest, long windowSizeInMillis){
        this.maxRequest = maxRequest;
        this.windowSizeInMillis = windowSizeInMillis;
        userRequests = new HashMap<>();
    }

    public synchronized boolean allowRequest(String userId){
        Long currentTime = System.currentTimeMillis();

        userRequests.putIfAbsent(userId, new ArrayDeque<>());
        Deque<Long> timestamps = userRequests.get(userId);

        // Remove expired timestamps
        while (!timestamps.isEmpty() && currentTime - timestamps.peekFirst() > windowSizeInMillis){
            timestamps.pollFirst();
        }

        if (timestamps.size() < maxRequest){
            timestamps.addLast(currentTime);
            return true;
        }
        return false;
    }
}
