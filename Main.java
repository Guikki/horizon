public class Main {
    public static void main(String[] args) {
        BancoDAO banco = new BancoDAO();
        Pessoa pessoa = new Pessoa(111, "Guilherme", "88888888", "111111111");
        Conta conta = new Conta(122, pessoa.getId(), "1111", "1", 100, TipoConta.CORRENTE);
        Conta contaPoupa = new Conta(122, pessoa.getId(), "1122211", "1222", 0, TipoConta.POUPANCA);


        banco.inserirPessoa(pessoa);
        banco.inserirConta(conta);

        final Pessoa pessoaConsultada = banco.consultarPessoaPorId(pessoa.getId());
        System.out.println("Pessoa consultada: " + pessoaConsultada.getNome() + " " + pessoaConsultada.toString());

        banco.transferenciaEntreContas(conta.getId(), contaPoupa.getId(), 1000);
        System.out.println("Transferencia feita com sucesso");

        banco.fecharConexao();
    }
}

enum TipoConta {
    CORRENTE, POUPANCA
}

