package B_FM.ObjectsAndClasses;

import java.util.Scanner;


public class MainArticles {

    public static class Article {
        private String title;
        private String content;
        private String author;

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;

        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(", ");

        String title = input[0];
        String content = input[1];
        String author = input[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(": ");
            String command = tokens[0];
            String param = tokens[1];

            if (command.equals("Edit")) {
                article.setContent(param);
            } else if (command.equals("ChangeAuthor")) {
                article.setAuthor(param);
            } else {
                article.setTitle(param);
            }
        }

        System.out.printf("%s - %s: %s",
                article.getTitle(),
                article.getContent(),
                article.getAuthor());
    }
}
