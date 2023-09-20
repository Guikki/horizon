


>> Arquivo Main.java


Neste arquivo, inicio criando o cabeçalho do programa, usando “public class Main”;

Após isso, há a public static void Main, iniciando a declaração das funções usadas no programa, em formato de string.

Como já estão nomeadas e existe o parâmetro “new”, usei este recurso para fazer o chamamento das informações dos objetos orientados.

Após isso, temos o segundo bloco, onde a principal função é a inserção da pessoa e também da conta, usando os objetos orientados do programa.

usei o parâmetro “final” como recurso no terceiro bloco do projeto, afinal de contas, é aqui que teremos impressão de pessoa consultada, bem como o seu ID.

No bloco posterior, temos mais uma situação de impressão com verificador prévio, onde há uma mensagem de sucesso da transferência ao caso de chegarmos a esta linha de código; após isso, fechamos a aplicação.

Abaixo disso, uso o recurso do “enum”, que permite separarmos os tipos de contas correntes utilizadas.



>> Arquivo Conta.java


Neste arquivo, temos um início criando a classe pública “Conta”, com seus parâmetros a serem utilizados.

 Dentro dele, temos a função “conta”, a qual usei o “this.” para permitir que o código flua, referenciando um atributo externo fora do método, e permita identificar a variável local da classe;

Depois disso, algumas especificações de definição e ajuste de getters e setters, buscando funcionalidade no código de retornar o valor do atributo; bem como de recebimento de parâmetro para armazenagem em atributo. Assim, podemos ver no código controle de valores.

Após isso, temos a parte de depósito, onde há um acréscimo do valor ao saldo (sendo este o objetivo de depósito); assim, com isso armazenado, podemos fazer etapas de validação com maior precisão em momentos posteriores.

Depois disso, temos o boleano “sacar” como variável, onde coloquei um “if” de verificação do valor, conforme o problema trouxe. Coloquei duas linhas de impressão apenas com a intenção de verificar a funcionalidade do código, mas estas linhas de impressão (linha 73 do código, e linha 76 do código) podem perfeitamente ser deletadas, sem impactos na sua funcionalidade.


>> Arquivo Transferência.java

Aqui, começo importando a biblioteca “java.util.date” para que a data da transferência possa ser utilizada de forma mais dinâmica, conforme pede o desafio.

Após isso, faço processo semelhante de criação de classes; e depois, utilizo o recurso “this.”, seguindo a mesma lógica que já foi explicado acima.

Depois disso, parto novamente para os getters e setters do processo do código.


>> Arquivo Pessoa.java


Da mesma maneira que as anteriores, recorro novamente à criação de classes, de forma alinhada ao já explicado acima. A criação de getters e setters também seguem o mesmo padrão.


>> Arquivo BancoDAO.java


Este é, sem dúvidas, o coração do projeto.

Aqui, começo importando a biblioteca que me permite manipular sql, a “java.sql.*”. Também importei a biblioteca “java.time.Instant” e a “java.time.LocalDate” para manipular horários.

Depois, trago a classe pública BancoDAO, transformando em objeto. Coloco aqui um endereço interno, para que rode em minha máquina.

Depois, trago a função com o mesmo nome do banco, onde busco um try para cadastramento das tabelas em SQL; ainda neste bloco, há um verificador para, caso não haja compatibilidade, traga uma mensagem de erro de acesso e conexão ao banco de dados.

Em novo bloco, crio uma função privada para criar e selecionar o banco de dados. Nela, busco o tipo void pelo fato de não esperar um return do programa. Ainda aqui, exerço a execução de criação ou de seleção de banco de dados, para dessa forma conectar com o verificador acima descrito.

Usando a biblioteca importada de SQL, pude fazer a classe privada de criação de tabelas, com Código em SQL para cada uma; depois disso, há um try buscando a execução de cada uma delas.

Em um novo bloco de códigos, temos a classe pública de inserir pessoa; com os dados informados no desafio; e ao mesmo tempo, os valores “(?, ?, ?)” foram inseridos de maneira inicial, porque o programa possui um espaço de preenchimento (por via terminal, dentro do próprio código) para a substituição destes valores; este mesmo bloco possui os getters dentro de um try para continuidade do código, e um programa de erro em caso de nenhum dos comandos anteriores serem executados. Esta mesma lógica é usada para inserir a conta.

A partir da linha 84, já trago aqui uma função pública para consultar pessoa por ID. Assim, aqui é executado o comando de seleção em SQL, com um try de busca e conexão com a tabela, onde também valida-se os getters e setters do código, mediante uma condicional. O mesmo raciocínio também é válido para a busca da conta

Para a transferência, a lógica usada é um pouco diferente. É feita a função de transferência, com a consulta de conta de origem e conda de destino, e um final que serve de validador da condição de transferência (ou seja, o saldo positivo para tanto).

Caso esta condição não seja satisfeita, o código traz a mensagem de impossibilidade de transferência.

Após isso, é trazido ao código através de um try, os setters e getters da validação da transferência, seguindo a mesma lógica já apresentada no programa.

E por fim, o fechamento da aplicação é apresentado, para que o código seja encerrado corretamente.

