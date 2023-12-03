
const form = document.querySelector('#user-form');
const name = document.querySelector('#name');
const email = document.querySelector('#email');
const cpf = document.querySelector('#cpf');
const role = document.querySelector('#role');
const id = document.querySelector('#id'); 

const url = "http://localhost:8080/auth/register";

form.addEventListener('submit', (event) => {
    event.preventDefault();
    
    const body = {
        name: name.value,
        email: email.value,
        cpf: cpf.value,
        role: role.value,
        status : 'ACTIVE'
    }

    if (name.value === '' || email.value === '' || cpf.value === '' || role.value === '') {
        alert('Preencha todos os campos');
        
    }
    else{
        fazPost(url, JSON.stringify(body))
    }
});


function fazPost(url, body) {
    let request = new XMLHttpRequest();
    request.open("POST", url, true);
    request.setRequestHeader('Content-Type', 'application/json');
    
    request.onload = function() {

        console.log(request.response);

        if(request.status != 201){
            console.log(request.status);
            console.log("Body: " + body);
        }
        else{   
            window.location.href = "http://127.0.0.1:5500/demo/src/main/frontend/pages/user/USER.home.html";
        }
        status.style.display = 'block';
    };
    request.send(body);
    return request.status;
}