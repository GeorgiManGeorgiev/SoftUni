const fs = require('fs/promises')
const path = require('path');
let productsDb = require('../config/products.json');

module.exports = {
    getAll(){
        return productsDb;
    },
    getOne(id){
        return productsDb.find(x => x.id = id);
    },

    create(product) {
        productsDb.push(product);

        fs.writeFile(path.join(__dirname, '/../config/products.json')
            , JSON.stringify(productsDb),
        );
    }
}