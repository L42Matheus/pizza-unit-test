package pizza.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Pizza {

    private static HashMap<String, Integer> ingredientes = new HashMap<>();
    private ArrayList<String> listaIngredientes = new ArrayList<>();

    public Pizza(ArrayList<String> ingredientes) {
        if (ingredientes.size() > 0) {
            for (String ingrediente : ingredientes) {
                adionaIngrediente(ingrediente);
            }
        } else {
            System.out.println("Erro: A pizza não pode ser criada sem ingredientes.");
        }
    }
    public void adionaIngrediente(String ingrediente){
        contabilizarIngredientes(ingrediente);
        listaIngredientes.add(ingrediente);

    }

    public static void contabilizarIngredientes(String ingrediente){
        int quantidade = ingredientes.getOrDefault(ingrediente, 0);
        ingredientes.put(ingrediente, quantidade + 1);

    }
    
    public double getPreco(){
        int quantidadeIngredientes = listaIngredientes.size();

        if (quantidadeIngredientes <= 2) {
            return 15.0;
        }else if (quantidadeIngredientes >= 3 && quantidadeIngredientes <= 5) {
            return 20.0;
        }else {
            return 23.0;
        }
    }

    public static HashMap<String, Integer> getIngredientes() {
        return ingredientes;
    }

    public ArrayList<String> getListaIngredientes() {
        return listaIngredientes;
    }

    public int getQuantidadeIngredientes() {
        return listaIngredientes.size();
    }
}
