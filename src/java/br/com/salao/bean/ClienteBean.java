package br.com.salao.bean;

import br.com.salao.bo.ClienteBO;
import br.com.salao.dao.ClienteDAO;
import br.com.salao.vo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {

    private Cliente cliente;
    private Cliente clienteSelecionado;
    private List<Cliente> lista;
    private List<Cliente> listaFiltrada;

    public ClienteBean() {
        cliente = new Cliente();
        lista = new ClienteDAO().listarTudo();
        listaFiltrada = new ArrayList<Cliente>();
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> lista) {
        this.lista = lista;
    }

    public List<Cliente> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Cliente> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String salvar() {
        if (cliente.getId() != 0) {
            new ClienteDAO().atualizar(cliente);
        } else {
            new ClienteDAO().salvar(this.cliente);
        }
        return "index.xhtml";
    }

    public List<Cliente> listar() {
        return new ClienteDAO().listarTudo();
        // como seria a consulta para vir ordenado???
        // String sql= " select * from Cliente order by nome asc;"
        // String´[] param = {};
        // return new ClienteDAO().listar(sql,param);
    }
    public List<Cliente> listarClientesOk() {
        
        return ClienteBO.listarClientesOk();
    }

    public void remover() {
        new ClienteDAO().remover(clienteSelecionado);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido com Sucesso", "O cliente " + clienteSelecionado.getNome() + " foi removido.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        lista = new ClienteDAO().listarTudo();
    }

    public String prepararParaAtualizar() {
        cliente = clienteSelecionado;
        return "addCliente.xhtml";
    }


    public String prepararParaMarcar() {
        return "marcarHorario.xhtml";
    }

}

