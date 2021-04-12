import {html, render} from 'https://unpkg.com/lit-html?module';
import {cats as catData} from './catSeeder.js';

const main = document.getElementById('allCats');

const catCardTemplate = (cat) => html`
    <li>
        <img src="./images/${cat.imageLocation}.jpg" width="250" height="250" alt="Card image cap">
        <div class="info">
            <button class="showBtn">Show status code</button>
            <div class="status" style="display: none" id=${cat.id}>
                <h4>Status Code: ${cat.statusCode}</h4>
                <p>${cat.statusMessage}</p>
            </div>
        </div>
    </li>
`;

const catsList = html`
    <ul @click=${toggle}>
        ${catData.map(cat => catCardTemplate(cat))}
    </ul>`;

render(catsList, main);

function toggle(event) {
    const element = event.target.parentNode.querySelector('.status');
    if (element.style.display == 'none') {
        element.removeAttribute('style');
    } else {
        element.style.display = 'none'
    }
};