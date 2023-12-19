# VIPConcert
Esta API foi concebida com o propósito de aprimorar habilidades específicas no desenvolvimento web com Spring Boot. O foco do projeto está na implementação de padrões de segurança robustos, garantindo escalabilidade e práticas de teste rigorosas.

A iniciativa visa emular uma experiência autêntica de transações e interações dentro de uma plataforma de entretenimento. Isso inclui a exploração de diversos aspectos, como a seleção de eventos, o processo de compra, a gestão de reservas e a integração de funcionalidades pertinentes para simular uma aplicação real voltada para a aquisição de ingressos para eventos.

Passo para aexecutar a aplicação:

## Navegação até o Diretório:
Abra o terminal e navegue até o diretório do projeto usando o seguinte comando:
```Bash
cd caminho/do/diretorio/demo
```

## Construção do Projeto:
Utilize o Apache Maven para construir o projeto. Este comando compilará o código-fonte, gerará artefatos e preparará a aplicação para execução.
```Bash
mvn clean package
```

## Inicialização do Docker Compose:
Inicie os contêineres Docker necessários para a aplicação por meio do arquivo compose.yaml usando o seguinte comando:
```Bash
docker-compose up
```

## Acesso à API:
Após a inicialização, a API estará disponível na [porta 3000](http://localhost:3000/). Acesse a aplicação por meio do seu navegador ou ferramenta de requisições HTTP.