(function stringExtension() {
    String.prototype.ensureStart = function (str) {
        if(! this.toString().startsWith(str)){
            return str + this.toString();
        }
        return this.toString();
    };

    String.prototype.ensureEnd = function (str) {
        if(! this.toString().endsWith(str)){
            return this.toString() + str;
        }
        return this.toString();
    };

    String.prototype.isEmpty = function () {
        return this.toString().localeCompare("") == 0;
    };

    String.prototype.truncate = function (n) {
        if(n <= 3){
            return ".".repeat(n);
        }
        if(this.toString().length <= n){
            return this.toString();
        } else {
            let lastIndex = this.toString().substr(0, n - 2).lastIndexOf(" ");
            if(lastIndex != -1){
                return this.toString().substr(0, lastIndex) + "...";
            } else {
                return this.toString().substr(0, n-3) + "...";
            }
        }
    };

    String.format = function (string, ...params) {
        for(let i=0; i<params.length; i++){
            let index = string.indexOf("{"+i+"}");
            while (index != -1) {
                string = string.replace("{"+i+"}", params[i]);
                index = string.indexOf("{"+i+"}");
            }
        }
        return string;
    }
})();


let testString = 'quick brown fox jumps over the lazy dog';
console.log( testString.ensureStart('the '));//'the quick brown fox jumps over the lazy dog'


let str = 'my string';
console.log( str = str.ensureStart('my'));
console.log( str = str.ensureStart('hello '));
console.log( str = str.truncate(16));
console.log( str = str.truncate(14));
console.log( str = str.truncate(8));
console.log( str = str.truncate(4));
console.log( str = str.truncate(2));
console.log( str = String.format('The {0} {1} fox',
    'quick', 'brown'));
console.log( str = String.format('jumps {0} {1}',
    'dog'));
