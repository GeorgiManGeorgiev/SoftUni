// 01 Heroic Inventory

// function solve(input) {
//   let heroes = [];

//   input.forEach((line) => {
//     let [name, level, items] = line.split(" / ");
//     level = Number(level);
//     items = items ? items.split(", "): [];

//     let hero = {name: name, level: level, items:items};
//     heroes.push(hero);
//   });
//   console.log(JSON.stringify(heroes));

// }

// solve([
//   "Isacc / 25 / Apple, GravityGun",
//   "Derek / 12 / BarrelVest, DestructionSword",
//   "Hes / 1 / Desolator, Sentinel, Antara",
// ]);

//02 JSON’s Table

// function solve(input) {
//   let output = '<table>\n';
//   let employes = [];

//   input.forEach((e) => {
//     employes.push(JSON.parse(e));
//   });

//   output += arrayAsTable(employes) + '</table>';

//   console.log(output);

//   function arrayAsTable(employes) {
//     let result = '';
//     employes.forEach((employee) => {
//       result += "\t<tr>\n";
//       Object.values(employee).forEach((v) => {
//         result += `\t\t<td>${v}</td>\n`;
//       });
//       result += '\t</tr>\n';
//     });
//     return result;
//   }
// }
// solve([
//   '{"name":"Pesho","position":"Promenliva","salary":100000}',
//   '{"name":"Teo","position":"Lecturer","salary":1000}',
//   '{"name":"Georgi","position":"Lecturer","salary":1000}',
// ]);

//03

// function solve(input) {
//   let result = {};

//   let juicesInOrder = {};

//   input.forEach((line) => {
//     let [product, quantity] = line.split(" => ");

//     if (!result[product]) {
//       result[product] = Number(quantity);
//     } else {
//       result[product] += Number(quantity);
//     }
//     if (result[product] >= 1000) {
//       juicesInOrder[product] = 0;
//     }
//   });
//   Object.keys(result).forEach((j) => {
//     if (juicesInOrder[j] !== undefined) {
//       juicesInOrder[j] += parseInt(result[j] / 1000);
//     }
//   });

//   Object.keys(juicesInOrder).forEach((j) =>
//     console.log(`${j} => ${juicesInOrder[j]}`)
//   );

// }
// solve([
//   "Orange => 2000",
//   "Peach => 1432",
//   "Banana => 450",
//   "Peach => 600",
//   "Strawberry => 549",
// ]);

//04	Store Catalogue

// function solve(input) {
//   let result = {};

//   input.forEach((line) => {
//     let [name, price] = line.split(" : ");
//     price = Number(price);
//     let letter = name[0];

//     if (!result[letter]) {
//       result[letter] = [];
//     }
//     let product = { name, price };
//     result[letter].push(product);
//   });

//   let sortedByLetter = Object.entries(result).sort((curr, next) => {
//     return curr[0].localeCompare(next[0]);
//   });

//   for (let i = 0; i < sortedByLetter.length; i++) {
//     console.log(sortedByLetter[i][0]);

//     let sortByName = sortedByLetter[i][1].sort((curr, next) =>
//       curr.name.localeCompare(next.name)
//     );
//     sortByName.forEach((product) => {
//       console.log(`  ${product.name}: ${product.price}`);
//     });
//   }
// }

// solve([
//   "Appricot : 20.4",
//   "Fridge : 1500",
//   "TV : 1499",
//   "Deodorant : 10",
//   "Boiler : 300",
//   "Apple : 1.25",
//   "Anti-Bug Spray : 15",
//   "T-Shirt : 10",
// ]);

//04 alternative solution

// function solve(input) {
//   const catalogue = {};

//   for (let line of input) {
//     const [product, price] = line.split(" : ");
//     const letter = product[0];

//     if (catalogue.hasOwnProperty(letter) === false) {
//       catalogue[letter] = {};
//     }
//     catalogue[letter][product] = Number(price);
//   }

//   let sorttedKeys = Object.keys(catalogue).sort((a, b) => {
//     return a.localeCompare(b);
//   });
//   for (let key of sorttedKeys) {
//     console.log(key);
//     const sortedProducts = Object.keys(catalogue[key]).sort((a,b)=>a.localeCompare(b));
//       for (let product of sortedProducts) {
//           console.log(`  ${product}: ${catalogue[key][product]}`);
//       }

//   }
// }

// solve([
//   "Appricot : 20.4",
//   "Fridge : 1500",
//   "TV : 1499",
//   "Deodorant : 10",
//   "Boiler : 300",
//   "Apple : 1.25",
//   "Anti-Bug Spray : 15",
//   "T-Shirt : 10",
// ]);

//05	Auto-Engineering Company

// function solve(input) {
// let cars = {};

