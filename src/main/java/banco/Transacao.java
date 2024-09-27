package banco;

public class Transacao {
    private Conta origem;
    private Conta destino;
    private double valor;

    public Transacao(Conta origem, Conta destino, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    public void executar(Banco banco) {
        banco.transferir(origem, destino, valor);
        System.out.println("Transação: R$" + valor + " de " + origem.getId() + " para " + destino.getId());
    }

    public Conta getOrigem() {
        return origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public double getValor() {
        return valor;
    }
}