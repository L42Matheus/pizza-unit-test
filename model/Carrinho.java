package pizza.model;

import java.util.ArrayList;

public class Carrinho {

    public ArrayList<Pizza> pizzas;

    public Carrinho() {
        this.pizzas = new ArrayList<>();
    }


    public void adicionarPizza(Pizza pizza){
        if (pizza.getQuantidadeIngredientes() > 0) {
            pizzas.add(pizza);
        }else {
            System.out.println("Erro: A pizza não possui ingredientes e não pode ser adicionada ao carrinho.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPreco();
        }
        return total;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }


}
