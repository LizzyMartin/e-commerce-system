# E-commerce System

O sistema contém 4 microsserviços sendo eles:
    - auth: responsável por gerenciar usuários e obter autenticação
    - items-management: responsável por listar, cadastrar, atualizar e deletar items (exclusivo para usuários com a role admin)
    - cart: responsável por adicionar produtos a um carrinho associado a um usuário
    - payment: tela que simular o pagamento, onde é possível visualizar os itens presentes no carrinho, assim como o valor total da compra

O banco de dados escolhido foi o mongodb devido sua facilidade de uso.

## Executando localmente

Para executar o projeto localmente é necessário que você tenha o Docker instalado em sua máquina, com isso, basta executar o comando abaixo:

```bash
./build-jar.sh
docker compose up
```

Com isso tanto os microsserviços como o banco de dados deverão ter subido. Para começar a interagir com o sistema é necessário primeiramente se autenticar seguindo os seguintes passos

1. Fazer uma requisição POST com Basic Auth para a url <http://localhost:8080/token> com isso você receberá no corpo da resposta um token que será utilizado para interagir com os demais endpoints. Um usuário admin e outro comum já estão previamente cadastrados, sendo eles:

    - **username:** user, **password:** password
    - **username:** admin, **password:** password

2. Com o token, adicione o header "Authentication: Bearer \<TOKEN>" para realizar as possíveis requisições abaixo:

    - GET <http://localhost:8081/items>
    - GET <http://localhost:8081/items/{id}>
    - POST <http://localhost:8081/items>
    - POST <http://localhost:8082/cart>

        ```json
            {
                "userId": "123",
                "productId": "123",
                "quantity": 1
            }
        ```

3. Para visualizar o carrinho, basta acessar a URL abaixo:

    - <http://localhost:80>
