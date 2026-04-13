package consumidorProductor;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer
{
    private final Queue<Integer> cola = new LinkedList<>();
    private  int capacidad = 0;

    public Buffer(int capacidad)
    {
        this.capacidad = capacidad;
    }

    //Metodo para producir un valor en el buffer
    public synchronized void producir(int valor) throws InterruptedException
    {
        while (cola.size() == capacidad)
        {
            //Se espera a que se libere un espacio en el buffer
            wait();
        }
        cola.add(valor);
        System.out.println("Producido: " + valor);
        //Notifica a los consumidores que hay un nuevo valor en el buffer
        notifyAll();
    }

    //Metodo para consumir un valor en el buffer
    public synchronized int consumir() throws InterruptedException
    {
        while (cola.isEmpty())
        {
            //Se espera a que se produzca un valor en el buffer
            wait();
        }
        int valor = cola.poll();
        System.out.println("Consumido: " + valor);
        //Notifica a los productores que fue consumido un valor del buffer
        notifyAll();
        return valor;
    }

}
