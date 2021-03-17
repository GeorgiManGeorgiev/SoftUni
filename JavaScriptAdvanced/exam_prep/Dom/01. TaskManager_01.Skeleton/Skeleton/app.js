function solve() {
    //get input and validate

    const openSection = document.getElementsByTagName("section")[1];
    const addBtn = document.getElementById('add');
    const progressSection = document.getElementsByTagName('section')[2];
    const completeSection = document.getElementsByTagName('section')[3];


    addBtn.addEventListener('click', (e) => {


        e.preventDefault();
        let task = document.getElementById('task');
        let description = document.getElementById('description');
        let date = document.getElementById('date');


        if (task.value === '' || description.value === '' || date.value === '') {
            return;
        }

        let article = document.createElement('article');
        let h3 = document.createElement('h3');
        h3.innerText = task.value;
        let pDescription = document.createElement('p')
        pDescription.innerText = `Description: ${description.value}`
        let pDate = document.createElement('p')
        pDate.innerText = `Due Date: ${date.value}`
        article.appendChild(h3);
        article.appendChild(pDescription);
        article.appendChild(pDate);

        openSection.lastElementChild.appendChild(article)

        let div = document.createElement('div');
        div.className = 'flex';

        let btnStart = document.createElement('button');
        btnStart.className = 'green';
        btnStart.innerText = 'Start';


        let btnDelete = document.createElement('button');
        btnDelete.className = 'red';
        btnDelete.innerText = 'Delete';

        btnDelete.addEventListener('click',deleteArticle);

        btnStart.addEventListener('click', (e) => {
            let finishBtn  = document.createElement('button');
            finishBtn.className = 'orange';
            finishBtn.innerText = 'Finish';
            finishBtn.addEventListener('click',(e)=>{
                article.lastElementChild.remove();
                completeSection.lastElementChild.appendChild(article);
            })
            article.lastElementChild.children[0].remove();
            article.lastElementChild.appendChild(finishBtn);
            progressSection.lastElementChild.appendChild(article);

        });



        div.appendChild(btnStart);
        div.appendChild(btnDelete);


        article.appendChild(div);

        task = '';
        description = '';
        date = '';
    });

    function deleteArticle(event){
        event.target.parentElement.parentElement.remove();
    }

}