import page from '../node_modules/page/page.mjs';
import {render} from '../node_modules/lit-html/lit-html.js';

import * as api from './api/data.js'
import {logout as apiLogout} from './api/data.js'
import {dashboardPage} from "./views/dashboard.js";
import {loginPage} from "./views/login.js";
import {registerPage} from "./views/register.js";
import {createPage} from "./views/create.js";
import {detailsPage} from "./views/details.js";
import {editPage} from "./views/edit.js";
import {myPetsPage} from "./views/myPets.js";

window.api = api;

const main = document.getElementById('site-content');
document.getElementById('logoutBtn').addEventListener('click', logout);

page('/', decorateContext, dashboardPage);
page('/login', decorateContext, loginPage);
page('/register', decorateContext, registerPage);
page('/create', decorateContext, createPage);
page('/details/:id', decorateContext, detailsPage);
page('/edit/:id', decorateContext, editPage);
page('/myPets', decorateContext, myPetsPage);

setUserNav();

page.start();

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, main);
    ctx.setUserNav = setUserNav;

    next();
};

function setUserNav() {
    //read email or user
    const email = sessionStorage.getItem('email');

    if (email != null) {
        document.getElementById('user').querySelector('span').textContent = `Welcome, ${email}`;
        document.getElementById('user').style.display = '';
        document.getElementById('guest').style.display = 'none';
    } else {
        document.getElementById('user').style.display = 'none';
        document.getElementById('guest').style.display = '';
    }
};

async function logout() {
    await apiLogout();
    setUserNav();
    page.redirect('/');

}



