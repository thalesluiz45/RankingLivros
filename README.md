<h1 align="center">🖥️ Sistema de Ranking de Livros</h1>
<p> Projeto desenvolvido nas disciplinas de Banco de Dados 1 e Padrões de Projetos. </p>
<p> Equipe: Thales Luiz Araújo Carvalho e Thiago dos Santos Araújo</p>

## Modelo Conceitual
![modelo_Conseitual](https://github.com/user-attachments/assets/1b2c84b5-b63a-4903-a595-a00b020f020a)


## Modelo Logico
![modelo_Logico](https://github.com/user-attachments/assets/20991b7b-4000-4316-b812-9eb8db2f8c88)


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

### Funcionalidades do Banco de Dados

- **Carregar Dados:** O sistema carrega automaticamente os dados de livros, autores, gêneros e publicadoras ao ser iniciado.
- **Salvar Dados:** Qualquer alteração realizada no sistema será salva de forma persistente no banco de dados.
- **Sair:** O sistema pode ser encerrado a qualquer momento.

## Interação do Usuário

O usuário poderá interagir com o sistema por meio de uma API REST, permitindo a consulta de informações através de endpoints bem definidos:

- `GET http://localhost:8080/genres` – Listar todos os gêneros.
- `GET http://localhost:8080/authors` – Listar todos os autores.
- `GET http://localhost:8080/books` – Listar todos os livros.
- `GET http://localhost:8080/publishers` – Listar todas as editoras.

## Melhorias Futuras

- Implementação de uma interface gráfica ou web para uma melhor experiência do usuário.
- Expansão do banco de dados com novas fontes de informação sobre livros e autores.

