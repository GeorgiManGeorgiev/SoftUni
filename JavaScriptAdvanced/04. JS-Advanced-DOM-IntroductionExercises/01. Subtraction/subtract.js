function subtract() {
    let n = document.getElementById('firstNumber');
    let m = document.getElementById('secondNumber');
    let result = Number(n.value) - Number(m.value);
    let node = document.getElementById('result');
    node.textContent = String(result);
}