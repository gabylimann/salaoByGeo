
package br.com.salao.bean;

import br.com.salao.dao.ServicoDAO;
import br.com.salao.vo.Servico;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ServicoBean {
    private Servico servico;

    public ServicoBean() {
        this.servico = new Servico();
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    public String salvar(){
        new ServicoDAO().salvar(this.servico);
        return "sidemenu.xhtml";
    }
}
