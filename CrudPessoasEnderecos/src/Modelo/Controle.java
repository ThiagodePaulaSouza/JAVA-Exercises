package Modelo;

import DAL.PessoaDAO;
import java.util.ArrayList;
import java.util.List;

public class Controle
{

    private String mensagem;

    public void cadastrarPessoa(List<String> dadosPessoa, List<List<String>> listaStringEnderecos)
    {

        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarDadosPessoa(dadosPessoa);

        for (List<String> listaEnd : listaStringEnderecos)
        {
            validacao.validarEndereco(listaEnd);
        }

        if (validacao.getMensagem().equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(validacao.getId());
            pessoa.setNome(dadosPessoa.get(1));
            pessoa.setRg(dadosPessoa.get(2));
            pessoa.setCpf(dadosPessoa.get(3));

            List<Endereco> listaEnderecos = new ArrayList<>();
            for (List<String> listaE : listaStringEnderecos)
            {
                Endereco end = new Endereco();
                end.setLogradouro(listaE.get(0));
                end.setNumero(listaE.get(1));
                end.setBairro(listaE.get(2));
                end.setCidade(listaE.get(3));
                listaEnderecos.add(end);
            }

            pessoa.setListaEnderecos(listaEnderecos);

            PessoaDAO pessoaDao = new PessoaDAO();
            pessoaDao.cadastrarPessoa(pessoa);
            this.mensagem = pessoaDao.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
    }

    public void editarPessoa(List<String> dadosPessoa)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarDadosPessoa(dadosPessoa);
        if (validacao.getMensagem().equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(validacao.getId());
            pessoa.setNome(dadosPessoa.get(1));
            pessoa.setRg(dadosPessoa.get(2));
            pessoa.setCpf(dadosPessoa.get(3));

            PessoaDAO pessoaDao = new PessoaDAO();
            pessoaDao.editarPessoa(pessoa);
            this.mensagem = pessoaDao.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
    }

    public void excluirPessoa(String numeroId)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarIDPessoa(numeroId);
        Pessoa pessoa = new Pessoa();
        if (validacao.getMensagem().equals(""))
        {
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoa.setId(validacao.getId());
            pessoaDAO.excluirPessoa(pessoa);
            this.mensagem = pessoaDAO.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
    }

    public Pessoa pesquisarPessoaPorId(String numeroId)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarIDPessoa(numeroId);
        Pessoa pessoa = new Pessoa();
        if (validacao.getMensagem().equals(""))
        {
            pessoa.setId(validacao.getId());
            PessoaDAO pessoaDAO = new PessoaDAO();
            pessoa = pessoaDAO.pesquisarPessoaPorId(pessoa);
            this.mensagem = pessoaDAO.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
        return pessoa;
    }

    public List<Pessoa> pesquisarPessoaPorNome(String nome)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarNomePessoa(nome);
        Pessoa pessoa = new Pessoa();
        List<Pessoa> listaPessoas = new ArrayList<>();
        if (validacao.getMensagem().equals(""))
        {
            pessoa.setNome(nome);
            PessoaDAO pessoaDAO = new PessoaDAO();
            listaPessoas = pessoaDAO.pesquisarPessoaPorNome(pessoa);
            this.mensagem = pessoaDAO.getMensagem();
        }
        else
        {
            this.mensagem = validacao.getMensagem();
        }
        return listaPessoas;
    }

    public String getMensagem()
    {
        return mensagem;
    }
}
