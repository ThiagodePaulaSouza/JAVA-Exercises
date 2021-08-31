package Modelo;

import java.text.DecimalFormat;

public class Calcular extends absPropriedades
{

    public Calcular(Double numero1, Double numero2, String operacao)
    {
        super(numero1, numero2, operacao);
    }
    
    

    @Override
    public void validarNumero()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        
        if (operacao.equals("+"))
            this.resposta = df.format(numero1 + numero2);
        if (operacao.equals("-"))
            this.resposta = df.format(numero1 - numero2);
        if (operacao.equals("*"))
            this.resposta = df.format(numero1 * numero2);
        if (operacao.equals("/"))
            this.resposta = df.format(numero1 / numero2);
    }
}