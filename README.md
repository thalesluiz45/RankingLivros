<h1 align="center">🖥️ Sistema de Ranking de Livros</h1>
<p> Projeto desenvolvido nas disciplinas de Banco de Dados 1 e Padrões de Projetos. </p>
<p> Equipe: Thales Luiz Araújo Carvalho e Thiago dos Santos Araújo</p>

## Modelo Conceitual
![modelo_Conseitual](https://github.com/user-attachments/assets/1a720881-2882-438b-8824-41547756e2ca)



## Modelo Logico
![modelo_Logico](https://github.com/user-attachments/assets/583e62e1-a3db-44fd-bbb3-b1e165609be1)



## Mini Mundo

## Descrição do Projeto

O projeto tem como objetivo criar um sistema de ranking de livros, utilizando um banco de dados estruturado. O sistema permite a classificação e filtragem de informações sobre os melhores livros e autores, com base em avaliações e outras métricas relevantes.
Utilizamos o SGBD Postgresql da NeonDB.

## Funcionalidades do Sistema

## Funcionalidades de Livros

- **Listagem dos Livros:** Exibe uma lista de todos os livros cadastrados.
- **Filtros de Pesquisa:** Permite filtrar os livros por gênero, publicadora, título ou autor.
- **Informações Detalhadas:** Exibe informações completas sobre cada livro, incluindo:
  - Título
  - Autor(es)
  - Nota média
  - ISBN
  - ISBN-13
  - Idioma
  - Gênero
  - Publicadora

### Funcionalidades de Autores

- **Listagem de Autores:** Exibe uma lista de todos os autores cadastrados.
- **Detalhes dos Autores:** Para cada autor, exibe:
  - Nome do autor
  - Identificação de cada livro do autor

### Funcionalidades de Gêneros

- **Listagem de Gêneros:** Exibe uma lista de todos os gêneros cadastrados.
- **Filtragem por Gênero:** Permite exibir todos os livros de um gênero específico.

### Funcionalidades das Editoras

- **Listagem de Editoras:** Exibe uma lista de todas as editoras cadastradas.
- **Filtragem por Editoras:** Permite exibir todos os livros de uma editora específica.

## Interação do Usuário

O usuário poderá interagir com o sistema por meio de uma API REST, permitindo a consulta de informações através de endpoints bem definidos:

- `GET http://localhost:8080/genres` – Listar todos os gêneros.
- `GET http://localhost:8080/authors` – Listar todos os autores.
- `GET http://localhost:8080/books` – Listar todos os livros.
- `GET http://localhost:8080/publishers` – Listar todas as editoras.
- `...?page=1` - faz a paginação(digite esse comando na URL).

## Melhorias Futuras

- Implementação de uma interface gráfica ou web para uma melhor experiência do usuário.
- Expansão do banco de dados com novas fontes de informação sobre livros e autores.

