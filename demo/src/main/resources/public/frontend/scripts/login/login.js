const submit = document.getElementById("submit");
const username = document.getElementById("username");
const password = document.getElementById("password");

submit.addEventListener('click', function(event) {
    if(username.value === "" || password.value === ""){
        return alert("Preencha todos os campos");
    }    else{
        event.preventDefault();
        const body = JSON.stringify({
            username: username.value,
            password: password.value,
        });
        console.log("body", body);
        fazPost('/auth/login', body)
        .then((response) => { 
            console.log("response", response);
            localStorage.setItem("token", response);
            window.location.href = "./user/USER.home.html";
        })
        .catch((error) => {
            console.log("error", error);
        });
    }
});

const register = document.getElementById("register");
register.addEventListener('click', function(event) {
    console.log("register");
    window.location.href = "./user/USER.cadastro.html";
    }
);


function fazPost(url, body) {

    return new Promise((resolve, reject) => {
        let request = new XMLHttpRequest();

        request.open("POST", url, true);
        request.setRequestHeader('Content-Type', 'application/json');
        
        request.onload = function() {
            if (request.status === 200) {
                resolve(request.response);
            } else {
                if (request.status !== 401) {
                    reject(new Error('Error: ' + request.status));
                } else {
                    username.style.border = "1px solid red";
                    password.style.border = "1px solid red";
                }
            }
        };

        request.onerror = function() {
            reject(new Error('Network error'));
        };

        request.send(body);
    });
}

console.log( "token: ", localStorage.getItem("token"));