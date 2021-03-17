//01

// function solve(input, delimiter) {



//     console.log(input.join(delimiter));

// }

// solve(['One', 
// 'Two', 
// 'Three', 
// 'Four', 
// 'Five'], 
// '-'
// );

//02

// function solve(input,n){

//     let arr = [];

// for (let i = 0; i < input.length; i+=n) {

//     arr.push(input[i]);
// }
// return arr;
//console.log(arr.join('\n'));
// }

// solve(['5', 
// '20', 
// '31', 
// '4', 
// '20'], 
// 2

// );

//03

// function solve(input){

//     let initialNumber = 1;
//     let arr = [];
//     for (const element of input){

//         if(element == 'add'){
//             arr.push(initialNumber);
//         }else{

//             arr.pop();
//         }
//         initialNumber++;
//     };

//     if(arr.length == 0){
//         console.log('Empty');
//     }else{
//         for (let i = 0; i < arr.length; i++) {
//             console.log(arr[i]);

//         }
//     }

// }

// solve(['add',
// 'add',
// 'add',
// 'add']
// )

//04

// function solve(input,n){

//     let rotaitons = Number(n);
//     rotaitons = rotaitons % input.length;
//     for (let i = 0; i < rotaitons ; i++) {
//         let el = input.pop();
//         input.unshift(el);
//     }
//     console.log(input.join(' '));

// }

// solve(['Banana', 
// 'Orange', 
// 'Coconut', 
// 'Apple'], 
// 15);

//05
// function solve(input) {
//   let output = [];

//   let max = Number.MIN_SAFE_INTEGER;

//   input.forEach((num) => {
//     if (max <= Number(num)) {
//       max = Number(num);
//       output.push(num);
//     }
//   });
//   return output;
  
// }

//solution with filter
// function solve(input) {
//     let output = [];

//     let max = Number.MIN_SAFE_INTEGER;

//     input.filter((num) => {
//       if (max <= num) {
//         max = num;
//         output.push(num);
//        return true;
//       }else{
//           return false;
//       }
//     });

//     console.log(output.join("\n"));
//   }

// solve([1, 3, 8, 4, 10, 12, 3, 2, 24]);
// solve([1, 2, 3, 4]);
// solve([20, 3, 2, 15, 6, 1]);

//06 List of names

// function solve(input) {
//   output = input.sort();
//   let i = 1;
//   output.forEach(element => {
//     console.log(i++ +'.'+element);
//   });
 
// }

//  solve(["John", "Bob", "Christina", "Ema"]
//  );

//07	Sorting Numbers
//     function solve(values){
    
      

//     let first = Math.min(...input);
//     console.log(Math.max(...input)); 

//     };
// solve([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);


//08	Sort an Array by 2 Criteria

// function solve(input) {
//     output = input.sort((curr, next) => {
//       if (curr.length > next.length) {
//         return 1;
//       }
//       if (curr.length < next.length) {
//         return -1;
//       } else {
//         return curr.localeCompare(next);
//       }
//     });
    
//     output.forEach(element => {
//       console.log( element);
//     });
   
//   }
  
//    solve(['alpha', 
//    'beta', 
//    'gamma']
//    );

// 09 Magic matrices
function solve(input) {
    let containerSumOfRows = [];
    let sumOfRow = 0;
    let currRow = 0;
  
    for (let r = 0; r < input.length; r++) {
      currRow = r;
      for (let c = 0; c < input[r].length; c++) {
        if (currRow === r) {
          sumOfRow += input[r][c];
        }
      }
      containerSumOfRows.push(sumOfRow);
      sumOfRow = 0;
    }
    let containerSumOfColls = [];
    let currColl = 0;
    let sumOfColl = 0;
    let r = 0;
    for (let c = 0; c < input[r].length; c++) {
      currColl = c;
      while (r < input.length) {
        if (currColl === c) {
          sumOfColl += input[r][c];
        }
        r++;
      }
      containerSumOfColls.push(sumOfColl);
      sumOfColl = 0;
      r = 0;
    }
    if( Math.max(...containerSumOfRows) === Math.max(...containerSumOfColls)){
        console.log(true);
    }else{
      console.log(false);
    }
  }
  
  solve([
    [1, 0, 0],
    [0, 0, 1],
    [0, 1, 0],
  ]);
  solve([[11, 32, 45],
      [21, 0, 1],
      [21, 1, 1]]
     );
     solve([[4, 5, 6],
      [6, 5, 4],
      [5, 5, 5]]
     );