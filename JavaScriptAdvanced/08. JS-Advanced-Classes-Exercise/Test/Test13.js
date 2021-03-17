let expect = require('chai').expect;
let assert = require('chai').assert;
let PaymentPackage = require("../13PaymentPackage").PaymentPackage;


describe("PaymentPackage", function() {
    it("Test constructor two params: string and num", function() {
      let  instance = new PaymentPackage('name', 100);
        expect(instance._name).equal('name')
        expect(instance._value).equal(100)
        expect(instance._VAT).equal(20)
        expect(instance._active).equal(true)
    });
    it("Test name of PaymentPackage", function() {
        let  instance = new PaymentPackage('name', 100);
        expect(instance.name).equal('name')
        instance.name = 'Pesho'
        expect(instance.name).equal('Pesho')
        expect( ()=>{instance.name = ''}).to.throw('Name must be a non-empty string')
        expect( ()=>{instance.name = 2}).to.throw('Name must be a non-empty string')
        expect( ()=>{instance.name = undefined}).to.throw('Name must be a non-empty string')




    });
    it("Test VAT of PaymentPackage", function() {
        let  instance = new PaymentPackage('name', 100);
        expect(instance.VAT).equal(20)
        instance.VAT = 40;
        expect(instance.VAT).equal(40)
        expect( ()=>{instance.VAT = -2}).to.throw('VAT must be a non-negative number')
        expect( ()=>{instance.VAT = ''}).to.throw('VAT must be a non-negative number')
        expect( ()=>{instance.VAT = undefined}).to.throw('VAT must be a non-negative number')

    });
    it("Test value of PaymentPackage", function() {
        let  instance = new PaymentPackage('name', 100);
        expect(instance.value).equal(100)
        instance.value = 40;
        expect(instance.value).equal(40)
        expect( ()=>{instance.value = -2}).to.throw('Value must be a non-negative number')
        expect( ()=>{instance.value = '2'}).to.throw('Value must be a non-negative number')
        expect( ()=>{instance.value = 0}).not.to.throw('Value must be a non-negative number')


    });
    it("Test active of PaymentPackage", function() {
        let  instance = new PaymentPackage('name', 100);
        expect(instance.active).equal(true)
        instance.active = false;
        expect(instance.active).equal(false)
        expect( ()=>{instance.active = 0}).to.throw('Active status must be a boolean')
        expect( ()=>{instance.active = ''}).to.throw('Active status must be a boolean')
        expect( ()=>{instance.active = '00'}).to.throw('Active status must be a boolean')
        expect( ()=>{instance.active = undefined}).to.throw('Active status must be a boolean')

    });
    it("Test toString of PaymentPackage", function() {
        function getString(name,value,VAT=20,active=true){
            return[
                `Package: ${name}` + (active === false ? ' (inactive)' : ''),
                `- Value (excl. VAT): ${value}`,
                `- Value (VAT ${VAT}%): ${value * (1 + VAT / 100)}`
            ].join('\n');
        }
        let  instance = new PaymentPackage('name', 100);

        expect(instance.toString()).equal(getString('name',100))
        instance.active = false
        expect(instance.toString()).equal(getString('name',100,20,false))
        instance.VAT = 200
        expect(instance.toString()).equal(getString('name',100,200,false))
        instance.name = 'MISHO'
        expect(instance.toString()).equal(getString('MISHO',100,200,false))
        instance.value = 2
        expect(instance.toString()).equal(getString('MISHO',2,200,false))
    });

});
