import { eventBanner } from './COMPONENT.event.js'

const eventos = [];

function seedBanners() {
    const eventsPost = document.getElementById('eventsPost');
    const registros = [];
    getEventos()
        .then(data => {
            data.forEach(evento => {
                eventos.push(evento.id);
            });

            if (eventos.length === 0) {
                console.warn("A lista de eventos do usuário está vazia");
                eventsPost.style.display = "none";
                // Adicione o código que você deseja executar quando a lista estiver vazia
            } else {
                console.log("A lista de eventos do usuário não está vazia");
                eventos.forEach(eventId => {
                    let myPost = eventBanner(eventId);
                    console.log("myPost na iteracao ", eventId, myPost);
                    if (myPost !== null) {
                        eventsPost.appendChild(myPost);
                        console.log(`Adicionando banner do evento ${eventId}`);
                    } else {
                        console.warn(`Não foi possível adicionar o banner do evento ${eventId}`);
                    }
                });
            }
        })
        .catch(error => {
            console.error("error: ", error);
            // Handle the error here
        });
}

function getEventos() {
    return fetch(`http://localhost:8080/event`)
        .then(response => response.json())
        .catch(error => {
            console.error("error: ", error);
        });
}

seedBanners();
