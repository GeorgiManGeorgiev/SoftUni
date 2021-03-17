let expect = require('chai').expect;
let isOddOrEven = require("../root/app").isOddOrEven;
let lookupChar = require("../root/app").lookupChar;
let mathEnforcer = require("../root/app").mathEnforcer;


// 02. Even Or Odd
describe('isOddOrEven() returns whether a word is with a even or odd length or undefined', function () {

    it("should return undefined for input - number (1)", function () {
        let expected = undefined;
        let inputValue = isOddOrEven(1);
        expect(inputValue).to.be.equal(expected);
    })

    it("should return odd for input - one ", function () {
        let expected = 'odd';
        let inputValue = isOddOrEven('one');
        expect(inputValue).to.be.equal(expected);

    })
    it("should return even for input - four", function () {
        let expected = 'even';
        let inputValue = isOddOrEven('four');
        expect(inputValue).to.be.equal(expected);

    })
})

//03  Char Lookup
describe('test cases for lookupChar(str, index) function', function () {
    it('should return undefined on lookupChar(2, 2)', () => {
        expect(lookupChar(2, 2)).to.equal(undefined);
    });

    it('should return undefined on lookupChar("test", "2")', () => {
        expect(lookupChar("test", "2")).to.equal(undefined);
    });

    it('should return undefined on lookupChar("test", 1.23)', () => {
        expect(lookupChar("test", 1.23)).to.equal(undefined);
    });

    it('should return Incorrect index on lookupChar("test", 25)', () => {
        expect(lookupChar("test", 25)).to.equal('Incorrect index');
    });

    it('should return Incorrect index on lookupChar("hello", -4)', () => {
        expect(lookupChar("hello", -4)).to.equal('Incorrect index');
    });

    it('should return Incorrect index on lookupChar("hello", 5)', () => {
        expect(lookupChar("hello", 5)).to.equal('Incorrect index');
    });

    it('should return "h" on lookupChar("hello", 0)', () => {
        expect(lookupChar("hello", 0)).to.equal('h');
    });

    it('should return "l" on lookupChar("hello", 3)', () => {
        expect(lookupChar("hello", 3)).to.equal('l');
    });
});

//04 Math Enforcer
describe('mathEnforcer', function () {
    it('addFive should return correct result with a non-number param', () => {
        expect(mathEnforcer.addFive('1')).to.equal(undefined);
        expect(mathEnforcer.addFive(NaN)).to.be.NaN;
    })
    it(' addFive should return correct result with a floating-point param', () => {
        expect(mathEnforcer.addFive(1.2)).to.be.closeTo(6,1);
    })
    it(' addFive should return correct result with a negative number param', () => {
        expect(mathEnforcer.addFive(-5)).to.equal(0);
        expect(mathEnforcer.addFive(-10)).to.equal(-5);
        expect(mathEnforcer.addFive(5)).to.equal(10);
        expect(mathEnforcer.addFive(-5.1)).to.equal(-0.09999999999999964);

    })

    it(' subtractTen should return correct result with a number param', () => {
        expect(mathEnforcer.subtractTen(10)).to.equal(0);
    })
    it(' subtractTen should return correct result with a non-number param', () => {
        expect(mathEnforcer.subtractTen("10")).to.equal(undefined);
        expect(mathEnforcer.subtractTen(NaN)).to.be.NaN;
    })
    it(' subtractTen should return correct result with a number param', () => {
        expect(mathEnforcer.subtractTen(10)).to.equal(0);
        expect(mathEnforcer.subtractTen(0)).to.equal(-10);
        expect(mathEnforcer.subtractTen(-10)).to.equal(-20);
        expect(mathEnforcer.subtractTen(10.1)).equal(0.09999999999999964);
    })
    it(' subtractTen should return correct result with a floating-point param', () => {

    })
    it(' sum should return correct result with a non-number param', () => {
        expect(mathEnforcer.sum("10","10")).to.equal(undefined);
        expect(mathEnforcer.sum('10',10)).to.be.equal(undefined);
        expect(mathEnforcer.sum(10,"10")).to.be.equal(undefined);
        expect(mathEnforcer.sum(NaN,NaN)).to.be.NaN;
    })

    it(' sum should return correct result with a number param', () => {
        expect(mathEnforcer.sum(10,10)).to.be.equal(20);
        expect(mathEnforcer.sum(0,0)).to.be.equal(0);
        expect(mathEnforcer.sum(-10,-10)).to.be.equal(-20);
        expect(mathEnforcer.sum(-10,-10)).to.be.equal(-20);
        expect(mathEnforcer.sum(1.3,-1.2)).to.be.equal(0.10000000000000009);

    })


});




