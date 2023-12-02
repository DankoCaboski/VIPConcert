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