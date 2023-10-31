package br.com.prjagendamvc.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cordeiro
 */
public class ListaContatos
{ 
    private static List<Pessoa> pessoa;
    
    private ListaContatos(){}
    
    public static List<Pessoa> getInstance()
    {
        if (pessoa == null) 
        {
            pessoa = new ArrayList();
        }
        return pessoa;
    }
}
