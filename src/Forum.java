import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jessicahuffstutler on 10/15/15.
 */
public class Forum {
    public static void main(String[] args) {
        ArrayList<Post> posts = new ArrayList();
        String postContent = readFile("posts");
        String[] lines = postContent.split("\n");

        for (String line : lines) {
            String[] columns = line.split("\\|");
            int replyId = Integer.valueOf(columns[0]);
            String author = columns[1];
            String text = columns[2];
            Post post = new Post(replyId, author, text);
            posts.add(post);
        }

        Scanner scanner = new Scanner(System.in);
        int postId = -1;
        while (true) { //infinite loop
            printPosts(posts, postId);
            System.out.println("Enter post id to see replies.");
            postId = Integer.valueOf(scanner.nextLine());
        }
    }

    static void printPosts(ArrayList<Post> posts, int postId) {
        int id = 0;
        for (Post post : posts) { //"For (Post post : posts) { " POST WAS RED SO WE NEED TO PASS BOTH OF THOSE AS ARGUMENTS but putting them as arguments in the printPosts method above
            if (post.replyId == postId) {
                System.out.println(String.format("[%d] %s (%s)", id, post.text, post.author));
            }
            id++;
        }
    }

    static String readFile(String fileName) { //can paste this into anything that you want to read files (changing fileName and fileContent)
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e) {
            return null;
        }
    }

    static void writeFile(String fileName, String fileContent) { //can paste this into anything that you want to write files (changing fileName and fileContent)
        File f = new File(fileName);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(fileContent);
            fw.close();
        } catch (Exception e) {

        }
    }
}
