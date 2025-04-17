# SUS Connect Prescrições

Microsserviço para gerenciamento de prescrições no projeto **SUS Connect**. Este serviço é responsável por gerenciar prescrições médicas, dispensações de medicamentos e validações relacionadas.

## Funcionalidades Principais

### Prescrições
- **Cadastro de Prescrições**: Permite o registro de prescrições médicas com informações como CPF do paciente, CPF do profissional, data e itens prescritos.
- **Status da Prescrição**: Gerenciamento do status da prescrição utilizando um `enum` (`ATIVA`, `INATIVA`, `PENDENTE`).

### Dispensações
- **Cadastro de Dispensações**: Registra dispensações de medicamentos associadas a uma prescrição, com validação da data de retirada.
- **Validação de Próxima Retirada**: Impede o cadastro de dispensações caso a data atual seja anterior à data da próxima retirada permitida.
- **Consulta de Dispensações por Prescrição**: Retorna todas as dispensações associadas a uma prescrição específica.

### Exceções e Validações
- **Exceções Personalizadas**: Tratamento de erros com mensagens claras e respostas no formato JSON.
- **Validação de Dados**: Uso de anotações como `@NotNull` e `@NotBlank` para garantir a integridade dos dados.

### Integrações
- **Banco de Dados**: Persistência utilizando PostgreSQL com JPA/Hibernate.
- **Swagger UI**: Documentação interativa da API disponível em `/swagger-ui.html`.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 2.6.6**
  - Spring Web
  - Spring Data JPA
- **PostgreSQL**
- **Swagger/OpenAPI**
- **Maven**
