class List {
    constructor() {
        this.list = [];
        this.size = this.list.length;
    }

    add(element) {
        this.list.push(element);
        this.list = this.list.sort((a, b) => a - b);
        this.size = this.list.length;
    }

    remove(index) {
        if (index > this.list.length || index < 0) {
            throw new TypeError('Index must be valid');
        } else {
            this.list.splice(index,1);
            this.size = this.list.length;
        }
    }

    size() {
        return this.list.length;
    }
    get(index) {
        if (index > this.list.length || index < 0) {
            throw new TypeError('Index must be valid');
        } else {
            return this.list[index];
        }
    }

}



let list = new List();
list.add(5);
list.add(6);
list.add(7);
list.remove(1)
console.log(list.get(1));


let arr = []
arr.push(1)
arr.push(2)
arr.push(3)
arr.push(4)
arr.splice(0,1)
console.log(arr)