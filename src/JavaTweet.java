import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Status;

import java.util.List;

public class JavaTweet {

    public static void main(String[] args) {

            Twitter twitter = TwitterFactory.getSingleton();
            methodPost(twitter);
            methodRequest(twitter);

    }

    static void methodPost(Twitter twitter){
        try {
            twitter.updateStatus("Post using Twitter4J");
            System.out.println("Successfully updated the status in Twitter.");
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }
    static void methodRequest(Twitter twitter){
        try {
            int totalTweets = 10; // no of tweets to be fetched
            Paging paging = new Paging(1, totalTweets);
            List<Status> tweets = twitter.getHomeTimeline(paging);

            for (Status tweet : tweets) {
                System.out.println("Tweet ID: "+ tweet.getId());
                System.out.println("Name: "+ tweet.getUser().getScreenName());
                System.out.println("Tweet: "+ tweet.getText());
            }
            System.out.println("Successfully fetched 10 status from Twitter.");
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }

}