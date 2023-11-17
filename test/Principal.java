package pizza.test;

import pizza.model.Carrinho;
import pizza.model.Pizza;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) throws Exception {

        ArrayList<String> ingredientesPizza1 = new ArrayList<>();
        ingredientesPizza1.add("Queijo");
        ingredientesPizza1.add("Presunto");

        ArrayList<String> ingredientesPizza2 = new ArrayList<>();
        ingredientesPizza2.add("Queijo");
        ingredientesPizza2.add("Tomate");
        ingredientesPizza2.add("Bacon");

        ArrayList<String> ingredientesPizza3 = new ArrayList<>();
        ingredientesPizza3.add("Queijo");
        ingredientesPizza3.add("Calabresa");
        ingredientesPizza3.add("Tomate");
        ingredientesPizza3.add("Cebola");

        Pizza pizza1 = new Pizza(ingredientesPizza1);
        Pizza pizza2 = new Pizza(ingredientesPizza2);
        Pizza pizza3 = new Pizza(ingredientesPizza3);

        Carrinho carrinho = new Carrinho();

        carrinho.adicionarPizza(pizza1);
        carrinho.adicionarPizza(pizza2);
        carrinho.adicionarPizza(pizza3);

        System.out.println("Total do Carrinho de Compras: R$" + carrinho.calcularTotal());

        // Imprimindo a quantidade utilizada de cada ingrediente
        System.out.println("Quantidade utilizada de cada ingrediente:");
        for (String ingrediente : Pizza.getIngredientes().keySet()) {
            int quantidade = Pizza.getIngredientes().getOrDefault(ingrediente, 0);
            System.out.println(ingrediente + ": " + quantidade);
        }


    }
}
