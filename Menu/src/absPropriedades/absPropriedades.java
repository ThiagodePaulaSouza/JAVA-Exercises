package absPropriedades;

public class absPropriedades
{
    private int num;
    
    private Double numero1;
    private Double numero2;
    private Double l1;
    private Double l2;
    private Double l3;
    
    private String operacao;    
    private String numero;
    private String mensagem;
    private String resposta;
    private String num1;
    private String num2;
    private String lado1;
    private String lado2;
    private String lado3;

    

    //construtor
    

    public absPropriedades(Double numero1, Double numero2, String operacao, String resposta)
    {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacao = operacao;
        this.resposta = resposta;
    }

    public absPropriedades(Double l1, Double l2, Double l3)
    {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    public absPropriedades(String lado1, String lado2, String lado3)
    {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    
    
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

    public String getLado1()
    {
        return lado1;
    }

    public void setLado1(String lado1)
    {
        this.lado1 = lado1;
    }

    public String getLado2()
    {
        return lado2;
    }

    public void setLado2(String lado2)
    {
        this.lado2 = lado2;
    }

    public String getLado3()
    {
        return lado3;
    }

    public void setLado3(String lado3)
    {
        this.lado3 = lado3;
    }

    public Double getL1()
    {
        return l1;
    }

    public void setL1(Double l1)
    {
        this.l1 = l1;
    }

    public Double getL2()
    {
        return l2;
    }

    public void setL2(Double l2)
    {
        this.l2 = l2;
    }

    public Double getL3()
    {
        return l3;
    }

    public void setL3(Double l3)
    {
        this.l3 = l3;
    }

    public String getResposta()
    {
        return resposta;
    }

    public void setResposta(String resposta)
    {
        this.resposta = resposta;
    }

    public Double getNumero1()
    {
        return numero1;
    }

    public void setNumero1(Double numero1)
    {
        this.numero1 = numero1;
    }

    public Double getNumero2()
    {
        return numero2;
    }

    public void setNumero2(Double numero2)
    {
        this.numero2 = numero2;
    }

    public String getOperacao()
    {
        return operacao;
    }

    public void setOperacao(String operacao)
    {
        this.operacao = operacao;
    }

    public String getNum1()
    {
        return num1;
    }

    public void setNum1(String num1)
    {
        this.num1 = num1;
    }

    public String getNum2()
    {
        return num2;
    }

    public void setNum2(String num2)
    {
        this.num2 = num2;
    }
}
