package Modelo;

public abstract class absPropriedades implements intMetodos
{
    protected String mensagem;
    protected String tipo;
    protected String temp;
    protected Double temperatura;
    protected String resposta;
    protected Double numero1;
    protected Double numero2;
    protected String operacao;

    public absPropriedades(Double numero1, Double numero2, String operacao)
    {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacao = operacao;
        validarNumero();
    }

    
    
    
    
    public absPropriedades(String tipo, Double temperatura)
    {
        this.tipo = tipo;
        this.temperatura = temperatura;
        validarNumero();
    }

    public absPropriedades(String tipo, String temp)
    {
        this.tipo = tipo;
        this.temp = temp;
        validarNumero();
    }

    public absPropriedades(String temp)
    {
        this.temp = temp;
        validarNumero();
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public String getResposta()
    {
        return resposta;
    }

    public void setResposta(String resposta)
    {
        this.resposta = resposta;
    }
    
    
    

    
    
    
}
