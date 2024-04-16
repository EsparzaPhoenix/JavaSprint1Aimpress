## AImpress

## Integrantes e suas materias

RM97887 - João Carlos França Figueiredo - Disruptive Architectures: IOT, IOB & Generative AI

RM550200 - Leonardo Oliveira Esparza - de Mobile App Development e Java Advanced.

RM552421 - Flavio Sousa Vasconcelos - Mastering Relational and Non-Relational Database e Devops Tools e Cloud Computing.

RM552368 - Wellington de Oliveira Urcino Da Silva - Advanced Business Development With .NET e Compliance & Quality Assurance.

# Resumo

Este chatbot de criação de currículos profissionais é uma ferramenta inovadora projetada para simplificar e aprimorar o processo de elaboração de currículos em um mundo competitivo. Destacando-se pela qualidade garantida através da análise de currículos de alta visibilidade, utiliza algoritmos avançados para identificar as melhores práticas e tendências do mercado. Sua integração com o LinkedIn permite acesso rápido às informações do perfil do usuário, incorporando-as automaticamente ao currículo em construção. Além da formatação em PDF para distribuição e impressão, oferece sugestões personalizadas com base em uma vasta base de dados, visando tornar o currículo mais atrativo e eficaz. Em suma, é uma ferramenta poderosa para quem busca se destacar no mercado de trabalho, oferecendo uma maneira eficiente e confiável de produzir currículos adaptados às demandas do mundo corporativo contemporâneo.



# Diagram de Entidade e Relacionamento
  
![image](https://github.com/EsparzaPhoenix/JavaSprint1Aimpress/assets/92988596/ccf6a504-63db-4c0f-b2b5-ca636032a21b)

# Vídeo apresentando a Proposta Tecnológica

  [Vídeo Pitch](https://youtu.be/LdG-z4mfc5E?si=_SLQaavNePu9GuiU)

# Instrução de como rodar a aplicação
*    Clique no botão CODE destacado em verde e faça o download do arquivo ZIP da aplicação.
*    Descompacte o arquivo e abra o projeto em uma IDE, de preferência o Intellij.
*    As dependências serão automaticamente baixadas pelo Maven.
*    Inicie a aplicação clicando no botão play no topo da IDE.
*    Abra a aplicação de testes de API (Insomnia, Postman) disponível em seu computador.
*    Na barra de endereço, coloque a URL "http://localhost:8080/" e adicione o endpoint escolhido para teste, de acordo com a documentação.

# Listagem de todos os endpoints

POST: Cadastrar um novo currículo:

    URL: http://localhost:8080/curriculos/cadastrar
    Método HTTP: POST
    JSON de exemplo:

    json

    {
        "nome": "João da Silva",
        "numeroTelefone": "11987654321",
        "nivelEscolaridade": "Ensino Médio",
        "habilidades": "Java, Spring Boot, MySQL",
        "certificacoes": "Certificado Java Programmer"
    }

GET: Obter um currículo por ID:

    URL: http://localhost:8080/curriculos/{id}
    Método HTTP: GET
    Exemplo de resposta:

    json

    {
        "id": 1,
        "nome": "João da Silva",
        "numeroTelefone": "11987654321",
        "nivelEscolaridade": "Ensino Médio",
        "habilidades": "Java, Spring Boot, MySQL",
        "certificacoes": "Certificado Java Programmer"
    }

GET: Listar todos os currículos:

    URL: http://localhost:8080/curriculos/ids
    Método HTTP: GET
    Exemplo de resposta

    "content": [
        {
            "id": 2,
            "nome": "Ailton Oliveira",
            "numeroTelefone": "11723456789",
            "nivelEscolaridade": "POS_GRADUACAO",
            "habilidades": "Java, Spring Boot, SQL, Python, DevOps, Docker, Linux",
            "certificacoes": "Certificado em Spring Framework"
        },
        {
            "id": 3,
            "nome": "Jacinto Johnson",
            "numeroTelefone": "11987654321",
            "nivelEscolaridade": "SUPERIOR",
            "habilidades": "Novas habilidades",
            "certificacoes": "Novas certificações"
        }
    ],


DELETE: Deletar um currículo por ID:

    URL: http://localhost:8080/curriculos/{id}
    Método HTTP: DELETE
    Não é necessário enviar um JSON, apenas o ID do currículo a ser deletado.

PUT: Atualizar um currículo por ID:

    URL: http://localhost:8080/curriculos/{id}
    Método HTTP: PUT
    JSON de exemplo:

    json

    {
        "nome": "João da Silva",
        "numeroTelefone": "11987654321",
        "nivelEscolaridade": "Ensino Superior",
        "habilidades": "Java, Spring Boot, MySQL, React",
        "certificacoes": "Certificado Java Programmer, Certificado React Developer"
    }
