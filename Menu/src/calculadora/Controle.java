package calculadora;

public class Controle extends absPropriedades.absPropriedades
{
    public Controle(String num1, String num2, String operacao)
    {
        super(num1, num2, operacao);
        this.executar();
    }
    
    private void executar()
    {
        this.setMensagem("");
        Validacao validacao = new Validacao(this.getNum1(), this.getNum2(), this.getOperacao());
        if(validacao.getMensagem().equals(""))
        {
            Calcular calcular = new Calcular(validacao.getNumero1(), validacao.getNumero2(), validacao.getOperacao(), validacao.getResposta());
            this.setResposta(calcular.getResposta());
            
        }
        else
        {
            this.setMensagem(validacao.getMensagem());
        }
    }
}
