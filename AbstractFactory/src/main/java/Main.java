
import com.ifsp.abstractfactory.FabricaDeSqueeze;
import com.ifsp.abstractfactory.FabricaSports;
import com.ifsp.abstractfactory.SqueezeComum;
import com.ifsp.abstractfactory.SqueezeTermica;
import com.ifsp.abstractfactory.FabricaNord;

/* Enrredo do Problema
Uma determinada empresa trabalha com diversos tamanhos e tipos de squeezes
onde estas sao adquiridas de duas fabriucas diferentes.
Ambas as fabricas fabricam squeezes termicas e comums. 

A Fabrica Sports fabrica 
Squeezes de 500ml na gategoria termica.
Squeezes de 750ml na categoria comum. 

A fabrica Nord fabrica
Squeezes de 1 litro na gategoria termica.
Squeezes de 800ml na categoria comum.

O presente sistema faz o gerenciamento do sistemas dessa empresa.
 */

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Produtos da Fabrica Sports:\n");
        FabricaDeSqueeze fabrica = new FabricaSports();
        SqueezeComum comum = fabrica.criarSqueezeComum();
        SqueezeTermica termica = fabrica.criarSqueezeTermica();
        comum.exibirInfoComum();
        System.out.println("\n");
        termica.exibirInfoTermica();
        System.out.println("\n");

        System.out.println("Produtos da Fabrica Nord\n");
        fabrica = new FabricaNord();
        comum = fabrica.criarSqueezeComum();
        termica = fabrica.criarSqueezeTermica();
        comum.exibirInfoComum();
        System.out.println("\n");
        termica.exibirInfoTermica();
        System.out.println("\n");
        
        System.out.println("Fim");
    }
}
