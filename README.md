# Desafio Técnico - Vaga Backend - Nubank #

Construa uma API REST para gerenciamento de clientes e seus contatos. Cada cliente pode ter um ou mais contatos associados.
# Requisitos Técnicos #
# Sua aplicação deve conter: #

• Cadastro de Cliente (POST /clientes)

• Cadastro de Contato (POST /contatos) associado a um cliente existente

• Listagem de todos os clientes com seus contatos (GET /clientes)

• Listagem de contatos de um cliente específico (GET /clientes/{id}/contatos)

• Uso de Spring Boot + Spring Data JPA

• Banco de dados PostgreSQL

• Entidades Cliente e Contato com relacionamento OneToMany / ManyToOne

# Requisitos de Código #
# Esperamos que seu código siga boas práticas de desenvolvimento, incluindo: # 

• Separação de responsabilidades (camadas: controller, service, repository)

• Uso de DTOs para entrada e saída de dados

• Tratamento adequado de erros

• Usar Lombok
#Diferenciais (Não obrigatórios)#

• Uso de Docker para subir o PostgreSQL

• Testes automatizados

• Documentação com Swagger
