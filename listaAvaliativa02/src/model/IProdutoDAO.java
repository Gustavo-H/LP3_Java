/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author GustavoHenriquePinhe
 */
public interface IProdutoDAO {

    public List lerProdutos();

    public void create(Produto p);

    public void update(Produto p);

    public void delete(Produto p);
}
