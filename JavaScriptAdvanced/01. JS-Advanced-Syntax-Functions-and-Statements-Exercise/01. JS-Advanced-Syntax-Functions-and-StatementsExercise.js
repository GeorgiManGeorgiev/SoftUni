// 01
// function solve(fruit,weight,price){

//     weight = (weight/1000);
//     let money = price*(weight);
//     console.log( `I need $${money.toFixed(2)} to buy ${weight.toFixed(2)} kilograms ${fruit}.`);

// }
// solve('apple', 1563, 2.35);

// 2
// function solve(a,b){
//     let c  = Math.min(a,b);
//     let result = 0;
//     for (let i = 1; i <=c; i++) {
//         if(a%i ===0 && b%i===0){
//             result = i;
//         }

//     };
//  console.log(result);
// }

// solve(15, 5);
// solve(2154, 458);

// 03
// function solve(input) {
//     let num = String(input);
//     let sum = 0;
//     let isSame = true;
//     let curr = Number(num[0]);
//     for (let i = 0; i < num.length; i++) {
//         if (curr !== Number(num[i])) {
//             isSame = false;
//         }
//         sum+=Number(num[i]);
//     }
//     console.log(isSame);
//     console.log(sum);
// };

// solve(1234);

// 04

//  function solve(speedInput, area) {
//     let speed = Number(speedInput);
//     let speedLimit;

//     switch (area) {
//         case "motorway":
//             speedLimit = 130;
//             break;
//         case "interstate":
//             speedLimit = 90;
//             break;
//         case "city":
//             speedLimit = 50;
//             break;
//         case "residential":
//             speedLimit = 20;
//             break;
//     }

//     let speeding = Number(speed) - speedLimit ;
//     if (speeding<=0){
//         console.log(`Driving ${speed} km/h in a ${speedLimit} zone`);
//     }
//     if (speeding <= 20 && speeding>0) {
//         console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${speedLimit} - speeding`);
//     } else if (speeding <= 40 && speeding>0) {
//         console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${speedLimit} - excessive speeding`);
//     }else if (speeding > 40 && speeding>0) {
//         console.log(`The speed is ${speeding} km/h faster than the allowed speed of ${speedLimit} - reckless driving`);
//     }

// }
// solve([21, "residential"]);

// 06

// function solve(input,...rest) {
//     let result =  rest;
//     let num =  Number(input);
//     for (let i = 0; i < rest.length; i++) {
//         let operation = rest[i];
//
//         switch (operation) {
//             case "chop":
//                 num /= 2;
//                 break;
//             case "dice":
//                 num = Math.sqrt(num);
//                 break;
//             case "spice":
//                 num += 1;
//                 break;
//             case "bake":
//                 num *= 3;
//                 break;
//             case "fillet":
//                 num *= 0.8;
//                 break;
//         }
//         console.log(num);
//     }
// }

// solve(['9', 'dice', 'spice', 'chop', 'bake', 'fillet']);
// solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');

// 07

// function solve(a,b,c,d){

// let x1 = Number(a);
// let y1 = Number(b);
// let x2 = Number(c);
// let y2 = Number(d);

// console.log(`{${x1}, ${y1}} to {0, 0} is ${checkValidity(isValid(x1,y1,0,0))}`);
// console.log(`{${x2}, ${y2}} to {0, 0} is ${checkValidity(isValid(x2,y2,0,0))}`);
// console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${checkValidity(isValid(x1,y1,x2,y2))}`);

// function isValid(x1,y1,x2,y2){
//     let value = Math.sqrt((x2-x1)**2+ (y2-y1)** 2 )
//     return Number.isInteger(value);
// }

// function checkValidity(validity){

//     return validity ? 'valid' : 'invalid'
// }

// }

// solve(3, 0, 0, 4);

// 08
// function solve(input) {

//     console.log(input.split(/[\W]+/).filter(w => w != '').map(w => w.toUpperCase()).join(', '));

// }
// solve('Hi, how are you?');
