# Sistema Bancário Multithread em Java

## Descrição

Este projeto implementa um **sistema bancário multithread** utilizando **Java 17**. O sistema foi desenvolvido para gerenciar transações entre clientes, lojas, funcionários e um banco, garantindo a **consistência dos saldos das contas** por meio de transações coordenadas. 

As transações são realizadas de forma **síncrona e segura**, aproveitando o uso de **threads** para clientes e funcionários, de modo que as operações ocorrem simultaneamente, mas mantendo a consistência financeira.

## Funcionalidades

- **Clientes**:
  - Cada cliente possui uma conta com saldo inicial de R$ 2.000,00.
  - Realizam compras em duas lojas, com valores aleatórios entre R$ 200,00 e R$ 500,00.
  - São representados por **threads**, garantindo que múltiplas transações aconteçam simultaneamente.

- **Lojas**:
  - Recebem os pagamentos das compras feitas pelos clientes.
  - São responsáveis por pagar os salários dos funcionários, no valor de R$ 1.400,00, quando o saldo da loja permitir.

- **Funcionários**:
  - Cada funcionário possui duas contas: uma para salário e outra para investimentos.
  - Ao receber o salário, investem 20% do valor em sua conta de investimentos.
  - São representados por **threads**, simulando a execução de múltiplas operações em paralelo.

- **Banco**:
  - Atua como intermediário nas transações, garantindo que o saldo das contas seja atualizado de maneira **síncrona e segura**.
  - Todas as operações de saque e depósito são realizadas via o banco, que usa mecanismos de **locks** para prevenir inconsistências.

## Estrutura do Sistema

O sistema é composto pelas seguintes classes principais:

- **Banco**: Intermedia as transações entre as contas de clientes, lojas e funcionários.
- **Conta**: Representa uma conta bancária que permite depósitos e saques de maneira segura.
- **Cliente**: Realiza compras em duas lojas. Cada cliente é uma thread independente.
- **Loja**: Recebe pagamentos de clientes e paga salários aos funcionários quando o saldo permite.
- **Funcionario**: Recebe salário e investe uma parte desse salário. Cada funcionário também é uma thread.
- **Transacao**: Implementa as transferências de valores entre contas de forma controlada e sincronizada.

## Estrutura de Pastas

```
src/main/java
│
├── banco/
│   ├── Banco.java            # Classe que gerencia as transações
│   ├── Conta.java            # Classe que representa uma conta bancária
│   └── Transacao.java        # (Opcional) Classe para modelar transações
│
├── entidades/
│   ├── Cliente.java          # Representa os clientes (threads)
│   ├── Funcionario.java      # Representa os funcionários (threads)
│   └── Loja.java             # Representa as lojas
│
└── main/
    └── Main.java             # Classe principal que inicializa o sistema
```

## Execução

1. Clone este repositório:
   ```bash
   git clone https://github.com/usuario/projeto-sistema-bancario.git
   ```
   
2. Compile o projeto utilizando seu ambiente de desenvolvimento Java, como o IntelliJ ou o Eclipse, ou use o seguinte comando no terminal:
   ```bash
   javac src/main/java/main/Main.java
   ```

3. Execute o sistema:
   ```bash
   java src/main/java/main/Main
   ```

## Funcionamento

1. O sistema cria um banco e inicializa as entidades: 1 banco, 2 lojas, 4 funcionários e 10 clientes.
2. Os clientes realizam 4 compras cada um (2 em cada loja), com valores aleatórios entre R$ 200 e R$ 500.
3. As lojas acumulam dinheiro e, quando o saldo permitir, pagam os salários de seus funcionários.
4. Os funcionários, ao receberem os salários, investem 20% do valor automaticamente.
5. O banco sincroniza todas as transações para garantir que não haja inconsistências.

## Exemplo de Saída

```
Transferência de 350.0 realizada de Conta Cliente 1 para Loja 1
Transferência de 200.0 realizada de Conta Cliente 1 para Loja 2
Saldo insuficiente na conta Salario 2
Transferência de 280.0 realizada de Conta Cliente 2 para Loja 1
...
Cliente 1 investiu R$ 280,00
Saldo final da Loja 1: R$ X
Saldo final do Cliente 1: R$ Y
...
```

## Tecnologias Utilizadas

- **Java 17**
- **Programação Concorrente** (Threads)
- **Locks** para sincronização das transações

## Critérios de Avaliação

- **Entidades corretas**: Banco, Loja, Cliente, Funcionário e Conta.
- **Funcionalidades completas**: Compras de clientes, pagamento de salários e investimentos.
- **Consistência nas transações**: Garantia de que todas as transações sejam realizadas sem inconsistências.
- **Organização do código**: Estrutura em pacotes, métodos e modularização apropriada.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

