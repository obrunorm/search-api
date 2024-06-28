<h1 align="center">
	Search API
</h1>

<div>
    <p align="center">
        <em>
            <br><br>
        </em>
    <a href="https://www.linkedin.com/in/bruno-martins-8667b0180/" target="_blank">
        <img src="https://img.shields.io/static/v1?label=Author&message=Bruno&color=00ba6d&style=for-the-badge&logo=LinkedIn" alt="Author: Bruno Martins">
    </a>
    <a href="https://www.oracle.com/br/">
		<img  src="https://img.shields.io/static/v1?label=Language&message=Java&color=red&style=for-the-badge&logo=Java"  alt="Language: Java">
	</a>
    </p>
</div>

## 📂Documentation
- [Documentação](https://www.notion.so/Documenta-o-do-Projeto-beea7c05a95b43c28eda311383f721dd?pvs=4)


## 📌About
 - Projeto feito para o teste da empresa Rang.

## 🚀Features

- Cadastrar, Atualizar, consultar e Apagar -> Unidades de Saúde
- Pesquisar pelo CEP -> Unidades de Saúde

## 📕Installation

**You must have already installed**
- [Java](https://www.oracle.com/br/java/technologies/downloads/)
- [Eclipse IDE](https://www.eclipse.org/downloads/)
- [Tomcat](https://tomcat.apache.org/download-90.cgi)
- [MySQL](https://dev.mysql.com/downloads/)


### 🏃Rodando projeto com Tomcat

1. Clone o repository: git clone https://github.com/obrunorm/testRang
2. Baixe e instale o Apache Tomcat em seu sistema
4. Configure o arquivo `persistence.xml`. Não esqueça adicionar o usuario e senha do mysql. (o arquivo está na pasta META-INF)
5. Crie um banco de dados chamado `mydatabase'
6. Copie o arquivo .war da pasta war
7. Cole o arquivo WAR na pasta `webapps` dentro da pasta onde o Tomcat foi instalado.
8. Inicie o Tomcat executando o script de inicialização.
 No Windows, geralmente é o arquivo `startup.bat` e no Linux é o `startup.sh` (está dentro da pasta bin)
9. Após iniciar o Tomcat, sua aplicação estará disponível no navegador. Acesse-a digitando o seguinte endereço: 
http://localhost:8080/searchCep/Interface/InterfaceGeral.xhtml

## 🌐Technologies

- [Java EE](https://www.oracle.com/br/java/technologies/java-ee-glance.html)
- [MYSQL](https://www.mysql.com/)
