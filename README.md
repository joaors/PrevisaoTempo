# PrevisaoTempo

Projeto de consulta da previsão do tempo

Projeto que consome os dados de tempo do wsdl http://www.webservicex.net/globalweather.asmx?WSDL.
Procura a Cidade de Florianópolis, salva em banco os dados retornados e exibe na página para o usuário.

Ambiente de desenvolvimento do projeto:

- Eclipse Mars
- Java 8
- Java EE 7
- Wildfly
- PostgreSQL

Configurar no Wildfly um datasource para o postgreSQL com nome java:jboss/PostgreSQLDS
No database apontado pelo datasource aplicar o sql previsao.sql.

A index.html efeuta a consulta no seguinte endereço: 

<b>http://localhost:8090/PrevisaoTempo/api/previsao</b>

Caso utilizar porta diferente alterar no arquivo api.js a variável vUrlAPI.

Endereços para consulta dos dados via JSON.

<b>para consultar uma previsao especifica já registrada no sistema</b>
http://servidor:porta/PrevisaoTempo/api/previsao/{id}

<b>para consultar todas as previsões já registradas no sistema</b>
http://servidor:porta/PrevisaoTempo/api/previsao/all

<b>para consultar a previsão atual</b>
http://servidor:porta/PrevisaoTempo/api/previsao
