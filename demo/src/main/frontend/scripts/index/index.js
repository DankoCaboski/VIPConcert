import { eventBanner } from './COMPONENT.event.js'

const eventosDoUsuario = [1, 2, 3];

function seedBanners() {
    const eventsPost = document.getElementById('eventsPost');
    
    if (eventosDoUsuario.length === 0) {
        console.warn("A lista de eventos do usuário está vazia");
        eventsPost.style.display = "none";
        // Adicione o código que você deseja executar quando a lista estiver vazia
    } else {
        console.log("A lista de eventos do usuário não está vazia");
        eventosDoUsuario.forEach(eventId => {
            const myPost = eventBanner(eventId);
            if (myPost !== undefined) {
                eventsPost.appendChild(myPost);
                console.log(`Adicionando banner do evento ${eventId}`);
            }
            else {
                console.warn(`Não foi possível adicionar o banner do evento ${eventId}`);
            }
        });
    }
}

seedBanners()