package Modelo;

public class Validacao
{

    private String mensagem;
    private Double numero1;
    private Double numero2;
    protected 
    

    public String validarNumero(String num)
    {
        this.mensagem = "";
        try
        {
            this.numero = Double.parseDouble(num);
        } 
        catch (Exception e)
        {
           this.mensagem = "Número inválido"; 
        }
    }
    
    public String validarDoisNumeros(String num1, String num2)
    {
        this.mensagem = "";
        this.mensagem = validarNumero(num1);
        this.mensagem += validarNumero(num2);
        return mensagem;
    }
    
}
