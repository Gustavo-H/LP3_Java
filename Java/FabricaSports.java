package abstracFactory;


import abstracFactory.Squeeze500ml;
import abstracFactory.Squeeze750ml;
import abstracFactory.SqueezeComum;
import abstracFactory.SqueezeTermica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GustavoHenriquePinhe
 */
public class FabricaSports implements FabricaDeSqueeze{

    @Override
    public SqueezeTermica criarSqueezeTermica() {
        return new Squeeze500ml();
    }

    @Override
    public SqueezeComum criarSqueezeComum() {
        return new Squeeze750ml();
    }    
}
