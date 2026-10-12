
import java.util.HashMap;
import java.util.Map;

public class DesignAuthenticationManager {

    private int timeToLive;
    private Map<String, Integer> tokens;

    public DesignAuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {

        if (tokens.containsKey(tokenId)
                && tokens.get(tokenId) > currentTime) {

            tokens.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {

        int count = 0;

        for (int expiryTime : tokens.values()) {
            if (expiryTime > currentTime) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        DesignAuthenticationManager manager =
                new DesignAuthenticationManager(5);

        manager.generate("token1", 1);
        manager.generate("token2", 2);

        System.out.println(manager.countUnexpiredTokens(3));

        manager.renew("token1", 4);

        System.out.println(manager.countUnexpiredTokens(6));

        manager.renew("token2", 7);

        System.out.println(manager.countUnexpiredTokens(7));
    }
}
