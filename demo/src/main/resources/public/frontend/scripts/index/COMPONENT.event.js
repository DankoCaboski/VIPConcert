export const eventBanner = (eventId) => {
    let component = document.createElement('div');
    component.classList.add('stdBanner');

    const imageElement = document.createElement('img');

    let statusFetch = true;

    // Fazer a chamada HTTP para obter o título do evento
    fetch(`http://localhost:3000/event/${eventId}`)
    .then(response => response.json())
    .then(data => {
        // Criar o elemento de título e adicionar ao componente

        const captionElement = document.createElement('p');
        captionElement.innerHTML = data.name;
        component.appendChild(captionElement);
        
        const dateElement = document.createElement('p');
        if(data.dateInicio != null){
            dateElement.innerHTML = data.dateInicio;
        } else {
            dateElement.innerHTML = "Em breve";
        }
        component.appendChild(dateElement);
        
        if(data.imgId == null){
            if(data.genero == "FESTA" || data.genero == "SHOW"){
                imageElement.src = "http://localhost:3000/images/defaultShowImg.jpg";
                component.appendChild(imageElement);
            }else{
                if(data.genero == "CONGRESSO"){
                    imageElement.src = "http://localhost:3000/images/defaultCongressImg.jpg";
                    component.appendChild(imageElement);
                }else{
                    imageElement.src = "http://localhost:3000/images/defaultTheatreImg.jpg";
                }
                
            }
            imageElement.classList.add('bannerImg');
            component.appendChild(imageElement);
        }else{
            //TODO: Fazer a chamada HTTP para obter a imagem do evento em funcao do id
        }


        })
        .catch(error => {
            console.error("error: ", error);
            statusFetch = false;
        });

    if (statusFetch !== true) {
        return;
    }
    
    return component;
}

export default eventBanner;
