//01
// function solve(input){
//     let sum =  Number(input[input.length-1]) + Number(input[0]);
// console.log(sum);

// }
// solve(['20', '30', '40'])

//02
// function solve(input) {
//     let result = '';
//     for (let i = 0; i < input.length; i++) {
//         if (i % 2 == 0) {
//             result += input[i] + ' ';
//         }
//     }
//     console.log(result.trim())

// }

// solve(['20', '30', '40'])

//03
// function solve(input){
//     let arr = [];
//     for (let i = 0; i < input.length; i++) {
//         if(input[i]< 0){
//             arr.unshift(input[i])
//         }else{
//         arr.push(input[i]);
//         }
//     }
//     for (let i = 0; i < arr.length; i++) {
//         console.log(arr[i]);
//     }
    
// }

// solve([7, -2, 8, 9])


 //05
// function solve(input){
    
//     let result = [];
//     for (let i = 0; i < input.length; i++) {
//         if(input[i]%2 != 0){
//             let curr = input[i];
//             curr*=2;
//         result.unshift(curr);
//         }
//     }

//     console.log(result.join(' '))
// }

// solve([10, 15, 20, 25])

//06
// function solve(input){
//     let first =  Math.min(...input);
//     console.log(first);
//     let index = input.indexOf(first);
//     input.splice(index,1);
//     console.log(Math.min(...input))
    

// }

// solve([30, 15, 50, 5]);
