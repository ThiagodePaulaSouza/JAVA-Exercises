package primo;


public class Primo extends absPropriedades.absPropriedades
{

    public Primo(int num)
    {
        super(num);
        this.VerificarPrimo();
    }

    
    
    private void VerificarPrimo()
    {
        this.setMensagem("É primo");
        for (int i = 2; i < this.getNum() / 2 + 1; i++)
        {
            if (this.getNum() % i == 0)
            {
                this.setMensagem("Não é Primo");
                break;
            }
        }
            
    }
    
}
