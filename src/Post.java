/**
 * Created by jessicahuffstutler on 10/15/15.
 */
public class Post {
    int replyId;
    String author;
    String text;

    public Post(int replyId, String author, String text) { //constuctor (Command n -> generate constructor)
        this.replyId = replyId;
        this.author = author;
        this.text = text;
    }
}
