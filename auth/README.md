# Login e Registro de Usuário

Os usuários devem ser capazes de se castrar e fazer login no sistema usando as ferramentas do Spring Security para autenticação e autorização.

## Obtendo o token

```bash
curl -XPOST user:password@localhost:8080/token
```

## Fazendo requisição em outra aplicação

```bash
curl -H "Authorization: Bearer $TOKEN" $URL
```
