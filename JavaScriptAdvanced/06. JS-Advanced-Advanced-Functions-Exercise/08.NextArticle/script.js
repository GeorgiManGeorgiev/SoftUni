function getArticleGenerator(articles) {
    let content = document.getElementById("content");

    return next = () => {
        let first = articles.shift();
        if (first != undefined) {
            let article = document.createElement("article");
            article.textContent += first;
            content.appendChild(article)
            return content
        }
    }
}