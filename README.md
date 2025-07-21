# DOCUMENTAÇÃO DO CURSO DE TESTES UNITÁRIOS

## Principios FIRST

Seria um princípio que traz um conjunto de regras que todo teste unitário deveria seguir.


F -> Fast (todo teste unitário deve ser rápido)
I -> Independents (Testes unitários devem ser independentes)
R -> Repeatable (Testes unitários devem permitir repetição)
S -> Self-validating (Testes unitários devem ter autoavaliação)
T -> Timely (Testes devem ser escritos junto ao desenvolvimento)



## @Test


Anotação feita para testar metodos dentro de classes de teste

Todo teste precisa ser void.


## @Disabled

Desabilita o metodo que está anotado com esta anotação.


## @Nested

Organização de testes unitários


## @BeforeEach

Ele executa o método primeiro antes dos outros

## @BeforeAll

Precisa ser um método estático

Ele executa o método antes de todos os metodos e apenas uma vez

ex.: static void initAll()


## @AfterAll

Precisa ser um método estático

Depois de todos os métodos, ele executa


## @AfterEach

Depois de cada teste, ele é executado


## Classe de assertion

Elas ajudam a gente a auto avaliar os testes


assertEquals(primeiro parametro -> valor esperado, segundo parametro -> valor atual)



## Stub (dublê)


Ele é uma implementação que ajuda a isolar o nosso teste unitário do banco de dados, para não ser um teste de integração



## Mock


Forma de fazer uma implementação falsa ou fictícia de uma classe ou de uma interface, assim como o STUB

Muito utilizado nos testes unitários afim de utilizar os testes unitários

Mock é um STUB porém com algumas vantagens:

1.: Não é necessário implementar uma interface ou uma extender uma classe

2.: Facilidade de definir um comportamento fictício dinâmico em uma classe

3.: Verificar comportamento da classe com mock


Framework Mockito + jUnit



## Testes parametrizados

Para utilizar esse parametro dinamico, tem que colocar uma dependencia no pom.xml

<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-params</artifactId>
			<version>5.10.5</version>
			<scope>test</scope>
</dependency>

@ParameterizedTest
@ValueSource

No parametro do teste tem que colocar o parametro que foi colocado dentro do ValueSource




## JaCoCo (Java Code Coverage Library)

Ele faz a mesma coisa que a IDE do intelliJ faz, mas fica via explorer

Ele é um plugin.

<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.8</version>
				<executions>
					<execution>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<phase>prepare-package</phase>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>


## AssertJ

Melhora a legibilidade do código de teste

Fornece um diverso conjunto de asserções

Mensagens de erro mais detalhadas e customizáveis

### Módulos do AssertJ

Core
Guava
Joda Time
Neo4j
Database
Swing