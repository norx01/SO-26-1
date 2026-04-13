package filosofos;

public class Mesa
{
    static void main()
    {
        Object[] tenedores = new Object[5];

        for (int i = 0; i < tenedores.length; i++)
        {
            tenedores[i] = new Object();
        }

        for (int i = 0; i < 5; i++)
        {
            Object tenedorIzquierdo = tenedores[i];
            Object tenedorDerecho = tenedores[(i + 1) % tenedores.length];

            Filosofo filosofo = new Filosofo(i, tenedorIzquierdo, tenedorDerecho);
            Thread t = new Thread(filosofo, "Filosofo " + i);
            t.start();
        }
    }
}
