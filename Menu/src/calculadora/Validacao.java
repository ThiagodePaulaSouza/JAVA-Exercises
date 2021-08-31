package calculadora;

public class Validacao extends absPropriedades.absPropriedades
{
    public Validacao(String num1, String num2, String operacao)
    {
        super(num1, num2, operacao);
        this.validar();
    }
    
    private void validar()
    {
        this.setMensagem("");
        try
        {
            this.setNumero1(Double.parseDouble(this.getNum1()));
            this.setNumero2(Double.parseDouble(this.getNum2()));
            if(this.getOperacao().equals("/"))
                if(this.getNumero1().equals(0.0) || this.getNumero2().equals(0.0))
                    this.setMensagem("Impossivel Dividir por zero");
                
        } 
        catch (Exception e)
        {
            this.setMensagem("erro de conversão");
        }
    }    
}
