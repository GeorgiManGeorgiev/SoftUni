function solve() {

    document.querySelector('button').addEventListener('click', onClick);

    let list = {};

//съставяме списък
    let items = document.querySelectorAll('ol > li');
    [...items].forEach(e => {
// попълваме в асоциативен масив по букви
        if (e.textContent.trim().length === 0) {
            return;
        }
        // regardless of input case names should be with capital first letter
        let letter = e.textContent[0].toLocaleUpperCase();
        list[letter] = e.textContent;
    });


    function onClick() {
        let input = document.querySelector('input');
        let value = input.value.toLocaleLowerCase();
        value =  value[0].toLocaleUpperCase() + value.substring(1);
        let letter = value[0];


            //добавяме към списък
        if (list.hasOwnProperty(letter)==false){
            list[letter] = value;
        }else {
            list[letter] = list[letter] +  ', ' + value;
        }
            //модифицираме дом
        let index =letter.charCodeAt(0) - 65;
            items[index].textContent = list[letter];
            input.value = '';
    };

}