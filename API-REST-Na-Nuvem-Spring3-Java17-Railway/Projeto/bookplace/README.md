# BookPlace API

Acesse o link público [clicando aqui](https://bookplace-api-production.up.railway.app/swagger-ui/index.html) para realizar os testes da API pelo Swagger.

Abaixo está um exemplo de formato JSON para cadastro de livros:

```json
{
    "title": "Sistemas Operacionais Modernos",
    "edition": "3ª edição",
    "author": "Andrew S. Tanembaum",
    "publicationDate": "2015-04-07",
    "postDate": "2024-11-11",
    "description": "Sistemas Operacionais Modernos, de Andrew S. Tanenbaum, é um livro fundamental para entender os princípios e a prática dos sistemas operacionais. ",
    "imageUrl": "https://github.com/FrancisBFTC/BootCamp-Java-Angular/blob/main/API-REST-Na-Nuvem-Spring3-Java17-Railway/Modelagem/Imagens/sistemas-operacionais-modernos.png?raw=true",
    "category": {
      "name": "Computação"
    },
    "tags": [
      {
        "name": "#sistemasoperacionais"
      },
      {
        "name": "#arquitetura"
      }
    ]
  }
```
Veja também o arquivo `Cadastros-Iniciais-Livros.json` para ver outros exemplos. Nota: Para realizar updates, é necessário fornecer o ID dos valores que quer alterar e os próprios valores, como o JSON acima + o id. Apenas para cadastros POST não é necessário fornecer o ID.

## EndPoints REST

- https://bookplace-api-production.up.railway.app/books : Realiza cadastros/atualizações esperando uma estrutura JSON no corpo da solicitação via POST/PUT (POST -> Cadastro e PUT -> Atualização).

- https://bookplace-api-production.up.railway.app/books/{id} : Busca ou Deleta um cadastro pelo ID fornecido pela URL via GET, retornando uma estrutura JSON em caso de busca ou string em caso de deleção.

- https://bookplace-api-production.up.railway.app/books/all : Busca todos os cadastros retornando a estrutura JSON de todos eles.
