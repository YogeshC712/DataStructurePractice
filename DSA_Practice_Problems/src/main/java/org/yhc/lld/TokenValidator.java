package org.yhc.lld;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class TokenValidator {
    private final Map<String, Token> tokenMap;
    private final TreeSet<Token> expirySet;

    public TokenValidator(){
        tokenMap = new HashMap<>();
        expirySet = new TreeSet<>(Comparator.comparingLong(Token::getExpiryTime).thenComparing(Token::getTokenId));
    }

    public boolean validate(String tokenId){
        if(tokenMap.isEmpty()) return false;

        //Eviction
        long currentTime = System.currentTimeMillis();
        while (!expirySet.isEmpty() &&
                expirySet.getFirst().getExpiryTime() <= currentTime){
            Token expired = expirySet.pollFirst();
            tokenMap.remove(expired.getTokenId());
        }

        //Validation
        Token token = tokenMap.get(tokenId);
        if(token == null){
            return false;
        }
        return token.getExpiryTime() > currentTime;
    }
}

class Token{
    String tokenId;
    String userId;
    long expiryTime;

    public String getTokenId() {
        return tokenId;
    }

    public String getUserId() {
        return userId;
    }

    public long getExpiryTime() {
        return expiryTime;
    }
}
