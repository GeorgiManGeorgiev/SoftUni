import {html, render} from 'https://unpkg.com/lit-html?module';

const listTemplate = (data) => html`
    <ul>
        ${data.map(t => html`
            <li>${t}</li>`)}
    </ul>
`;

document.getElementById('btnLoadTowns').addEventListener('click', updateList);

function updateList(event) {
    event.preventDefault();

    const townsAsString = document.getElementById('towns').value;
    const towns = townsAsString.split(',').map(e=>e.trim());
    const result = listTemplate(towns);
    const target = document.getElementById('root');
    render(result, target);
    document.getElementById('towns').value = '';
}

