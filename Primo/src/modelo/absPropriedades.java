package modelo;

public abstract class absPropriedades
{
    private String numero;
    private int num;
    private String mensagem;

    //construtor
    public absPropriedades(String numero)
    {
        this.numero = numero;
    }

    public absPropriedades(int num)
    {
        this.num = num;
    }

    //getter e setter
    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public int getNum()
    {
        return num;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }
    
    
    
}
