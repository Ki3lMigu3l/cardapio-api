# *API RESTful de Cardápio de Restaurante*
[![Java](https://img.shields.io/badge/Java-17-%23ED8B00?logo=openjdk)](https://jdk.java.net/17/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.5-%236DB33F?logo=spring)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-%234479A1?logo=mysql&logoColor=white)](https://www.mysql.com)
[![Swagger](https://img.shields.io/badge/Swagger-2.1.0-%2385EA2D?logo=swagger)](https://swagger.io/)
[![JUnit5](https://img.shields.io/badge/JUnit5-5.9.3-%25B60017?logo=junit5)](https://junit.org/junit5/)
[![codecov](https://codecov.io/gh/Ki3lMigu3l/cardapio-api/graph/badge.svg?token=6Y7LUJM8PN)](https://codecov.io/gh/Ki3lMigu3l/cardapio-api)


Este é um projeto Full Stack de uma API RESTful para a gestão de cardápios, desenvolvido com Spring no backend, React no frontend, MySQL como banco de dados e Tailwind para estilização. O sistema visa proporcionar uma forma simples de gerenciamento e exibição de itens de cardápio, proporcionando uma experiência intuitiva.

<h2></h2>

<div align="center">
  <h3>Principais Tecnologias e Ferramentas</h3>
  
  [![My Skills](https://skillicons.dev/icons?i=git,java,spring,mysql,react,tailwind,idea,postman&perline=8)](https://skillicons.dev)
</div>

<h2></h2>

<div align="center">
  <h3>Backend</h3>
</div>

O backend foi desenvolvido com Spring Boot, uma escolha sólida por sua robustez, escalabilidade e forte suporte à construção de APIs RESTful. A estrutura do projeto segue uma arquitetura em camadas, com divisão clara entre controllers, services e repositórios, facilitando a manutenção e os testes. O Spring também oferece integração nativa com JPA e validações, acelerando o desenvolvimento e garantindo boas práticas desde o início.

<br><br>
<div align="center">
  <h3> Documentação Swagger (OpenAPI)</h3>
  <img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/swagger.png" alt="Swagger" width="40"/>
</div>


<br>
O projeto utiliza Swagger, atualmente conhecido como OpenAPI, que é um framework para documentação de APIs RESTful. Ele gera uma documentação interativa de forma automática, padroniza a descrição dos endpoints e permite testar a API diretamente pela interface.

<div align="center">
  <img src="https://github.com/Ki3lMigu3l/cardapio-api/blob/main/docs/carbon-endpoint-get.png?raw=true" width="800px" />
  <p><em>Endpoint para buscar um item pelo ID.</em></p>
</div>

<br>
<div align="center">
Acesse a documentação interativa: 

[![Swagger UI](https://img.shields.io/badge/Swagger_UI-Live-%2385EA2D?logo=swagger)](http://localhost:8080/swagger-ui.html)
</div>

<div align="center">
  
  <img src="https://github.com/Ki3lMigu3l/cardapio-api/blob/main/docs/swagger-endpoints.png" width="800px" />
  <p><em>Documentação interativa dos endpoints de Food</em></p>
  
</div>

<h2></h2>

<div align="center">
  <h3>Testing | JUnit 5</h3>
  <img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/junit.png" alt="JUnit 5" width="50"/>
</div>


Utilizamos o JUnit5 que é o principal framework para testes unitários em Java. Ele permite automatizar verificações de comportamento, assegura a qualidade do código e ajuda a prevenir regressões durante o desenvolvimento. A cobertura e qualidade do código estão sendo garantidas por meio do uso do JUnit 5, com testes implementados nas principais classes e camadas, como service e controller.

<br>

<div align="center">
  <h3>Testing Manual | Postman</h3>
  
  [![My Skills](https://skillicons.dev/icons?i=postman&perline=8)](https://skillicons.dev)
</div>

Postman é uma ferramenta amplamente utilizada para testes de APIs RESTful. Ele permite enviar requisições HTTP de forma prática, validar respostas, organizar coleções de testes e simular diferentes cenários de uso. No projeto, o Postman foi utilizado para testar manualmente os endpoints da API, garantindo que estejam funcionando conforme o esperado e facilitando o processo de depuração e validação durante o desenvolvimento.

  <img src="https://github.com/Ki3lMigu3l/cardapio-api/blob/main/docs/postman-crud.png" width="800px" />
  <p><em>Testes manuais dos endpoints da aplicação com Postman.</em></p>


<h2></h2>

<div align="center">
  <h3>FrontEnd</h3>
  
  [![My Skills](https://skillicons.dev/icons?i=react,tailwind&perline=8)](https://skillicons.dev)
</div>

O frontend foi desenvolvido com React.js, escolhido por sua modularidade, performance e facilidade na criação de interfaces reativas e reutilizáveis. A estilização utiliza Tailwind CSS, permitindo um desenvolvimento ágil e responsivo com classes utilitárias diretas no markup. Para navegação entre páginas, foi adotado o react-router-dom, viabilizando o roteamento de forma declarativa e eficiente. O consumo da API é feito por meio do Axios, implementado na camada de services, centralizando as requisições e garantindo uma arquitetura mais limpa e organizada.

<div align="center">
<br>

  <img src="https://github.com/Ki3lMigu3l/cardapio-api/blob/main/docs/home-desktop.png" width="500px" />
  <p><em>Página Inicial do Cardápio</em></p>

<br>

  <img src="https://github.com/Ki3lMigu3l/cardapio-api/blob/main/docs/medium-adminpanel.png" width="500px" />
  <p><em>Painel Admin</em></p>


<br>


  <img src="https://github.com/Ki3lMigu3l/cardapio-api/blob/main/docs/adminpanel-add.png" width="500px" />
  <p><em>Funcionalidade de Adição de Itens ao Cardápio</em></p>


<br>


  <img src="https://github.com/Ki3lMigu3l/cardapio-api/blob/main/docs/adminpanel-update.png" width="500px" />
  <p><em>Funcionalidade de Edição de Itens do Cardápio</em></p>
</div>

<h2></h2>


<h3>Objetivo</h3>
Este projeto tem como objetivo a criação de uma API RESTful para gerenciar um cardápio de restaurante. Ele permite adicionar, editar, remover e listar os itens do cardápio, enquanto oferece uma interface simples e intuitiva para os usuários finais.
