import java.util.*;

public class DesignTwitter {

    static class Tweet {
        int userId;
        int tweetId;
        int time;

        Tweet(int userId, int tweetId, int time) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> following;
    private int time;

    public DesignTwitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(
                new Tweet(userId, tweetId, time++)
        );
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> maxHeap =
                new PriorityQueue<>(
                        (a, b) -> b.time - a.time
                );

        // User's own tweets
        addTweets(userId, maxHeap);

        // Followed users' tweets
        Set<Integer> users =
                following.getOrDefault(
                        userId,
                        new HashSet<>()
                );

        for (int followee : users) {
            addTweets(followee, maxHeap);
        }

        List<Integer> result = new ArrayList<>();

        while (!maxHeap.isEmpty() && result.size() < 10) {
            result.add(maxHeap.poll().tweetId);
        }

        return result;
    }

    private void addTweets(
            int userId,
            PriorityQueue<Tweet> maxHeap) {

        if (!tweets.containsKey(userId)) {
            return;
        }

        for (Tweet tweet : tweets.get(userId)) {
            maxHeap.offer(tweet);
        }
    }

    public void follow(int followerId, int followeeId) {

        following.putIfAbsent(
                followerId,
                new HashSet<>()
        );

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {

        DesignTwitter twitter =
                new DesignTwitter();

        twitter.postTweet(1, 5);

        System.out.println(
                "Feed: " +
                twitter.getNewsFeed(1)
        );

        twitter.follow(1, 2);

        twitter.postTweet(2, 6);

        System.out.println(
                "Feed: " +
                twitter.getNewsFeed(1)
        );

        twitter.unfollow(1, 2);

        System.out.println(
                "Feed: " +
                twitter.getNewsFeed(1)
        );
    }
}
