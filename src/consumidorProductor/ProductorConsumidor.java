package consumidorProductor;

public class ProductorConsumidor
{
    static void main()
    {
        Buffer buffer = new Buffer(5);

        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        productor.start();
        consumidor.start();
    }
}
