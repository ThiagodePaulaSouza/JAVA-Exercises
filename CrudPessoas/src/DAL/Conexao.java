package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao
{

    public Connection con;
    public String mensagem;

    public Connection conectar()
    {
        this.mensagem = "";
        try
        {
            if (con == null || con.isClosed())
            {
                con = DriverManager.getConnection("jdbc:mysql://mysql873.umbler.com:41890/thiagoestacao", "thiagoestacaobd", "Thiago3213");
            }
        }
        catch (SQLException e)
        {
            this.mensagem = e.getMessage();
        }
        return con;
    }

    public void desconectar()
    {
        try
        {
            if (!con.isClosed())
            {
                con.close();
            }
        }
        catch (SQLException e)
        {
            this.mensagem = "Erro ao fechar conexão com o BD";
        }
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }
}
