const tableEvents = document.querySelector('tableEvents');

// function getUserEvents(params) {
    
// }
// const userEvents = [];

// userEvents.forEach((evento) => {
//     tableEvents.appendChild(createTableElement(evento));
// });

function createTableElement(evento){

    const tr = document.createElement('trEvent');
    const tdEventName = document.createElement('tdEventName');
    const tdEventTipo = document.createElement('tdEventTipo');
    const tdData = document.createElement('tdEventData');
    const tdRegreciva = document.createElement('tdEventRegreciva');

    tdEventName.innerHTML = evento.value;
    tdEventTipo.innerHTML = evento.value;
    tdData.innerHTML = evento.value;
    tdRegreciva.innerHTML = evento.value;

    tr.appendChild(tdEventName);
    tr.appendChild(tdEventTipo);
    tr.appendChild(tdData);
    tr.appendChild(tdRegreciva);

    return tr;
}

function getUserEvents(body) {
    const url =  `http://localhost:8080/users/${userId}/events`;
    let request = new XMLHttpRequest();
    request.open("GET", url, true);
    request.setRequestHeader('Content-Type', 'application/json');
    
    request.onload = function() {
        console.log(request.response);
        if(request.status != 200){
            alert('Erro ao buscar eventos');
        }
        else{   
            const events = JSON.parse(request.response);
            events.forEach((evento) => {
                tableEvents.appendChild(createTableElement(evento));
            });
        }
    };
    request.send(body);
    return;
}