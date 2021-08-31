package modelo;

public class Soma implements Runnable
{

    @Override
    public void run()
    {
        executar();
    }
    
    public void executar()
    {
        while (true)
        {            
            Estaticos.soma = Estaticos.n1 + Estaticos.n2;
        }
        
    }
    
}
