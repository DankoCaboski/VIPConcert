# VIPConcert
API RESTfull para ddesenvolver habilidades
Esse projeto visa repliccar uma plataforma online ficticia para compra e reserva de ingressos de eventos


Construa a image

```Bash
docker build --build-arg JAR_FILE=target/*.jar -t myorg/vipconcert .
```
Inicie o conteiner mapeando a porta 8080 para 8080
```Bash
docker run -p 8080:8080 myorg/vipconcert
```
