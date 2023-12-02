import { eventBanner } from './COMPONENT.event.js'

const eventosDoUsuario = [1];

function seedBanners() {

    eventosDoUsuario.forEach(eventId => {
        const main = document.getElementById('main')
        const myDiv = eventBanner(eventId);
        main.appendChild(myDiv);
    });
}

seedBanners()

const entrar = document.getElementById('entrar');
entrar.addEventListener('click', () => {
    window.location.href = 'http://127.0.0.1:5500/demo/src/main/frontend/pages/login.html';
});