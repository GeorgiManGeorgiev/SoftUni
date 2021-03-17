class Stringer {

    constructor(string, length) {
        this.innerString = string;
        this.innerLength = Number(length);
    }

    increase(length) {
        this.innerLength += length;
    }

    decrease(length) {
        this.innerLength -= Number(length);
        if (this.innerLength < 0) {
            this.innerLength = 0;
        }

    }

    toString() {
        if  (this.innerString.length - this.innerLength === 0){
            return this.innerString.slice(0);
        }
        return this.innerLength === 0
            ? '...'
            : this.innerString.slice(0, this.innerLength) + '...';
    }
}

let test = new Stringer("Test", 5);
console.log(test.toString()); // Test

test.decrease(3);
console.log(test.toString()); // Te...

test.decrease(5);
console.log(test.toString()); // ...

test.increase(4);
console.log(test.toString()); // Test

