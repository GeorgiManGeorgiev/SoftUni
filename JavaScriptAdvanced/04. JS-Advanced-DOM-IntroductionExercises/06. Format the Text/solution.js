function solve() {
    const textArea = document.querySelector('#input');
    const sentences = textArea.value.split('.').filter((x) => x != '');
    let newHtml = '';

    while (sentences.length > 0) {
        newHtml += `<p>${sentences.splice(0, 3).join('. ')}.</p>`;
    }

    document.querySelector('#output').innerHTML = newHtml;
}