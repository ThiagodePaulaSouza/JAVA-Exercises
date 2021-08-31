package modelo;

public class Subtracao implements Runnable
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
            Estaticos.subtracao = Estaticos.n1 - Estaticos.n2;
        }
        
    }
    
}
