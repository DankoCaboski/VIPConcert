const meusEventos = document.querySelector('#meus-eventos');

meusEventos.addEventListener('click', () => {
    window.location.href = '../../pages/user/USER.meusEventos.html';
})

const cadastrarEvento = document.querySelector('#cadastrar-evento');
cadastrarEvento.addEventListener('click', () => {
    console.log('cadastrar evento');
    window.location.href = '../../pages/event/EVENT.cadastro.html';
})