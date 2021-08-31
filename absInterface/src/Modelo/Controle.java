package Modelo;

public class Controle
{

    
    String mensagem;
    String resposta;
    
    public void calcularCalculadora(String num1, String num2, String operacao)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
    }
    
    public void calcularPrimo(String num)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        this.mensagem = validacao.validarNumeroInteiroPositivo(num);
        if (this.mensagem.equals(""))
        {
            Primo primo = new (validacao.numeroIntPos);
            this.resposta = primo.resposta;
        }
    }

    @Override
    public void Executar()
    {
        this.mensagem = "";
        Validacao validacao = new Validacao(temp);
        if (validacao.mensagem.equals(""))
        {
            Conversao conversao = new Conversao(tipo, validacao.temperatura);
            this.resposta = conversao.resposta;
        } 
        else
        {
            this.mensagem = validacao.mensagem;
        }
    }

    
    
    
}
