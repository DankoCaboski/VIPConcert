import { eventBanner } from './COMPONENT.event.js'

const eventos = [];

fetch(`http://localhost:8080/event`)
.then(response => response.json())
.then(data => {
    eventos.push(data);
})

function seedBanners() {

    eventos.forEach(evento => {
        console.log("eventos: ", evento.id);

        const mainElements = document.getElementsByTagName('container');
        const container = mainElements[0];
        const myDiv = eventBanner(evento.id);
        container.appendChild(myDiv);
    });
}

seedBanners()

const entrar = document.querySelector('#entrar');
if(entrar){
    entrar.addEventListener('click', () => {
        window.localStorage.removeItem('token');
        window.location.href = './frontend/pages/login.html';
    })
}


