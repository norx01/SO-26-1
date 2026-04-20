package mutex;

public class Main
{
    static void main()
    {
        ZonaCritica zona = new ZonaCritica();

        Trabajador t1 = new Trabajador(zona,"T1");
        Trabajador t2 = new Trabajador(zona,"T2");
        Trabajador t3 = new Trabajador(zona,"T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
