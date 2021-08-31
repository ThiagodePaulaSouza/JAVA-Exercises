/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangulo;

/**
 *
 * @author 55159
 */
public class Triangulo extends absPropriedades.absPropriedades
{
    
    public Triangulo(Double l1, Double l2, Double l3)
    {
        super(l1, l2, l3);
        this.Verificar();
    }
    
    private void Verificar()
    {
        this.setMensagem("");
        
        if (this.getL1().equals(this.getL2()) && this.getL2() .equals(this.getL3()))
            this.setMensagem("Equilátero");
        else
            if (!this.getL1().equals(this.getL2()) &&
                    !this.getL2().equals(this.getL3()) &&
                    !this.getL1().equals(this.getL3()))
            {
                this.setMensagem("Escaleno");
            }
            else
                this.setMensagem("Isosceles");
        
                
    }
}
