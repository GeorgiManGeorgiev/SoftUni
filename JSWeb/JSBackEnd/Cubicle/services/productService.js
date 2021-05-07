const Cube = require('../models/Cube');



function getAll(query) {
    let products = Cube.getAll();

    if (query.search) {
        products = products.filter(x => x.name.toLowerCase().includes(query.search));
    }
    if (query.from) {
        products = products.filter(x => Number(x.difficultyLevel) >= query.from);
    }
    if (query.to) {
        products = products.filter(x => Number(x.difficultyLevel) <= query.to);
    }
    return products;
}

function getOne(id) {
    return Cube.getOne(id);
}

function create(data) {
    let cube = new Cube(data);

    return cube.save();
}

module.exports = {
    create,
    getAll,
    getOne
};