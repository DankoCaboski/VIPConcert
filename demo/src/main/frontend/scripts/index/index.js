import { eventBanner } from './COMPONENT.event.js'

const eventos = [];


function seedBanners() {

    eventos.forEach(eventId => {
        const mainElements = document.getElementsByTagName('main');
        const main = mainElements[0];
        const myDiv = eventBanner(eventId);
        main.appendChild(myDiv);
    });
}

seedBanners()