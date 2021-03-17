let expect = require('chai').expect;
let numberOperations = require("../UnitTest/Number").numberOperations;


describe("Tests …", function() {
    describe("numberOperations", function() {
        it("powNumber", function() {
            expect ( numberOperations.powNumber(1)).to.equal(1);
            expect ( numberOperations.powNumber(0)).to.equal(0);
            expect ( numberOperations.powNumber(-2)).to.equal(4);

        });
        it("numberChecker", function() {
            expect ( numberOperations.numberChecker("1")).to.equal('The number is lower than 100!');
            expect(() =>numberOperations.numberChecker(NaN)).throw('The input is not a number!')
            expect(() =>numberOperations.numberChecker('someInput')).throw('The input is not a number!')
            expect ( numberOperations.numberChecker(99)).to.equal('The number is lower than 100!');
            expect ( numberOperations.numberChecker(-2)).to.equal('The number is lower than 100!');
            expect ( numberOperations.numberChecker(100)).to.equal('The number is greater or equal to 100!');
            expect ( numberOperations.numberChecker(101)).to.equal('The number is greater or equal to 100!');
        });
        it("sumArrays", function() {
            expect(numberOperations.sumArrays([1,2,3,4,5,6],[1,2,3,4,5,6])).to.deep.equal([ 2, 4, 6, 8, 10, 12 ])
            expect(numberOperations.sumArrays([],[1,2,3,4,5,6])).to.deep.equal([ 1, 2, 3, 4, 5, 6 ])
            expect(numberOperations.sumArrays([],[1,2,3])).to.deep.equal([ 1, 2, 3 ])
        });
    });

});
