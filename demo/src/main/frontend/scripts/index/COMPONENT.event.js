export const eventBanner = (eventId) => {
    const component = document.createElement('div');

    
    const imageElement = document.createElement('img');
    imageElement.src = "http://localhost:8080/images/defaultShowImg.jpg";
    imageElement.style.width = "200px";
    imageElement.style.height = "150px";
    component.appendChild(imageElement);

    // Fazer a chamada HTTP para obter o título do evento
    fetch(`http://localhost:8080/event/title/${eventId}`)
        .then(response => response.json())
        .then(data => {
            // Criar o elemento de título e adicionar ao componente
            const captionElement = document.createElement('p');
            captionElement.innerHTML = data.name;
            component.appendChild(captionElement);
        })
        .catch(error => {
            console.error('Erro ao obter o título do evento:', error);
        });
        
    
    const priceElement = document.createElement('p');
    component.appendChild(priceElement);
    
    return component;
}

export default eventBanner;
