function attachEvents() {

    document.getElementById('submit').addEventListener('click', getWeather)


}

attachEvents();


async function getWeather() {
    const forecastDiv = document.getElementById('forecast');
    const currDiv = document.getElementById('current')
    const upcomingDiv = document.getElementById('upcoming')


    const input = document.getElementById('location');
    const cityName = input.value;
    const code = await getCode(cityName);
    const [current, upcoming] = await Promise.all([getCurrent(code), getUpcoming(code)]);
    input.value = '';

    const fDiv = document.createElement('div');
    fDiv.className = 'forecasts';
    const span = document.createElement('span');
    span.className = 'condition symbol';
    span.innerHTML = getSymbol(current.forecast.condition);
    fDiv.appendChild(span);

    forecastDiv.style.display = 'block';

    const condition = document.createElement("span");
    condition.className = 'condition';

    const locationSpan = document.createElement("span");
    locationSpan.className = 'forecast-data';
    locationSpan.textContent = current.name;
    condition.appendChild(locationSpan)

    const tempSpan = document.createElement("span");
    tempSpan.className = 'forecast-data';
    tempSpan.innerHTML = `${current.forecast.low}${getSymbol('Degrees')}/${current.forecast.high}${getSymbol('Degrees')}`
    condition.appendChild(tempSpan);

    const conSpan = document.createElement('span');
    conSpan.className = 'forecast-data';
    conSpan.innerText = current.forecast.condition;
    condition.appendChild(conSpan);

    fDiv.appendChild(condition);
    currDiv.appendChild(fDiv);

    //three day forecast
    const divForecastInfo = document.createElement("div");
    divForecastInfo.className = 'forecast-info';


    for (let i = 0; i < 3; i++) {
        const upcomingSpan = document.createElement("span");
        upcomingSpan.className = 'upcoming';

        const symbolSpan = document.createElement("span");
        symbolSpan.className = 'symbol';
        symbolSpan.innerHTML = getSymbol(upcoming.forecast[i].condition);

        const tempSpan = document.createElement("span");
        tempSpan.className = 'forecast-data';
        tempSpan.innerHTML = `${upcoming.forecast[i].low}${getSymbol('Degrees')}/${upcoming.forecast[i].high}${getSymbol('Degrees')}`

        const condSpan = document.createElement("span");
        condSpan.className = 'forecast-data';
        condSpan.textContent = upcoming.forecast[i].condition;

        upcomingSpan.appendChild(symbolSpan);
        upcomingSpan.appendChild(tempSpan);
        upcomingSpan.appendChild(condSpan);

        divForecastInfo.appendChild(upcomingSpan);
    }

    upcomingDiv.appendChild(divForecastInfo);
}


async function getCode(cityName) {

    const url = 'http://localhost:3030/jsonstore/forecaster/locations'
    const response = await fetch(url);
    const data = await response.json();
    let result;
    try {
        result = data.find(x => x.name.toLowerCase() == cityName.toLowerCase()).code;
    }
    catch (e){
        handleError();
    }
    return result;
}


async function getCurrent(code) {
    const url = 'http://localhost:3030/jsonstore/forecaster/today/' + code;

    const response = await fetch(url);
    const data = await response.json();

    return data;

}


async function getUpcoming(code) {
    const url = 'http://localhost:3030/jsonstore/forecaster/upcoming/' + code;

    const response = await fetch(url);
    const data = await response.json();

    return data;


}


function getSymbol(condition) {
    switch (condition) {
        case'Sunny':
            return '&#x2600';
        case'Partly sunny':
            return '&#x26C5';
        case'Overcast':
            return '&#x2601';
        case'Rain':
            return '&#x2614';
        case 'Degrees':
            return '&#176';
    }
}

function handleError() {
    const target = document.getElementById('forecast');
    target.style.display = 'block';
    document.getElementById('current').style.display = 'none';
    document.getElementById('upcoming').style.display = 'none';
    const errSpan = document.createElement("span");
    errSpan.textContent = 'Error';
    target.appendChild(errSpan);
}