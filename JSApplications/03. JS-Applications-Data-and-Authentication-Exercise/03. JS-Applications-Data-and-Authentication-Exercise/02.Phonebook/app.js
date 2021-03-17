function attachEvents() {
    const loadBtn = document.getElementById('btnLoad');
    loadBtn.addEventListener('click', getAllPhonebookEntries);
    const createBtn = document.getElementById('btnCreate');
    createBtn.addEventListener("click", createEntry);

}
attachEvents();

async function getAllPhonebookEntries() {
    const ul = document.getElementById('phonebook');
    ul.innerHTML = '';
    const result = await request('http://localhost:3030/jsonstore/phonebook');

    Object.values(result).map(e => {
        const li = document.createElement("li");
        const delBtn = document.createElement('button');
        delBtn.addEventListener('click', (e) => deleteEntry(e))
        delBtn.setAttribute('id', 'delBtn')
        delBtn.textContent = 'Delete';
        li.textContent = `${e.person}: ${e.phone}`;
        li.setAttribute('id', e._id);
        li.appendChild(delBtn);
        ul.appendChild(li);
    })
}

async function deleteEntry(e) {
    const id = e.target.parentNode.id;
    await request('http://localhost:3030/jsonstore/phonebook/' + id, {
        method: 'delete'
    })
    getAllPhonebookEntries();
}

async function createEntry() {
    const personInput = document.getElementById('person');
    const phoneInput = document.getElementById('phone');

    const entry = {
        person: personInput.value,
        phone: phoneInput.value
    };

    await request('http://localhost:3030/jsonstore/phonebook', {
        method: 'post',
        headers: {'Content-type': 'application/json'},
        body: JSON.stringify(entry)
    });
    personInput.value = '';
    phoneInput.value = '';

    getAllPhonebookEntries();
}

async function request(url, options) {
    const response = await fetch(url, options);
    if (response.ok != true) {
        const error = await response.json();
        alert(error.message);
        throw new Error(error.message);
    }
    const data = await response.json();
    return data;
}