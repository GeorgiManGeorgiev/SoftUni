//1.	Calorie Object
//
// function solve(input) {
//     let result = {};
//     for (let i = 0; i < input.length; i ++ ) {
//         if (i % 2 === 0) {
//             result[input[i]] = Number(input[i + 1]);
//         }
//     }
//     return result;
// }
//
// console.log(solve(
//     ['Yoghurt', '48', 'Rise', '138', 'Apple', '52']
// ));

//2.	Construction Crew
//
// function solve(worker){
// if (worker.dizziness){
//     worker.levelOfHydrated+= 0.1 * worker.weight * worker.experience;
//     worker.dizziness =false;
// }
// return worker;
//
//
// }
//
// console.log( solve({ weight: 80,
//     experience: 1,
//     levelOfHydrated: 0,
//     dizziness: true }
// ));


//3.	Car Factory

// function solve(input) {
//
//     function getEngine(power) {
//         const engines = [
//             {power: 90, volume: 1800},
//             {power: 120, volume: 2400},
//             {power: 200, volume: 3500}
//         ].sort((a,b)=> a.power-b.power);
//
//         for (let i = 0; i < engines.length; i++) {
//                 if (engines[i].power>=power){
//                     return engines[i];
//
//                 }
//
//         }
//     }
//
//     function getCarriage(color, carriage) {
//         return {
//             type: carriage,
//             color: color
//         }
//
//     }
//
//     function getWheels(wheelSize) {
//         let wheel = Math.floor(wheelSize) % 2 === 0
//             ? Math.floor(wheelSize) - 1
//             : Math.floor(wheelSize);
//         return [wheel, wheel, wheel, wheel]
//     }
//
//     let result = {
//         model: input.model,
//         engine: getEngine(input.power),
//         carriage: getCarriage(input.color, input.carriage),
//         wheels: getWheels(input.wheelsize)
//     }
// return result;
// }
//
// console.log(solve({
//     model: 'VW Golf II',
//     power: 90,
//     color: 'blue',
//     carriage: 'hatchback',
//     wheelsize: 14
//     }
// ))
//4.  Heroic inventory
// function solve(input) {
//     let heroes = [];
//
//     input.forEach((line) => {
//         let [name, level, items] = line.split(" / ");
//         level = Number(level);
//         items = items ? items.split(", "): [];
//
//         let hero = {name: name, level: level, items:items};
//         heroes.push(hero);
//     });
//     console.log(JSON.stringify(heroes));
//
// }

//5.	Lowest Prices in Cities

// function solve(input){
//     let log = {};
//     while (input.length){
//         let sale = input.shift();
//         let[town, product,price] = sale.split(' | ');
//         if (!log[product]){
//             log[product] = {town,price: Number(price)}
//         }else {
//
//             log[product] = log[product].price<= Number(price ) ? log[product] :{town,price: Number(price)};
//         }
//
//     }
//     let result = [];
//     for (const product in log) {
//         result.push(`${product} -> ${log[product].price} (${log[product].town})`)
//     }
//
//
//   return result.join('\n');
//
// }
//
// solve   (['Sample Town | Sample Product | 1000',
//     'Sample Town | Orange | 2',
//     'Sample Town | Peach | 1',
//     'Sofia | Orange | 3',
//     'Sofia | Peach | 2',
//     'New York | Sample Product | 1000.1',
//     'New York | Burger | 10']
// )
// 6 Store catalogue
// function solve(input) {
//     let catalogue = {};
//
//     input.forEach((line) => {
//         let [name, price] = line.split(" : ");
//         price = Number(price);
//         let letter = name[0];
//
//         if (!catalogue[letter]) {
//             catalogue[letter] = [];
//         }
//         let product = { name, price };
//         catalogue[letter].push(product);
//     });
//
//     let sortedByLetter = Object.entries(catalogue).sort((curr, next) => {
//         return curr[0].localeCompare(next[0]);
//     });
//
//     for (let i = 0; i < sortedByLetter.length; i++) {
//         console.log(sortedByLetter[i][0]);
//
//         let sortByName = sortedByLetter[i][1].sort((curr, next) =>
//             curr.name.localeCompare(next.name)
//         );
//         sortByName.forEach((product) => {
//             console.log(`  ${product.name}: ${product.price}`);
//         });
//     }
// }
//  solve(['Appricot : 20.4',
//      'Fridge : 1500',
//      'TV : 1499',
//      'Deodorant : 10',
//      'Boiler : 300',
//      'Apple : 1.25',
//      'Anti-Bug Spray : 15',
//      'T-Shirt : 10']
//  )
//7.	Towns to JSON

// function solve(input) {
//
//     let [columns,...table] =
//         input
//         .map(splitLine);
//
//     function isEmptyString(x){
//         return x !=="";
//     }
// function convertIfNum(x){
//         return isNaN(x) ? x : Number( Number(x).toFixed(2) )
// }
//     function splitLine(input){
//     return input.split('|')
//         .filter(isEmptyString)
//         .map(x=>x.trim())
//         .map(convertIfNum);
//
//     }
//     return JSON.stringify(table.map(entry=>{
//         return columns.reduce((acc,curr,index)=>{
//             acc[curr] = entry[index];
//         return acc;
//         },{})
//     }))
//
// }
//
// console.log( solve([
//     '| Town | Latitude | Longitude |',
//     '| Sofia | 42.696552 | 23.32601 |',
//     '| Beijing | 39.913818 | 116.363625 |'
//     ]
// ))

//8.	Rectangle

// function rectangle(width,height,color){
//     function capitalize(word){
//
//         return word[0].toUpperCase()+word.slice(1);
//     }
//
//     function  calcArea(){
//         return this.height*this.height;
//     }
//     return{
//         width,
//         height,
//         color: capitalize(color),
//         calcArea(){
//             return this.width*this.height;
//         }
//     }
// }
//
// let rect = rectangle(4, 5, 'red');
// console.log(rect.width);
// console.log(rect.height);
// console.log(rect.color);
// console.log(rect.calcArea());
//
//10.	Heroes
//
// function solve(){
//
// const canCast = (state)=>({
//     cast: (spell) => {
//         console.log(`${state.name} cast ${spell}`);
//         state.mana--;
//     }
// })
//
//     const canFight = (state)=>({
//         fight: ()=>{
//             console.log(`${state.name} slashes at the foe!`)
//             state.stamina--;
//         }
//     })
//
//     const fighter = (name) =>{
//
//     let state = {
//         name,
//         health:100,
//         stamina:100
//     }
//     return Object.assign(state,canFight(state));
//     }
//
//     const mage = (name) =>{
//     let state = {
//         name,
//         health: 100,
//         mana: 100
//
//     }
//    return  Object.assign(state,canCast(state));
//     }
//
//     return {mage: mage, fighter: fighter};
// }
//
// let create = solve();
// const scorcher = create.mage("Scorcher");
// scorcher.cast("fireball")
// scorcher.cast("thunder")
// scorcher.cast("light")
//
// const scorcher2 = create.fighter("Scorcher 2");
// scorcher2.fight()
//
// console.log(scorcher2.stamina);
// console.log(scorcher.mana);

