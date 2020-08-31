import com.ifsp.strategy.Funcionario;

/*
Em uma determinada empresa as regras de cálculo de imposto sao diferentes para 
cada categoria de funcionario uma determinada porcentagem do salário deve ser descontada 
de acordo com o salário base do funcionário. Vamos as regras:

Caixa tem um imposto de 15% se o seu salário for maior que R$ 2000,00 e 10% caso contrário;
Gerente tem um imposto de 20% se o seu salário for maior que R$ 3500,00 e 15% caso contrário;
Repositor tem um imposto de 15% se o seu salário for maior que R$ 2000,00 e 10% caso contrário;

Este Sistema resolve este problema.
*/

public class Main {

    public static void main(String[] args) {
        Funcionario umFuncionario = new Funcionario(Funcionario.CAIXA,
                2000);
        System.out.println(umFuncionario.calcularSalarioComImposto());

        Funcionario outroFuncionario = new Funcionario(Funcionario.REPOSITOR,
                1500);
        System.out.println(outroFuncionario.calcularSalarioComImposto());
    }
}