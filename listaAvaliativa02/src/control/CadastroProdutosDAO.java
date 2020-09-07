/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import view.TelaCadastro;

/**
 *
 * @author GustavoHenriquePinhe
 */
public class CadastroProdutosDAO {

    private TelaCadastro tc;

    public static void main(String[] args) {
        new CadastroProdutosDAO();
    }

    public CadastroProdutosDAO() {
        tc = new TelaCadastro();
        tc.setVisible(true);
    }
}
