Crie uma API em Spring com a base de dados H2Database em memória que suporte.

- Listar todos os clientes em JSON.

      GET /client/list

- Alterar os dados do cliente associado ao ID.

      PUT /client/{id}

- Criar um novo cliente.

      POST /client

- Remover do sistema o cliente assosiado ao ID.

      DELETE /client/{id}


O cliente tem os seguintes dados:

    Name, mínimo 5 legras e no máximo 100 caractéres
    Age, mínimo 18 anos
    VAT Number, exemplo XX999999999
    Email

Os dados do cliente são obrigatórios e precisam ser validados, não deve permitir inserir ou alterar dados inválidos.
