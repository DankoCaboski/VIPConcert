const meusEventos = document.querySelector('#meus-eventos');

meusEventos.addEventListener('click', () => {
    window.location.href = 'http://127.0.0.1:5500/demo/src/main/frontend/pages/user/USER.meusEventos.html';
})

const cadastrarEvento = document.querySelector('#cadastrar-evento');
cadastrarEvento.addEventListener('click', () => {
    console.log('cadastrar evento');
    window.location.href = 'http://127.0.0.1:5500/demo/src/main/frontend/pages/event/EVENT.cadastro.html';
})

const sair = document.querySelector('#sair');

sair.addEventListener('click', () => {
    window.localStorage.removeItem('token');
    window.location.href = '../../index.html';
})