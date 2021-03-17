function solve() {
    const createBtn = document.querySelector('aside section button');
    const author = document.getElementById('creator');
    const title = document.getElementById('title');
    const cat = document.getElementById('category');
    const content = document.getElementById('content');
    const posts = document.querySelector('main>section');
    const archOl =  document.querySelector('.archive-section').lastElementChild;


    createBtn.addEventListener('click', (e) => {
        e.preventDefault();

        let article = document.createElement('article');

        let delBtn = document.createElement('button');
        delBtn.className = 'btn delete';
        delBtn.textContent = 'Delete';

        //event
        delBtn.addEventListener('click',(e)=>{
           e.target.parentNode.parentNode.remove();

        })

        let archBtn = document.createElement('button');
        archBtn.className = 'btn archive';
        archBtn.textContent = 'Archive';

        //event
        archBtn.addEventListener('click',(e)=>{
        let result= [];
        let text = e.target.parentNode.parentNode.firstChild.textContent;
        let li = document.createElement("li");
            li.textContent = text;
            result.push(li)
            let items = Array.from(archOl.children);
            console.log(items)
            if (items.length >= 1){
                items.forEach(e=>result.push(e))
           }
            result.sort((a,b)=>a.textContent.localeCompare(b.textContent))
            result.forEach(e=>archOl.appendChild(e));
            e.target.parentNode.parentNode.remove();
        })




        let divButtons = document.createElement('div');
        divButtons.className = 'buttons';

        let pContent = document.createElement('p');
        pContent.textContent = content.value;

        let strongCr = document.createElement('strong');
        strongCr.textContent = author.value;

        let pCreator = document.createElement('p');
        pCreator.textContent = 'Creator:';

        let strongCat = document.createElement('strong');
        strongCat.textContent = cat.value;

        let pCat = document.createElement('p');
        pCat.textContent = 'Category:';

        let h1Title = document.createElement('h1');
        h1Title.textContent = title.value;


        article.appendChild(h1Title);

        pCat.appendChild(strongCat);
        article.appendChild(pCat);

        pCreator.appendChild(strongCr)
        article.appendChild(pCreator);

        article.appendChild(pContent);

        divButtons.appendChild(delBtn);
        divButtons.appendChild(archBtn);
        article.appendChild(divButtons);


        posts.appendChild(article);


    })

}
