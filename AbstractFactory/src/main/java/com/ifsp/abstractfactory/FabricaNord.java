package com.ifsp.abstractfactory;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gustavo
 */
public class FabricaNord implements FabricaDeSqueeze {

    @Override
    public SqueezeTermica criarSqueezeTermica() {
        return new Squeeze1L();
    }

    @Override
    public SqueezeComum criarSqueezeComum() {
        return new Squeeze800ml();
    }    
}