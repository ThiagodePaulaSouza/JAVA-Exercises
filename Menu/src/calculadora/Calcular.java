package calculadora;

import java.text.DecimalFormat;

public class Calcular extends absPropriedades.absPropriedades
{
    
    public Calcular(Double numero1, Double numero2, String operacao, String resposta)
    {
        super(numero1, numero2, operacao, resposta);
        this.resolver();
    }
    
    
    
    private void resolver()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        
        if (this.getOperacao().equals("+"))
            this.setResposta(df.format(this.getNumero1() + this.getNumero2()));
        
        if (this.getOperacao().equals("-"))
            this.setResposta(df.format(this.getNumero1() - this.getNumero2()));
        
        if (this.getOperacao().equals("*"))
            this.setResposta(df.format(this.getNumero1() * this.getNumero2()));
        
        if (this.getOperacao().equals("/"))
            this.setResposta(df.format(this.getNumero1() / this.getNumero2()));
    }
}