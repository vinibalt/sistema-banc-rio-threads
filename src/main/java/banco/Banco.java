package banco;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private Lock lock = new ReentrantLock();

    public void transferir(Conta origem, Conta destino, double valor) {
        lock.lock();
        try {
            if (origem.sacar(valor)) {
                destino.depositar(valor);
                System.out.println("Transferência de " + valor + " realizada de " + origem.getId() + " para " + destino.getId());
            } else {
                System.out.println("Saldo insuficiente na conta " + origem.getId());
            }
        } finally {
            lock.unlock();
        }
    }
}
