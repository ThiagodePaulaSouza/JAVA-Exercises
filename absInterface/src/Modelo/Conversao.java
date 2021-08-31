package Modelo;

import java.text.DecimalFormat;

public class Conversao extends absPropriedades
{

    public Conversao(String tipo, Double temperatura)
    {
        super(tipo, temperatura);
    }
    

    
    @Override
    public void validarNumero()
    {
        DecimalFormat df = new DecimalFormat("0.##");
        
        if (this.tipo.equals("CF"))
        {
            this.resposta = df.format((this.temperatura - 32) / 1.8);
        } 
        else
        {
            this.resposta = df.format(this.temperatura * 1.8 + 32);
        }
    }
    
}
