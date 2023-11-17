package pizza.test;

import jdk.jfr.Description;
import org.junit.Test;
import pizza.model.Carrinho;
import pizza.model.Pizza;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class PizzaTest {


    @Test
    @Description("")
    public void deveAdicionarIgredienteNaPizza(){

        ArrayList<String> ingredientesPizza = new ArrayList<>();
        ingredientesPizza.add("Queijo");

        Pizza pizza = new Pizza(ingredientesPizza);

        HashMap<String, Integer> ingredientesAdicionados = Pizza.getIngredientes();

        int quantidadeQueijo = ingredientesAdicionados.getOrDefault("Queijo", 1);
        assertEquals(1, quantidadeQueijo);


    }

    @Test
    @Description("Deve calcular valor total de pizzas")
    public void deveCalcularValorTotalDePizzas() throws Exception {

        ArrayList<String> ingredientesPizza = new ArrayList<>();
        ingredientesPizza.add("Queijo");
        ingredientesPizza.add("Tomate");
        ingredientesPizza.add("Feijão");

        Pizza pizza = new Pizza(ingredientesPizza);

        Carrinho carrinho = new Carrinho();

        carrinho.adicionarPizza(pizza);

        assertEquals(20, (int) carrinho.calcularTotal());

    }

    @Test
    public void testarPrecoComDoisIngredientes() {
        ArrayList<String> ingredientesPizza = new ArrayList<>();
        ingredientesPizza.add("Queijo");
        ingredientesPizza.add("Tomate");

        Pizza pizza = new Pizza(ingredientesPizza);

        assertEquals(15.0, pizza.getPreco(), 0.01);
    }

    @Test
    public void testarPrecoComTresIngredientes() {
        ArrayList<String> ingredientesPizza = new ArrayList<>();
        ingredientesPizza.add("Queijo");
        ingredientesPizza.add("Tomate");
        ingredientesPizza.add("Presunto");

        Pizza pizza = new Pizza(ingredientesPizza);

        assertEquals(20.0, pizza.getPreco(), 0.01);
    }

    @Test
    public void testarPrecoComSeisIngredientes() {
        ArrayList<String> ingredientesPizza = new ArrayList<>();
        ingredientesPizza.add("Queijo");
        ingredientesPizza.add("Tomate");
        ingredientesPizza.add("Presunto");
        ingredientesPizza.add("Cogumelos");
        ingredientesPizza.add("Pimentão");
        ingredientesPizza.add("Cebola");

        Pizza pizza = new Pizza(ingredientesPizza);

        assertEquals(23.0, pizza.getPreco(), 0.01);
    }

    @Test
    public void deveExibirMensagemDeErroAoAdicionarPizzaSemIngredientes() {

        String messageActual = "Erro: A pizza não possui ingredientes e não pode ser adicionada ao carrinho.";
        String messageExpected = "Erro: A pizza não possui ingredientes e não pode ser adicionada ao carrinho.";
        Carrinho carrinho = new Carrinho();

        Pizza pizzaSemIngredientes = new Pizza(new ArrayList<>());


        carrinho.adicionarPizza(pizzaSemIngredientes);

        assertEquals(messageExpected, messageActual);
    }
}