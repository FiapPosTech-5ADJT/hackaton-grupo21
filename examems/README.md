
# SUS Connect Exames

O **SUS Connect Exames** é um microsserviço desenvolvido em Java utilizando o framework Spring Boot. Ele faz parte do ecossistema do projeto SUS Connect e é responsável pelo gerenciamento de exames médicos. Este microsserviço segue os princípios da Arquitetura Limpa e do Domain Driven Design (DDD), garantindo uma estrutura modular e de fácil manutenção.

## Funcionalidades Principais

- **Cadastro de Exames**: Permite o registro de novos exames no sistema, incluindo informações como agendamento, observações e data de liberação.
- **Upload de Arquivos**: Suporte para upload de arquivos de resultados de exames, com armazenamento local ou em serviços de nuvem (como S3).
- **Consulta de Exames**: Disponibiliza endpoints para buscar exames cadastrados com base em diferentes critérios, como ID do agendamento ou data.
- **Atualização de Exames**: Permite a atualização de informações de exames já cadastrados, como observações ou resultados.
- **Exclusão de Exames**: Suporte para exclusão de exames do sistema.
- **Documentação da API**: Integração com o Swagger UI para facilitar a exploração e teste dos endpoints disponíveis.
- **Migração de Banco de Dados**: Gerenciamento de versões do banco de dados utilizando Flyway.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal.
- **Spring Boot 2.6.6**: Framework para desenvolvimento rápido de aplicações Java.
- **Spring Data JPA**: Abstração para persistência de dados.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenamento.
- **Flyway**: Ferramenta para controle de versões do banco de dados.
- **Swagger (SpringDoc)**: Documentação interativa da API.
- **Lombok**: Redução de boilerplate no código Java.

## Estrutura do Projeto

- **application**: Contém a lógica de aplicação, incluindo DTOs, mapeadores e serviços.
- **domain**: Contém as entidades do domínio e os repositórios.
- **infrastructure**: Contém a configuração, persistência e controladores REST.
- **resources**: Arquivos de configuração e scripts de migração do banco de dados.
