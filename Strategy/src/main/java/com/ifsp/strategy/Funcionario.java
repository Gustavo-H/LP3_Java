package com.ifsp.strategy;

public class Funcionario {

    public static final int CAIXA = 1;
    public static final int GERENTE = 2;
    public static final int REPOSITOR = 3;
    private double salarioBase;
    private CalculaImposto estrategiaDeCalculo;

    public Funcionario(int cargo, double salarioBase) {
        this.salarioBase = salarioBase;
        switch (cargo) {
            case CAIXA:
                estrategiaDeCalculo = new CalculoImpostoQuinzeOuDez();
                cargo = CAIXA;
                break;
            case REPOSITOR:
                estrategiaDeCalculo = new CalculoImpostoQuinzeOuDez();
                cargo = REPOSITOR;
                break;
            case GERENTE:
                estrategiaDeCalculo = new CalculoImpostoVinteOuQuinze();
                cargo = GERENTE;
                break;
            default:
                System.out.println("Cargo nao encontrado!");
        }
    }

    public double calcularSalarioComImposto() {
        return estrategiaDeCalculo.calculaSalarioComImposto(this);
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
