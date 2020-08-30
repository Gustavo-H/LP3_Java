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
public class Squeeze800ml implements SqueezeComum{
    @Override
    public void exibirInfoComum() {
        System.out.println("Modelo: Squeeze 800ml\nFábrica: Nord\nCategoria: Comum");
    } 
}
