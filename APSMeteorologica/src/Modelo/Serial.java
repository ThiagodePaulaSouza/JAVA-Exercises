package Modelo;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

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
        boolean status = false;
        try
        {
            CommPortIdentifier portId = null;
            Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
            while (portId == null && portEnum.hasMoreElements())
            {
                CommPortIdentifier currentPortId = (CommPortIdentifier) portEnum.nextElement();
                if (currentPortId.getName().equals(serialPortName))
                {
                    serialPort = (SerialPort) currentPortId.open(appName, TIME_OUT);
                    portId = currentPortId;
                    break;
                }
            }
            if (portId == null || serialPort == null)
            {
                return false;
            }
            serialPort.setSerialPortParams(DATA_RATE, serialPort.DATABITS_8,
                    serialPort.STOPBITS_1, serialPort.PARITY_NONE);
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            status = true;
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();//imprime mensagem de erro
                status = false;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();//imprime mensagem de erro
            status = false;
        }
        return status;
    }

    public void sendData(String data)
    {
        //n vai ser utilizado
        try
        {
            output = serialPort.getOutputStream();
            output.write(data.getBytes());//como o serial é uma comunicação binaria tem que ser transformado em bytes
        }
        catch (Exception e)
        {
            System.err.println(e.toString());
        }
    }

    public synchronized void close()//sempre que tiver conexão serial precisa do synchronized
    {
        //fecha porta serial
        serialPort.removeEventListener();
        serialPort.close();
    }

    @Override
    public void serialEvent(SerialPortEvent spe)
    {
        //se tiver alguma coius na porta ele dispara esse kra
        try
        {
            switch (spe.getEventType())
            {
                case SerialPortEvent.DATA_AVAILABLE:
                    if (input == null)
                    {
                        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
                    }
                    if (input.ready())
                    {
                        protocolo.setLeituraComando(input.readLine());
                    }
                    break;
                default:
                    break;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();//imprime mensagem de erro
        }
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
