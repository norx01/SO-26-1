package consumidorProductor;

public class Productor extends Thread
{
    private final Buffer buffer;

    public Productor(Buffer buffer)
    {
        this.buffer = buffer;
    }

    @Override
    public void run()
    {
        int valor = 1;
        try
        {
            while (true)
            {
                buffer.producir(valor++);
                //Simulamos el tiempo de produccion
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            System.out.println("Productor interrumpido");
        }
    }
}
