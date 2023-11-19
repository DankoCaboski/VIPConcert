import { eventBanner } from './COMPONENT.event.js'

function seedBanners() {
    const main = document.getElementById('main')
    const myDiv = eventBanner(1);
    main.appendChild(myDiv);
}

seedBanners()