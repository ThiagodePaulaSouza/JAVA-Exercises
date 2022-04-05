package apsmeteorologica;

import Apresentação.frmPrincipal;
import Modelo.Serial;

public class APSMeteorologica
{
    public static void main(String[] args)
    {
        // TODO code application logic here
        Serial serial = new Serial();
        
        if (serial.iniciaSerial())
        {
            frmPrincipal frmP = new frmPrincipal(null, true);
            frmP.setVisible(true);
        }
        
        serial.close();
        System.exit(0);
    }
    
}
