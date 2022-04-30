package dio.ordenaListas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaListas {

    public static void main(String[] args) {
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};

        System.out.println("-- \t Ordem de inserção \t --");
        System.out.println(meusGatos);

        System.out.println("-- \t Ordem de aleatória \t --");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("-- \t Ordem natural \t --");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("-- \t Ordem idade \t --");
        Collections.sort(meusGatos, new ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("-- \t Ordem nome \t --");
        Collections.sort(meusGatos, new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("-- \t Ordem nome \t --");
        Collections.sort(meusGatos, new ComparatorNome());
        System.out.println(meusGatos);

        System.out.println("-- \t Ordem nome/cor/idade \t --");
        Collections.sort(meusGatos, new ComparatorNomeCorIdade());
        System.out.println(meusGatos);


    }



}

class Gato implements Comparable<Gato>{
    private String nome;
    private int idade;
    private String cor;

    public Gato(String nome, int idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }


    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorNome implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getNome().compareToIgnoreCase(g2.getNome());
    }
}

class ComparatorCor implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}