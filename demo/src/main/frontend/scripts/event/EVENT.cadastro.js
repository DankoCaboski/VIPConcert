const submit = document.getElementById('submit');
const eventName = document.getElementById('eventName');
const eventDescription = document.getElementById('eventDescription');
const selectGenero = document.getElementById('selectGenero');
const inputInicioEvent = document.getElementById('inputInicioEvent');
const inputFimEvent = document.getElementById('inputFimEvent');

eventName.addEventListener('input', function() {
    console.log(eventName.value);
});

submit.addEventListener('click', function() {
    const dateInicio = new Date(inputInicioEvent.value);
    const formattedDateInicio = formatDate(dateInicio);

    const dateFim = new Date(inputInicioEvent.value);
    const formattedDateFim = formatDate(dateFim);
    
    const body = JSON.stringify({
        name: eventName.value,
        description: eventDescription.value,
        genero: selectGenero.value,
        dateInicio: formattedDateInicio,
        dateFim: formattedDateFim
    });
    console.log(body);
    fazPost('http://localhost:8080/event', body);
});

function formatDate(date) {
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const day = date.getDate() + 1;
    const hours = String(date.getHours()).padStart(2, '0');
    const minutes = String(date.getMinutes()).padStart(2, '0');
    const formattedDate = `${year}-${month}-${day}T${hours}:${minutes}`;
    return formattedDate;
}

function fazPost(url, body) {
    return new Promise((resolve, reject) => {
        let request = new XMLHttpRequest();
        request.open("POST", url, true);
        request.setRequestHeader('Content-Type', 'application/json');
        
        request.onload = function() {
            if (request.status === 201) {
                resolve(request.response);
            } else {
                if (request.status === 400) {
                    alert(request.response);
                } else {
                reject(new Error('Error: ' + request.status));
                }
            }
        };

        request.onerror = function() {
            reject(new Error('Network error'));
        };

        request.send(body);
    });
}

async function popularGeneros() {
    const nSeAplica = [{value: "", label: ""}];

    nSeAplica.forEach(genero => {
        const option = document.createElement('option');
        option.value = genero.value;
        option.textContent = genero.label;
        selectGenero.appendChild(option);
    });

    try {
        const response = await fetch('http://localhost:8080/event/generos');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        data.forEach(genero => {
            const option = document.createElement('option');
            option.value = genero.genero;
            option.textContent = genero.label;
            selectGenero.appendChild(option);
        });
    } catch (error) {
        console.error('Error:', error);
        console.log("data:");
        console.log(data);
    }
}

popularGeneros();




