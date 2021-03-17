
// 01
// function solve(a,b,c){
// let aLength = a.length;
// let bLength = b.length;
// let cLength = c.length;
// let sumLength =Number( aLength+ bLength + cLength);
// let averageLength = Math.floor(sumLength / 3);
//     console.log(sumLength);
//     console.log(averageLength);
//     return(sumLength);
// }

// console.log(solve('chocolate', 'ice cream', 'cake'));

// //02
// function solve(a,b,operator){
//     let result;
//     switch(operator){
// case '+': result = a+b;break;
// case '-': result = a-b;break;
// case '/': result = a/b;break;
// case '*': result = a*b;break;
// case '%': result = a%b;break;
// case '**': result = a**b;break;
//     }
//     console.log(result);
// }


//03
// function solve(n,m){

//     let num1 = Number(n);
//     let num2  = Number(m);

//     let result = 0;
//     for(let i = num1; i<=num2;i++){
//         result+=i;
//     }
//     return result;
// }

// console.log(solve(1,15));

//04
// function getLargestNumber(a,b,c){
//     let result = Number( Math.max(a,b,c));
//   console.log (`The largest number is ${result}.`);
// }

// getLargestNumber(1,2,60);


//05
// function solve(argument){
//    let type =  typeof(argument);
//    if(type === 'number'){
//        let result = Math.pow(argument,2)*Math.PI;
//     console.log(result.toFixed(2));
//    }else{
//     console.log(`We can not calculate the circle area, because we receive a ${type}.`)
//    }

// }
// solve('5');

 //06
// function solve(size = 5) {

//     for (let i = size; i > 0; i--) {
//         let row = '';
//         for (let j = size; j > 0; j--) {
//             row += '* ';
//         }
//         console.log(row.trim());
//     }
// }

// solve(1)

