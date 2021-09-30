package Modelo;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.OutputStream;

public class Serial implements SerialPortEventListener
{

    SerialPort serialPort = null;
    private Protocolo protocolo = new Protocolo();
    private String appName;
    private BufferedReader input; //o serial carrega em cima de um buffer
    private OutputStream output; //a gente carrega nele e dele ele manda pro serial
    private static final int TIME_OUT = 1000;
    private static int DATA_RATE = 9600; //tem que ser iqual ao que ta no arduino - serial = assincrona(envia bits sem referencia) a cada pulso temos um bit, no caso da sincrona pode variar a velocidade, o rs32 é assincrona, o arduino pro pc é bit por segundo

    private String serialPortName = "COM3"; //fazer menu para deixar variavel - COM = emula serial emcima de usb

    
    public boolean iniciaSerial()
    {
        //abre porta serial
        return false; //a ser mudado
    }

    public void sendData()
    {

    }

    public synchronized void close()
    {
        //fecha porta serial
    }

    @Override
    public void serialEvent(SerialPortEvent spe)
    {

    }
    
    
    public SerialPort getSerialPort()
    {
        return serialPort;
    }

    public void setSerialPort(SerialPort serialPort)
    {
        this.serialPort = serialPort;
    }

    public Protocolo getProtocolo()
    {
        return protocolo;
    }

    public void setProtocolo(Protocolo protocolo)
    {
        this.protocolo = protocolo;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public BufferedReader getInput()
    {
        return input;
    }

    public void setInput(BufferedReader input)
    {
        this.input = input;
    }

    public OutputStream getOutput()
    {
        return output;
    }

    public void setOutput(OutputStream output)
    {
        this.output = output;
    }

    public static int getDATA_RATE()
    {
        return DATA_RATE;
    }

    public static void setDATA_RATE(int DATA_RATE)
    {
        Serial.DATA_RATE = DATA_RATE;
    }

    public String getSerialPortName()
    {
        return serialPortName;
    }

    public void setSerialPortName(String serialPortName)
    {
        this.serialPortName = serialPortName;
    }

}
