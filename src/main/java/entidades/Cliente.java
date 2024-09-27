package entidades;

import banco.Banco;
import banco.Conta;
import banco.Transacao;

import java.util.Random;

public class Cliente extends Thread {
    private String nome;
    private Conta conta;
    private Banco banco;
    private Loja loja1, loja2;

    public Cliente(String nome, Conta conta, Banco banco, Loja loja1, Loja loja2) {
        this.nome = nome;
        this.conta = conta;
        this.banco = banco;
        this.loja1 = loja1;
        this.loja2 = loja2;
    }

    @Override
    public void run() {
        Random random = new Random();
        realizarCompras(loja1, random);
        realizarCompras(loja2, random);
    }

    private void realizarCompras(Loja loja, Random random) {
        for (int i = 0; i < 2; i++) {
            double valorCompra = 200 + random.nextInt(300); // Entre R$ 200 e R$ 500
            Transacao transacao = new Transacao(conta, loja.getConta(), valorCompra);
            transacao.executar(banco);
        }
    }
}