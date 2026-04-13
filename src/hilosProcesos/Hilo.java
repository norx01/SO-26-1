package hilosProcesos;

public class Hilo
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread t = new Thread(()  -> {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("Hola desde el hilo "+ Thread.currentThread().getName());
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }, "worker-1");
        t.start();
        System.out.println("Soy el hilo principal");
        t.join();
    }
}
