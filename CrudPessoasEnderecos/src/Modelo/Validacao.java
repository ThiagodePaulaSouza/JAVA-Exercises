package Modelo;

import java.util.List;

public class Validacao
{

    private String mensagem;
    private Integer id;

    public void validarDadosPessoa(List<String> dadosPessoa)
    {
        this.mensagem = "";
        this.validarIDPessoa(dadosPessoa.get(0));
        this.validarNomePessoa(dadosPessoa.get(1));

        if (dadosPessoa.get(1).length() < 3
                || dadosPessoa.get(1).length() > 50) //NOME
        {
            this.mensagem += "Nome deve ter de 3 a 50 caracteres\n";
        }
        if (dadosPessoa.get(2).length() < 9) //RG
        {
            this.mensagem += "RG inválido\n";
        }
        if (dadosPessoa.get(3).length() < 11) //CPF
        {
            this.mensagem += "CPF inválido\n";
        }

    }

    public void validarIDPessoa(String numeroId)
    {
        this.mensagem = "";
        try
        {
            this.id = Integer.parseInt(numeroId); //ID
        }
        catch (Exception e)
        {
            this.mensagem += "ID inválido \n";
        }
    }

    public void validarNomePessoa(String nome)
    {
        this.mensagem = "";
        if (nome.length() < 3
                || nome.length() > 50) //NOME
        {
            this.mensagem += "Nome deve ter de 3 a 50 caracteres\n";
        }

    }

    public void validarEndereco(List<String> listaStringEndereco)
    {
        this.mensagem = "";
        if (listaStringEndereco.get(0).length() > 30)
            this.mensagem = "Logradouro com mais de 30 caracteres \n";
        if (listaStringEndereco.get(1).length() > 10)
            this.mensagem += "Número com mais de 10 caracteres \n";
        if (listaStringEndereco.get(2).length() > 30)
            this.mensagem += "Bairro com mais de 30 caracteres \n";
        if (listaStringEndereco.get(3).length() > 30)
            this.mensagem += "Cidade com mais de 30 caracteres \n";
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }

    public Integer getId()
    {
        return id;
    }

}
