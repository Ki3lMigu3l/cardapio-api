# Documentação da API do Cardápio de Restaurante

## Introdução

Bem-vindo à documentação da API do Cardápio de Restaurante, um projeto em desenvolvimento que utiliza Spring Boot para o backend, React para o frontend e um banco de dados MySQL para armazenamento de dados. Esta aplicação tem como objetivo criar um sistema de cardápio para um restaurante, facilitando a gestão e exibição de itens disponíveis.

## Tecnologias Utilizadas

- **Backend:**
  - Spring Boot: Framework Java para desenvolvimento de aplicativos web e serviços RESTful.
  - MySQL: Sistema de gerenciamento de banco de dados relacional para armazenamento persistente de dados.

- **Frontend:**
  - React: Biblioteca JavaScript para construção de interfaces de usuário.

## Estrutura da API

A API do Cardápio de Restaurante é estruturada em torno de diversos endpoints que permitem a gestão eficaz do cardápio.

### 1. Listar Itens do Cardápio

**Endpoint:** `/api/cardapio`  
**Método:** `GET`  
**Descrição:** Retorna uma lista de todos os itens disponíveis no cardápio.

### 2. Detalhes de um Item do Cardápio

**Endpoint:** `/food`  
**Método:** `GET`  
**Descrição:** Retorna os detalhes de um item específico com base no ID.

### 3. Adicionar Novo Item ao Cardápio

**Endpoint:** `/food`  
**Método:** `POST`  
**Descrição:** Adiciona um novo item ao cardápio. O corpo da requisição deve conter os dados do item.

Exemplo de corpo da requisição:
```json
{
  "nome": "Pizza Margherita",
  "imagem": "url-da-imagem",
  "preco": 25.99
}
