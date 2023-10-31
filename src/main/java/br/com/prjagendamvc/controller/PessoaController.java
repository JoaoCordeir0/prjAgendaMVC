package br.com.prjagendamvc.controller;

import br.com.prjagendamvc.model.ListaContatos;
import br.com.prjagendamvc.model.Pessoa;

/**
 *
 * @author Cordeiro
 */
public class PessoaController 
{
    // Adiciona um novo contato
    public boolean adicionaContato(String nome, String telefone, String email)
    {                      
        Pessoa pessoa = new Pessoa(getUltimoID(), nome, email, telefone);
        
        return ListaContatos.getInstance().add(pessoa);
    }
            
    // Recupera o ultimo id (Simula auto incremento)
    public int getUltimoID()
    {
        if (!ListaContatos.getInstance().isEmpty())
        {                                    
            return ListaContatos.getInstance().get(ListaContatos.getInstance().size() - 1).getId() + 1;
        }        
        return 0;
    }
}
