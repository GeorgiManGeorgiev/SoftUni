let expect = require('chai').expect;
let pizzUni = require("../UnitTest/PizzaPlace").pizzUni;
let dealership = require("../UnitTest/dealership");

// describe("pizzUni", function () {
//
//     it("makeAnOrder …", function () {
//         let pizza = {orderedPizza: 'pizza', orderedDrink: 'drink'};
//         let pizza1 = {orderedDrink: 'drink'};
//         let pizza3 = {};
//         let pizza2 = {orderedPizza: 'pizza'};
//
//         expect(() => pizzUni.makeAnOrder(pizza1)).throw('You must order at least 1 Pizza to finish the order.')
//         expect(() => pizzUni.makeAnOrder(pizza3)).throw('You must order at least 1 Pizza to finish the order.')
//         expect(pizzUni.makeAnOrder(pizza2)).to.equal('You just ordered pizza')
//         expect(pizzUni.makeAnOrder(pizza)).to.equal('You just ordered pizza and drink.')
//
//     });
//     it("getRemainingWork …", function () {
//         let statusArr1 = [
//             {pizzaName: 'pizza1', status: 'ready'},
//             {pizzaName: 'pizza2', status: 'ready'}];
//         let statusArr2 = [
//             {pizzaName: 'pizza1', status: 'preparing'},
//             {pizzaName: 'pizza2', status: 'preparing'}];
//
//         let statusArr3 = [
//             {pizzaName: 'pizza1', status: 'ready'},
//             {pizzaName: 'pizza2', status: 'preparing'},
//             {pizzaName: 'pizza3', status: 'ready'},
//             {pizzaName: 'pizza4', status: 'preparing'}];
//
//         expect(pizzUni.getRemainingWork(statusArr1)).equal('All orders are complete!');
//         expect(pizzUni.getRemainingWork(statusArr2)).equal('The following pizzas are still preparing: pizza1, pizza2.');
//         expect(pizzUni.getRemainingWork(statusArr3)).equal('The following pizzas are still preparing: pizza2, pizza4.');
//
//
//     });
//
//     it("orderType …", function () {
//
//         expect(pizzUni.orderType(100,'Carry Out')).equal(90);
//         expect(pizzUni.orderType(100,'Delivery')).equal(100);
//
//
//     });
//
// });

describe('newCarCost', () => {
    it('should return correct newCarPrice ', () => {
        expect(dealership.newCarCost('Some model', 100)).to.equal(100);
        expect(dealership.newCarCost('Audi A4 B8', 15000)).to.equal(0);

    });

});
describe('carEquipment', () => {

    it('should return correct extras', () => {
        expect(dealership.carEquipment(['heated seats', 'sliding roof', 'sport rims', 'navigation'], [0, 1])).to.deep.equal(['heated seats', 'sliding roof']);

    });

});
describe('euroCategory', () => {

    it('should return correct message', () => {
        expect(dealership.euroCategory(1)).to.equal('Your euro category is low, so there is no discount from the final price!')
        expect(dealership.euroCategory(2)).to.equal('Your euro category is low, so there is no discount from the final price!')
        expect(dealership.euroCategory(4)).to.equal('We have added 5% discount to the final price: 14250.')
        expect(dealership.euroCategory(5)).to.equal('We have added 5% discount to the final price: 14250.')


    });

});