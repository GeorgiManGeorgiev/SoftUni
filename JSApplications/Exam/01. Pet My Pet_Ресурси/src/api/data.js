import * as api from './api.js';

const host = 'http://localhost:3030';

api.settings.host = host;

export const login = api.login;
export const register = api.register;
export const logout = api.logout;


//app-specific requests

export async function getPets() {
    return await api.get(host + '/data/pets?sortBy=_createdOn%20desc');
}

export async function getPetById(id) {
    return await api.get(host + '/data/pets/' + id);
}

export async function createPet(pet) {
    return await api.post(host + '/data/pets', pet);
}

export async function updatePet(id, pet) {
    return await api.put(host + '/data/pets/' + id, pet);
}

export async function deletePet(id) {
    return await api.del(host + '/data/pets/' + id);
}

export async function getMyPets() {
    const userId = sessionStorage.getItem('userId');
    return await api.get(host + `/data/pets?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);

}


