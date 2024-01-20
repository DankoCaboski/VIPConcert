import { eventBanner } from './COMPONENT.event.js'

let listEventos = null;

async function seedBanners() {
    fetch(`http://localhost:3000/event`)
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        listEventos = data;
        console.log(listEventos.eventos);

        listEventos.eventos.forEach(evento => {

            const events = document.getElementById('events')
            const myDiv = eventBanner(evento.id);
            events.appendChild(myDiv);
        });
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });

}


seedBanners()

const entrar = document.querySelector('#entrar');
if(entrar){
    entrar.addEventListener('click', () => {
        window.localStorage.removeItem('token');
        window.location.href = '/frontend/pages/login.html';
    })
}


