package br.com.salao.bean;

import br.com.salao.dao.ClienteDAO;
import br.com.salao.vo.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ClienteBean {
    private Cliente cliente;

    public ClienteBean() {
        this.cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String salvar(){
        new ClienteDAO().salvar(this.cliente);
        return "index.xhtml";
    }
}
