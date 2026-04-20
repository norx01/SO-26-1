package semaforo;

import java.util.concurrent.Semaphore;

public class ZonaCritica
{
    private final Semaphore semaforo = new Semaphore(1);

    public void acceder(String nombre)
    {
        try
        {
            System.out.println(nombre + " accede a la zona critica");
            semaforo.acquire();
            System.out.println(nombre + " ha terminado de acceder a la zona critica");

            Thread.sleep((int)(Math.random()*2000)+1000);
            System.out.println(nombre + " sale de la zona critica");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            semaforo.release();
        }
    }
}
