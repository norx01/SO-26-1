package mutex;

public class Trabajador extends Thread
{
    private final ZonaCritica zona;
    private final String nombre;

    public Trabajador(ZonaCritica zona, String nombre) {
        this.zona = zona;
        this.nombre = nombre;
    }
    @Override
    public void run()
    {
        for (int i=0; i < 3; i++)
        {
            zona.acceder(nombre);
            try
            {
               Thread.sleep((int)(Math.random()*3000)+1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
