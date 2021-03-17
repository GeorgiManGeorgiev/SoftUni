function solve() {
    let input = document.getElementById('text').value.toLowerCase();
    let currentCase = document.getElementById('naming-convention').value;
    document.getElementById('text').value ='';
    document.getElementById('naming-convention').value = '';
    let result = '';
    let textToTransform = input.split(' ');
    switch (currentCase) {

        case 'Camel Case':
            result += textToTransform[0];
            for (let i = 1; i < textToTransform.length; i++) {
                result += textToTransform[i][0].toUpperCase() + textToTransform[i].slice(1);
            }

            break;

        case 'Pascal Case':
            for (let i = 0; i < textToTransform.length; i++) {
                result += textToTransform[i][0].toUpperCase() + textToTransform[i].slice(1);
            }


            break;
        default:
            result = 'Error!'
            break;
    }
    document.getElementById('result').innerText = result;
}