//   for (let line of input) {
//       let [carBrand, carModel, producedCars] = line.split(" | ");
//       producedCars = Number(producedCars);

//       if (!cars[carBrand]) {
//           cars[carBrand] = [];
//           cars[carBrand].push({ carModel, producedCars });
//       } else if (cars[carBrand].some(car => car.carModel === carModel)) {
//           let targetCar = cars[carBrand].find(car => car.carModel === carModel);
//           targetCar.producedCars += producedCars;
//       } else {
//           cars[carBrand].push({ carModel, producedCars });
//       }
//   }

//   for (const [brand, car] of Object.entries(cars)) {
//       console.log(brand);
//       for (const currentCar of Object.values(car)) {
//           console.log(`###${currentCar.carModel} -> ${currentCar.producedCars}`);
//       }
//   }
// }

// solve([
//   "Audi | Q7 | 1000",
//   "Audi | Q6 | 100",
//   "BMW | X5 | 1000",
//   "BMW | X6 | 100",
//   "Citroen | C4 | 123",
//   "Volga | GAZ-24 | 1000000",
//   "Lada | Niva | 1000000",
//   "Lada | Jigula | 1000000",
//   "Citroen | C4 | 22",
//   "Citroen | C5 | 10",
// ]);

//06 	System Components

// function solve(input) {
//   let catalogue = {};
//   for (let line of input) {
//     const [system, component, sub] = line.split(" | ");

//     if (catalogue.hasOwnProperty(system) === false) {
//       catalogue[system] = {};
//     }
//     if (catalogue[system].hasOwnProperty(component) === false) {
//       catalogue[system][component] = [];
//     }

//     catalogue[system][component].push(sub);
//   }

//    Object.entries(catalogue).sort((a, b) => {
//   return  Object.keys(b[1]).length - Object.keys(a[1]).length ||
//    a[0].localeCompare(b[0]);
//   }).forEach(([system, component])=>{
//     console.log(system);
//     Object.entries(component).sort((a,b)=>{
//         return  b[1].length - a[1].length;
//     }).forEach(([name,sub])=>{
//         console.log(`|||${name}`);
//         sub.forEach(c=>{
//             console.log(`||||||${c}`)
//         });
//     });

//   });
// }

// solve([
//   "SULS | Main Site | Home Page",
//   "SULS | Main Site | Login Page",
//   "SULS | Main Site | Register Page",
//   "SULS | Judge Site | Login Page",
//   "SULS | Judge Site | Submittion Page",
//   "Lambda | CoreA | A23",
//   "SULS | Digital Site | Login Page",
//   "Lambda | CoreB | B24",
//   "Lambda | CoreA | A24",
//   "Lambda | CoreA | A25",
//   "Lambda | CoreC | C4",
//   "Indice | Session | Default Storage",
//   "Indice | Session | Default Security",
// ]);

// 07	Data Class
//  class  customRequest{
//     constructor(method,uri,version,message){
//         this.message =message;
//         this.uri =uri;
//         this.version = version;
//         this.message = message;
//         this.response = undefined;
//         this.fulfilled = false;
//     }
//  }
//
//08 Tickets
// function solve(tickets, criteria) {
//   class Ticket {
//     constructor(descriptor) {
//       const [destination, price, status] = descriptor.split("|");
//       this.destination = destination;
//       this.price = Number( price);
//       this.status = status;
//     }
//   }

//   const comprator = {
//     destination: (a, b) => {
//      a.destination.localeCompare(b.destination);
//     },
//     price: () => (a, b) => {
//       a-b;
//     },
//     status: (a, b) => {
//       a.status.localeCompare(b.status);
//     },
//   };

//  return tickets.map((t) => new Ticket(t)).sort(comprator[criteria]);
// }

// console.log( solve(
//   [
//     "Philadelphia|94.20|available",
//     "New York City|95.99|available",
//     "New York City|95.99|sold",
//     "Boston|126.20|departed",
//   ],
//   "destination"
// ));
// 
// 
//09 Sorted List
// class List {

//     constructor() {
//         this._list = [];
// this.size = 0;
//     }

//     add(element) {
//         this._list.push(element);
//         this._list.sort(((a, b) => a-b));
//         this.size++;
//     };
//     get(index){
//         this._validate(index);
//     return this._list[index];
//     }

//     remove(index) {
//         this._validate(index);
//         this._list.splice(index,1);
//         this.size--;
//     };

//     _validate(index){
//         if(index < 0 || index >= this._list.length){
//             throw new Error('Index is out of bounds')
//         }
//     }

    
// }

// let list = new List();
// list.add(5);
// list.add(6);
// list.add(7);
// console.log(list.get(1));
// list.remove(1);
// console.log(list.get(1));

// 10 Length Limit
