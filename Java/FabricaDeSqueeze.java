package abstracFactory;


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
public interface FabricaDeSqueeze {
    SqueezeTermica criarSqueezeTermica();
    SqueezeComum criarSqueezeComum();
}
