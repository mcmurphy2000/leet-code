import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

class AuthenticationManager {

    private final int timeToLive;
    private final Map<String, Integer> tokenToExpiry;
    private final NavigableMap<Integer, Set<String>> expiryToTokens;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokenToExpiry = new HashMap<>();
        expiryToTokens = new TreeMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        int expiry = currentTime + timeToLive;
        tokenToExpiry.put(tokenId, expiry);
        expiryToTokens.computeIfAbsent(expiry, k -> new HashSet<>()).add(tokenId);
    }

    public void renew(String tokenId, int currentTime) {
        cleanExpired(currentTime);
        Integer expiry = tokenToExpiry.get(tokenId);
        if (expiry != null) {
            int newExpiry = currentTime + timeToLive;
            tokenToExpiry.put(tokenId, newExpiry);
            expiryToTokens.get(expiry).remove(tokenId);
            expiryToTokens.computeIfAbsent(newExpiry, k -> new HashSet<>()).add(tokenId);
        }

    }

    public int countUnexpiredTokens(int currentTime) {
        cleanExpired(currentTime);
        return tokenToExpiry.size();
    }

    private void cleanExpired(int currentTime) {
        NavigableMap<Integer, Set<String>> toRemove = expiryToTokens.headMap(currentTime, true);
        toRemove.values().stream()
                .flatMap(Collection::stream)
                .forEach(tokenToExpiry::remove);
        Iterator<Map.Entry<Integer, Set<String>>> it = toRemove.entrySet().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */