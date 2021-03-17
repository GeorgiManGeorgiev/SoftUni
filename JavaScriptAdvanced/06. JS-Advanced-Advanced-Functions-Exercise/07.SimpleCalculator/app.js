function calculator() {
    let el1;
    let el2;
    let resultElement;

    return {
        init: (selector1, selector2, resultSelector) => {
            el1 = document.querySelector(selector1);
            el2 = document.querySelector(selector2);
            resultElement = document.querySelector(resultSelector);
        },
        add: () => {
            resultElement.value = Number(el1.value) + Number(el2.value)
        },

        subtract: () => {
            resultElement.value = Number(el1.value) - Number(el2.value)
        }
    }
}
let calculate= calculator();
calculate.init('#num1', '#num2', '#result');



