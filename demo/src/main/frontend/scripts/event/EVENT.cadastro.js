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

