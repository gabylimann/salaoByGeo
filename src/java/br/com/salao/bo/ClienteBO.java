/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.bo;

/**
 *
 * @author Gabs
 */
import br.com.salao.dao.ClienteDAO;
import br.com.salao.vo.Cliente;
import java.util.List;

public class ClienteBO {
    public static List<Cliente> listarClientesOk (){
        List<Cliente> lista;
        ClienteDAO dao = new ClienteDAO();
        String sql = "Select * from cliente where situacao = 'ok'";
        String valor [] = {};
        lista = dao.listar(sql, valor);
        return lista;
    }
}
