package semaforo;

public class Trabajador extends Thread
{
    private final ZonaCritica zona;
    private final String nombre;

    public Trabajador(String nombre, ZonaCritica zona)
    {
        this.nombre = nombre;
        this.zona = zona;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 3; i++)
        {
            zona.acceder(nombre);
            try
            {
                Thread.sleep((int) Math.random()*3000+1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
