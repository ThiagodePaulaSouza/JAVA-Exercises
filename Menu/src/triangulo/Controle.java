package triangulo;

public class Controle extends absPropriedades.absPropriedades
{
    
    public Controle(String lado1, String lado2, String lado3)
    {
        super(lado1, lado2, lado3);
        this.Verificar();
    }
    
    private void Verificar()
    {
        this.setMensagem("");
        Validacao validacao = new Validacao(this.getLado1(), this.getLado2(), this.getLado3());
        if (validacao.getMensagem().equals(""))
        {
            Triangulo triangulo = new Triangulo(validacao.getL1(), validacao.getL2(), validacao.getL3());
            this.setMensagem(triangulo.getMensagem());
        } 
        else
        {
            this.setMensagem(validacao.getMensagem());

        }
    }
}
