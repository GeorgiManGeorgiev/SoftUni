
let productsDb = require('../config/products.json');


class Model{
    save() {
        productsDb.push(this);

        return fs.writeFile(
            path.join(__dirname, '../config/products.json'),
            JSON.stringify(productsDb),
        );
    }

    static getAll() {
        return productsDb;
    }

    static getOne(id) {
        let result =  productsDb.find(x => x.id = id);
        console.log(result);
        return result;
    }
}

module.exports = Model;