package circunferencia;

import java.util.Scanner;

public class Circunferencia
{
    public static void main(String[] args)
    {
        //Declaração
        int raio, area;
        
        //Entrada
        System.out.println("\nDigite o numero do raio: ");
        
        Scanner input = new Scanner(System.in);
        raio = input.nextInt();
        
        //Processo
        raio = (int) Math.pow(raio, 2);
        area = (int) (Math.PI * raio);
        
        //Resultado
        System.out.println("a Area da Circunferencia é: " + area);
    }
    
}
