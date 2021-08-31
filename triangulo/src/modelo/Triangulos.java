package modelo;

public class Triangulos extends absPropriedades
{
    
    public Triangulos(Double l1, Double l2, Double l3)
    {
        super(l1, l2, l3);
    }
    
    private void Verificar()
    {
        if (this.getL1().equals(this.getL2()) && this.getL2() .equals(this.getL3()))
            this.setResposta("Equiláterio");
        else
            if (!this.getL1().equals(this.getL2()) &&
                    !this.getL2().equals(this.getL3()) &&
                    !this.getL1().equals(this.getL3()))
            {
                this.setResposta("Escaleno");
            }
            else
                this.setMensagem("Isosceles");
                
    }
}
