package entidades;

import banco.Banco;
import banco.Conta;
import banco.Transacao;

public class Loja {
    private String nome;
    private Conta conta;
    private Banco banco;

    public Loja(String nome, Conta conta, Banco banco) {
        this.nome = nome;
        this.conta = conta;
        this.banco = banco;
    }

    public Conta getConta() {
        return conta;
    }

    public synchronized void pagarSalario(Funcionario funcionario) {
        Transacao transacao = new Transacao(conta, funcionario.getContaSalario(), 1400);
        transacao.executar(banco);
    }
}