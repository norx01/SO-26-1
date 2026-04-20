package filosofos;

public class Filosofo implements Runnable
{
    private final int id;
    private final Object tenedorIzquierdo;
    private final Object tenedorDerecho;

    public Filosofo(int id, Object tenedorIzquierdo, Object tenedorDerecho) {
        this.id = id;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
    }

    public void pensar() throws InterruptedException {
        System.out.println("Filosofo " + id + " esta pensando...");
        Thread.sleep((int) Math.random() * 3000);
    }

    public void comer() throws InterruptedException {
        System.out.println("Filosofo " + id + " esta comiendo...");
        Thread.sleep((int) Math.random() * 2000);
    }

    @Override
    public void run() {
        try
        {
            while (true) {
                pensar();
                Object primero = (id == 4) ? tenedorDerecho : tenedorIzquierdo;
                Object segundo = (id == 4) ? tenedorIzquierdo : tenedorDerecho;

                synchronized (primero)
                {
                    System.out.println("El Filosofo " + id + " esta tomando su primer tenedor");

                    synchronized (segundo)
                    {
                        System.out.println("El Filosofo " + id + " esta tomando su segundo tenedor");
                        comer();
                        System.out.println("El Filosofo " + id + " ha terminado de comer");
                    }
                }
            }
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
