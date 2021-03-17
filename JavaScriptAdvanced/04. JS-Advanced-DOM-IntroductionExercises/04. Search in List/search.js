function search() {
    let listItems = document.querySelectorAll('#towns li');
    let input = document.getElementById('searchText').value;
    let result = document.getElementById('result');
    let elements = Array.from(listItems);
    let sum = 0;
    for (const li of elements) {
        if ((li.textContent).toLowerCase().includes(input.toLowerCase()) && input !== '') {
            li.style.fontWeight = 'bold';
            li.style.textDecoration = 'underline';
            sum++;
        } else {
            li.style.fontWeight = '';
            li.style.textDecoration = '';
        }
    }
    document.getElementById('searchText').value = '';
    result.textContent = `${sum} matches found`;
}
