package heap.leetcodeProblems;

import java.util.*;

public class Design_Twitter_355 {

    public static void main(String[] args) {
     Twitter twitter = new Twitter();

     String[] funcStrs = {"Twitter","postTweet"
             ,"postTweet","postTweet","postTweet"
             ,"postTweet","postTweet","postTweet"
             ,"postTweet","postTweet","postTweet"
             ,"postTweet","getNewsFeed"};

     int[][] paramArr = {{},{1,5},{1,3},{1,101},{1,13},{1,10},{1,2},{1,94},{1,505},{1,333},{1,22},{1,11},{1}};

     for (int i=0; i< funcStrs.length; i++){
         String funcStr = funcStrs[i];
         switch (funcStr){
             case "Twitter":
                 twitter = new Twitter();
                 break;
             case "postTweet":
                 twitter.postTweet(paramArr[i][0],paramArr[i][1]);
                 break;
             case "getNewsFeed":
                 List<Integer> list = twitter.getNewsFeed(paramArr[i][0]);
                 System.out.println("News Feed " + list);
                 break;
             case "follow":
                 twitter.follow(paramArr[i][0],paramArr[i][1]);
                 break;
             case "unfollow":
                 twitter.unfollow(paramArr[i][0],paramArr[i][1]);
                 break;
         }
     }

    }

}

class Twitter {

    private final List<int[]> feedStack;
    private final HashMap<Integer, List<Integer>> followingMap;

    public Twitter() {
        feedStack = new ArrayList<>();
        followingMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        feedStack.add(new int[]{userId,tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();
        List<Integer> followingList = followingMap.get(userId);

        /*if (followingList != null && !followingMap.isEmpty()){
            for (Integer id : followingList) {
                for (int i = feedStack.size() - 1; i >= 0; i--) {
                    int[] arr = feedStack.get(i);
                    if (arr[0] == id)
                        res.add(arr[1]);
                    else if (arr[0] == userId)
                        res.add(arr[1]);
                }
            }
        }else {
            for (int[] arr : feedStack){
                if (arr[0] == userId)
                    res.add(arr[1]);
            }
        }*/


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

    public void unfollow(int followerId, int followeeId) {
        if (!followingMap.containsKey(followerId))
            return;
        List<Integer> followingList = followingMap.get(followerId);
        followingList.remove(Integer.valueOf(followeeId));
        followingMap.put(followerId,followingList);
    }
}

