function toggle() {
    let btn = document.querySelectorAll('.button')[0];
    let div = document.querySelector('#extra');
    if(div.style.display === 'block'){
        btn.textContent = 'More';
        div.style.display = 'none';
    }else {
        btn.textContent = 'Less';
        div.style.display = 'block';
    }
}