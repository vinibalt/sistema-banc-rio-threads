package main;

import banco.Banco;
import banco.Conta;
import entidades.Cliente;
import entidades.Funcionario;
import entidades.Loja;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();


        Loja loja1 = new Loja("Loja 1", new Conta("Loja 1", 0), banco);
        Loja loja2 = new Loja("Loja 2", new Conta("Loja 2", 0), banco);


        Funcionario func1 = new Funcionario("Func 1", new Conta("Salario 1", 0), new Conta("Investimento 1", 0), banco, loja1);
        Funcionario func2 = new Funcionario("Func 2", new Conta("Salario 2", 0), new Conta("Investimento 2", 0), banco, loja1);
        Funcionario func3 = new Funcionario("Func 3", new Conta("Salario 3", 0), new Conta("Investimento 3", 0), banco, loja2);
        Funcionario func4 = new Funcionario("Func 4", new Conta("Salario 4", 0), new Conta("Investimento 4", 0), banco, loja2);


        Cliente[] clientes = new Cliente[10];
        for (int i = 0; i < 10; i++) {
            clientes[i] = new Cliente("Cliente " + (i + 1), new Conta("Conta Cliente " + (i + 1), 2000), banco, loja1, loja2);
        }


        func1.start();
        func2.start();
        func3.start();
        func4.start();

        for (Cliente cliente : clientes) {
            cliente.start();
        }
    }
}