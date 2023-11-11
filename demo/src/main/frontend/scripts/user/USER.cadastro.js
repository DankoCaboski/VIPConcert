
const form = document.querySelector('#user-form');
const name = document.querySelector('#name');
const email = document.querySelector('#email');
const cpf = document.querySelector('#cpf');
const role = document.querySelector('#role');
const id = document.querySelector('#id'); 

const url = "http://localhost:8080/users";

form.addEventListener('submit', (event) => {
    event.preventDefault();
    
    body = {
        name: name.value,
        email: email.value,
        cpf: cpf.value,
        role: role.value
    }

    if (name.value === '' || email.value === '' || cpf.value === '' || role.value === '') {
        alert('Preencha todos os campos');
        
    }
    else{
        fazPost(url, JSON.stringify(body));
    }
    
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