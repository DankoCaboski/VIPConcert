export const eventBanner = (eventId) => {
    const component = document.createElement('div');

    const imageElement = document.createElement('img');

    // Fazer a chamada HTTP para obter o título do evento
    fetch(`http://localhost:8080/event/title/${eventId}`)
    .then(response => response.json())
    .then(data => {
        // Criar o elemento de título e adicionar ao componente
        const captionElement = document.createElement('p');
        captionElement.innerHTML = data.name;
        component.appendChild(captionElement);
        
        if(data.imgId == null){
            if(data.genero == "FESTA" || data.genero == "SHOW"){
                imageElement.src = "http://localhost:8080/images/defaultShowImg.jpg";
                imageElement.style.width = "200px";
                imageElement.style.height = "150px";
                component.appendChild(imageElement);
            }else{
                if(data.genero == "CONGRESSO"){
                    imageElement.src = "http://localhost:8080/images/defaultCongressImg.jpg";
                    imageElement.style.width = "200px";
                    imageElement.style.height = "150px";
                    component.appendChild(imageElement);
                }else{
                    imageElement.src = "http://localhost:8080/images/defaultTheatreImg.jpg";
                    imageElement.style.width = "200px";
                    imageElement.style.height = "150px";
                    component.appendChild(imageElement);
                }
            }
            
    }
})
        .catch(error => {
            console.error('Erro ao obter o título do evento:', error);
        });
        
    
    const priceElement = document.createElement('p');
    component.appendChild(priceElement);
    
    return component;
}

export default eventBanner;
