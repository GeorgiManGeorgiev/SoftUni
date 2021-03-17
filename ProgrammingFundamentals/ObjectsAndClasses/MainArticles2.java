package B_FM.ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainArticles2 {

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

        int n = Integer.parseInt(scanner.nextLine());


        List<Article> articles = new ArrayList<>();

        while (n-- > 0) {

            String[] input = scanner.nextLine().split(", ");

            String title = input[0];
            String content = input[1];
            String author = input[2];

            Article article = new Article(title, content, author);

            articles.add(article);

        }
        String criteria = scanner.nextLine();

        if (criteria.equals("title")) {
            articles.sort((f, s) -> f.getTitle().compareTo(s.getTitle()));

        } else if (criteria.equals("content")) {
            articles.sort((f, s) -> f.getContent().compareTo(s.getContent()));
        } else{
            articles.sort((f, s) -> f.getAuthor().compareTo(s.getAuthor()));
        }
        for (Article article :
                articles) {
            System.out.printf("%s - %s: %s%n",
                    article.getTitle(),
                    article.getContent(),
                    article.getAuthor());
        }


    }
}
