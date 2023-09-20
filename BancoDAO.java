import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;

public class BancoDAO {
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306";
    private final String usuario = "root";
    private final String senha = "suasenha";

    public BancoDAO() {
        try {
            connection = DriverManager.getConnection(url, usuario, senha);
            criarESelecionarBancoDeDados();
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados");
        }
    }

    private void criarESelecionarBancoDeDados() {
        String sqlCreateDatabase = "CREATE DATABASE IF NOT EXISTS banco";
        String sqlSelectDatabase = "USE banco";
        try {
            connection.prepareStatement(sqlCreateDatabase).execute();
            connection.prepareStatement(sqlSelectDatabase).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTables(){
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS Pessoa (Id int NOT NULL PRIMARY KEY, Name varchar(255), Telefone varchar(255), CPF varchar(255))";
        String sqlCreateTableConta = "CREATE TABLE IF NOT EXISTS Conta (Id int NOT NULL PRIMARY KEY, PessoaId int, Numero varchar(255), Digito varchar(255), Saldo float, TipoDeConta varchar(255))";
        String sqlCreateTableTransferencia = "CREATE TABLE IF NOT EXISTS Transferencia (Id int NOT NULL PRIMARY KEY, ContaOrigem int, ContaDestino int, Valor float, DateTransfer varchar(255))";
        String cleanTablePessoa = "DELETE FROM Pessoa";
        String cleanTableConta = "DELETE FROM Conta";
        String cleanTableTrasferencia = "DELETE FROM Transferencia";


        try {
            connection.prepareStatement(sqlCreateTable).execute();
            connection.prepareStatement(sqlCreateTableConta).execute();
            connection.prepareStatement(sqlCreateTableTransferencia).execute();
            connection.prepareStatement(cleanTablePessoa).execute();
            connection.prepareStatement(cleanTableConta).execute();
            connection.prepareStatement(cleanTableTrasferencia).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserirPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO Pessoa (Id, Name, Telefone, CPF) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pessoa.getId());
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getCpf());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir pessoa no banco de dados");
        }
    }

    public void inserirConta(Conta conta) {
        String sql = "INSERT INTO Conta (Id, PessoaId, Numero, Digito, Saldo, TipoDeConta) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, conta.getId());
            stmt.setInt(2, conta.getPessoaId());
            stmt.setString(3, conta.getNumero());
            stmt.setString(4, conta.getDigito());
            stmt.setDouble(5, conta.getSaldo());
            stmt.setString(6, conta.getTipoConta().toString());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir conta no banco de dados");
        }
    }

    public Pessoa consultarPessoaPorId(int id) {
        String sql = "SELECT * FROM Pessoa WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return new Pessoa(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("telefone"),
                        resultSet.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar pessoa no banco de dados");
        }
        return null;
    }

    public Conta consultarContaPorId(int id) {
        String sql = "SELECT * FROM Conta WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                return new Conta(
                        resultSet.getInt("Id"),
                        resultSet.getInt("PessoaId"),
                        resultSet.getString("Numero"),
                        resultSet.getString("Digito"),
                        resultSet.getDouble("Saldo"),
                        TipoConta.valueOf( resultSet.getString("TipoDeConta")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao consultar a conta no banco de dados");
        }
        return null;
    }
    public void transferenciaEntreContas(int contaOrigemId, int contaDestinoId, double valor){
        Conta contaOrigem = consultarContaPorId(contaOrigemId);
        Conta contaDestino = consultarContaPorId(contaDestinoId);
        final Transferencia transferencia = new Transferencia(111, contaOrigem.getId(), contaDestino.getId(), valor, Date.from(Instant.now()));


        if(!contaOrigem.sacar(transferencia.getValor())) {
            throw new RuntimeException("Voce nao pode transferir");
        }
        contaDestino.depositar(transferencia.getValor());

        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO Transferencia (Id, ContaOrigem, ContaDestino, Valor, DateTransfer) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setInt(1, transferencia.getId());
            stmt.setInt(2, transferencia.getContaOrigem());
            stmt.setInt(3, transferencia.getContaDestino());
            stmt.setDouble(4, transferencia.getValor());
            stmt.setString(5, transferencia.getDate().toString());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir conta no banco de dados");
        }
    }

    public void fecharConexao() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
