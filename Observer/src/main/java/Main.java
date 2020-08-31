
import com.ifsp.observer.BarraObserver;
import com.ifsp.observer.Dados;
import com.ifsp.observer.DadosSubject;
import com.ifsp.observer.PorcentoObserver;
import com.ifsp.observer.TabelaObserver;

/*
Um programa precisar representar um conjuto de numeros de formas diferentes. 
Uma represetacao eh o valor numerico
Outra consiste em representar este valor em barras
E a terceira consiste em representar cada valor em porcetagem do total

Alteracoes no conjunto 1 deveram ser refletidas nos demais. 
Este sistema resolve este problema.
*/

public class Main {

    public static void main(String[] args) {
        DadosSubject dados = new DadosSubject();
        dados.attach(new TabelaObserver(dados));
        dados.attach(new BarraObserver(dados));
        dados.attach(new PorcentoObserver(dados));

        dados.setState(new Dados(7, 3, 1));
        dados.setState(new Dados(2, 3, 1));
    }
}
