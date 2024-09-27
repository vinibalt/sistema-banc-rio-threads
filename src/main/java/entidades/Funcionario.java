package entidades;

import banco.Banco;
import banco.Conta;
import banco.Transacao;

public class Funcionario extends Thread {
    private String nome;
    private Conta contaSalario;
    private Conta contaInvestimento;
    private Banco banco;
    private Loja loja;

    public Funcionario(String nome, Conta contaSalario, Conta contaInvestimento, Banco banco, Loja loja) {
        this.nome = nome;
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
        this.banco = banco;
        this.loja = loja;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (loja) {
                if (contaSalario.getSaldo() >= 1400) {
                    loja.pagarSalario(this);
                    investir();
                    break;
                }
            }
        }
    }

    private void investir() {
        double valorInvestimento = contaSalario.getSaldo() * 0.20;
        Transacao transacao = new Transacao(contaSalario, contaInvestimento, valorInvestimento);
        transacao.executar(banco);
        System.out.println(nome + " investiu R$ " + valorInvestimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public void setContaSalario(Conta contaSalario) {
        this.contaSalario = contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }

    public void setContaInvestimento(Conta contaInvestimento) {
        this.contaInvestimento = contaInvestimento;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
}