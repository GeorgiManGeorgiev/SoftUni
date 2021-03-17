function solve() {
    document.querySelector('#searchBtn').addEventListener('click', onClick);

    function onClick() {
        const input = document.getElementById('searchField').value.toLowerCase();
        let rows = document.querySelectorAll('tbody tr');


        for (let row of rows) {
            if (row.textContent.toLowerCase().includes(input)){
                row.setAttribute('class','select');

            }else {
                row.removeAttribute('select');
            }
        }
    }
}