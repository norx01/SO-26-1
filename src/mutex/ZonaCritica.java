package mutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ZonaCritica
{
    private  int recursoCompartido = 0;
    private final Lock mutex = new ReentrantLock();

    public void acceder(String nombre)
    {
        System.out.println(nombre + " intenta acceder a la zona critica");
        mutex.lock();

        try
        {
            System.out.println(nombre + " ha accedido a la zona critica");
            recursoCompartido++;
            System.out.println("Recurso actualizado: " + recursoCompartido);

            //Simulamos trabajo
            Thread.sleep((int)(Math.random()*2000)+1000);
            System.out.println(nombre + " ha terminado de acceder a la zona critica");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            mutex.unlock();
        }
    }
}
