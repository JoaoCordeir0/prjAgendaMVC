package br.com.prjagendamvc.controller;

import br.com.prjagendamvc.model.ListaContatos;
import br.com.prjagendamvc.model.Pessoa;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cordeiro
 */
public class PessoaController 
{
    // Adiciona um novo contato
    public boolean adicionaContato(String nome, String celular, String email)
    {                      
        Pessoa pessoa = new Pessoa(getUltimoID(), nome, celular, email);
        return ListaContatos.getInstance().add(pessoa);
    }
            
    // Lista os contatos na tabela
    public void listaContatos(JTable tableContatos)
    {
        DefaultTableModel tbl = (DefaultTableModel) tableContatos.getModel();
        
        tbl.setRowCount(ListaContatos.getInstance().size());
        tableContatos.setModel(tbl);               
        
        for (int c = 0; c < ListaContatos.getInstance().size(); c++)
        {
            tableContatos.setValueAt(ListaContatos.getInstance().get(c).getId(), c, 0);
            tableContatos.setValueAt(ListaContatos.getInstance().get(c).getNome(), c, 1);
            tableContatos.setValueAt(ListaContatos.getInstance().get(c).getCelular(), c, 2);
            tableContatos.setValueAt(ListaContatos.getInstance().get(c).getEmail(), c,3);
        }      
    }
    
    // Exclui um contato
    public void excluiContato(JTable tableContatos)
    {    
        ListaContatos.getInstance().remove(tableContatos.getSelectedRow()); 
        listaContatos(tableContatos);
    }   
    
    // Busca contato pelo ID
    public int buscaContato(int id)
    {
        int pos = -1;
        for (int c = 0; c < ListaContatos.getInstance().size(); c++)
        {
            if (ListaContatos.getInstance().get(c).getId() == id){
                pos = c;
            }
        }      
        return pos;   
    }
    
    // Atualiza um contato
    public boolean atualizaContato(int id, String nome, String celular, String email)
    {
        int index = buscaContato(id);
        
        try 
        {
            ListaContatos.getInstance().get(index).setNome(nome);
            ListaContatos.getInstance().get(index).setCelular(celular);
            ListaContatos.getInstance().get(index).setEmail(email);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    // Recupera o ultimo id (Simula auto incremento)
    public int getUltimoID()
    {
        if (!ListaContatos.getInstance().isEmpty())
        {                                    
            return ListaContatos.getInstance().get(ListaContatos.getInstance().size() - 1).getId() + 1;
        }        
        return 1;
    }
    
    public static boolean validaEmail(String email)
    {
       String expression = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
       
       Pattern pattern = Pattern.compile(expression);
       Matcher matcher = pattern.matcher(email);
       
       return matcher.matches();
    }     
}
