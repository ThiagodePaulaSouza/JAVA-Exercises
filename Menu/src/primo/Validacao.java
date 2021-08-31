package primo;

public class Validacao extends absPropriedades.absPropriedades
{

    public Validacao(String numero)
    {
        super(numero);
        this.ValidarNumero();
    }

    
    
    private void ValidarNumero()
    {
        this.setMensagem("");
        try
        {
            this.setNum(Integer.parseInt(this.getNumero()));
            if (this.getNum() < 0 )
                this.setMensagem("Digite apenas números positivos");
        } 
        catch (Exception e)
        {
            this.setMensagem("Número Inválido");
        }
    }
}

