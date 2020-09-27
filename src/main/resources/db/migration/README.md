# FlyWay:

As configurações para utilizar o flyway estão no arquivo pom.xml.
Algumas delas são necessarias, como as configurações na tag `<properties>` do pom.xml, onde se referencia a `URL Connection`, o `Nome do DB`, o `User name` e o `Password`.
Também existem pré-configurações para o build, que estam na tag de `<plugins>` no arquivo pom.xml, lá esta um exemplo de como referenciar os arquivos das migrations, onde o necessário é somente a `url` aos arquivos.

### Padrões Obrigatorios:

Ao tentar implementar o FlyWay no projeto, existem padrões que são obrigatorios, como o nome das migrations, o link abaixo leva a explicação desses padrões.
https://flywaydb.org/documentation/migrations

### Mas resumindo: 

Os números são as versões, e o pre-fixo, o tipo.

#### - **V1** - Arquivos Vercionados
#### - **U1** - Remoção
#### - **R1** - Repetições

#### Versões alternativas:

Existem alguns tipos de se referenciar as versões, que são explicadas no link do flyway citado acima.

As utilizadas neste projetos são:
#### - **V1_1__**
#### - **U1_1__**
#### - **R1_1__**

