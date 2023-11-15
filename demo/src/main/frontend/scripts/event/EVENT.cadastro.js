const btSubmit = document.getElementById('btSubmit');
const eventName = document.getElementById('eventName');

eventName.addEventListener('input', function() {
    console.log(eventName.value);
});


function fazPost(url, body) {
    let request = new XMLHttpRequest();
    request.open("POST", url, true);
    request.setRequestHeader('Content-Type', 'application/json');
    const status = document.getElementById('StatusBar');
    
    request.onload = function() {

        console.log(request.response);

        if(request.status != 201){
            status.innerHTML = 'Erro ao cadastrar usuário';
            status.style.backgroundColor = 'red';
        }
        else{   
            status.innerHTML = 'Usuário cadastrado com sucesso!'; 
            status.style.backgroundColor = 'green';
        }
        status.style.display = 'block';
    };
    request.send(body);
    return;
}

async function popularGeneros() {
    const nSeAplica = [{value: "", label: ""}];
    const selectGenero = document.getElementById('selectGenero');

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
            option.value = genero.value;
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
