# SUS Connect Exames

Este projeto é um microsserviço desenvolvido em Java utilizando Spring Boot, destinado ao gerenciamento de exames no sistema SUS Connect. O microsserviço segue os princípios da Arquitetura Limpa e do Domain Driven Design (DDD).

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

- **src/main/java/br/gov/susconnect/exames**: Contém o código-fonte do microsserviço.
  - **application**: Contém a lógica de aplicação, incluindo DTOs, mapeadores e serviços.
  - **domain**: Contém as entidades do domínio e os repositórios.
  - **infrastructure**: Contém a configuração, persistência e controladores REST.

- **src/main/resources**: Contém os arquivos de configuração e scripts de migração do banco de dados.
  - **application.properties**: Configurações da aplicação.
  - **db/migrations**: Scripts de migração do banco de dados.

- **src/test/java/br/gov/susconnect/exames**: Contém os testes unitários do microsserviço.

## Como Executar o Projeto

1. **Clone o repositório**:
   ```
   git clone <URL_DO_REPOSITORIO>
   cd sus-connect-exames
   ```

2. **Compile o projeto**:
   ```
   mvn clean install
   ```

3. **Execute a aplicação**:
   ```
   mvn spring-boot:run
   ```

4. **Acesse a API**: A API estará disponível em `http://localhost:8080`.

## Dependências

O projeto utiliza as seguintes dependências principais:
- Spring Boot
- Spring Data JPA
- PostgreSQL

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## Licença

Este projeto está licenciado sob a MIT License. Veja o arquivo LICENSE para mais detalhes.