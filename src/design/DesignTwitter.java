package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DesignTwitter {
    private final List<int[]> feedStack;
    private final HashMap<Integer, List<Integer>> followingMap;

    /** Initialize your data structure here. */
    public DesignTwitter() {
        feedStack = new ArrayList<>();
        followingMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        feedStack.add(new int[]{userId,tweetId});
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<Integer> followingList = followingMap.get(userId);

        if (followingList != null && !followingList.isEmpty()){
            for (int[] arr : feedStack) {
                int uID = arr[0];
                int tweetID = arr[1];

                if (followingList.contains(uID))
                    res.add(tweetID);
                else if (uID == userId)
                    res.add(tweetID);
            }
        }else {
            for (int[] arr : feedStack){
                if (arr[0] == userId)
                    res.add(arr[1]);

            }
        }

        if (res.size()>10){
            int dif = res.size() - 10;
            res = res.subList(dif, res.size());
        }

        Collections.reverse(res);
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        List<Integer> followingList;
        if (followingMap.containsKey(followerId)){
            followingList = followingMap.get(followerId);
        }
        else {
            followingList = new ArrayList<>();
        }
        followingList.add(followeeId);
        followingMap.put(followerId,followingList);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!followingMap.containsKey(followerId))
            return;
        List<Integer> followingList = followingMap.get(followerId);
        followingList.remove(Integer.valueOf(followeeId));
        followingMap.put(followerId,followingList);
    }
}
