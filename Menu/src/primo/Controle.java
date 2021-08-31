package primo;

public class Controle extends absPropriedades.absPropriedades
{

    public Controle(String numero)
    {
        super(numero);
        this.Executar();
    }

    private void Executar()
    {
        this.setMensagem("");
        Validacao validacao = new Validacao(this.getNumero());
        if (validacao.getMensagem().equals(""))
        {
            Primo primo = new Primo(validacao.getNum());
            this.setMensagem(primo.getMensagem());
        }
        else
        {
            this.setMensagem(validacao.getMensagem());
        }
        
    }
}
