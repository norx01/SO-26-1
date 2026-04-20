package semaforo;

public class Main
{
    static void main()
    {
        ZonaCritica zona = new ZonaCritica();

        Trabajador t1 = new Trabajador("T1", zona);
        Trabajador t2 = new Trabajador("T2", zona);
        Trabajador t3 = new Trabajador("T3", zona);

        t1.start();
        t2.start();
        t3.start();
    }
}
