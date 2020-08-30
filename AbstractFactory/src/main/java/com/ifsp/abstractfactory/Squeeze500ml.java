package com.ifsp.abstractfactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GustavoHenriquePinhe
 */
public class Squeeze500ml implements SqueezeTermica{

    @Override
    public void exibirInfoTermica() {
        System.out.println("Modelo: Squeeze 500ml\nFábrica: Sports\nCategoria: Termica");
    }    
}
