package abstracFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GustavoHenriquePinhe
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FabricaDeSqueeze fabrica = new FabricaSports();
        SqueezeComum comum = fabrica.criarSqueezeComum();
        SqueezeTermica termica = fabrica.criarSqueezeTermica();
        comum.exibirInfoComum();
        System.out.println("\n");
        termica.exibirInfoTermica();
        System.out.println("\n");
        
        System.out.println("FIm");
    }
    
}
