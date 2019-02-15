package com.android.recyclerview.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.recyclerview.R;
import com.android.recyclerview.activity.model.Filme;

import java.util.List;

/*
* Essa classe utilizamos para criar os itens.
* Os itens vão mudando automaticamente e precisamos de uma classe para
* guardar esses dados.
* Cada um desses itens, guardamos dentro de um objeto.
* Conforme descemos a lista, criamos um novo objeto para exibir o item,
* mas a visualização (interface) é a mesma, mudamos apenas o dado que
* está dentro.
*
* */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    //contrutor
    public Adapter(List<Filme> lista) {
        //recebe a lista que está dentro do adapter
        this.listaFilmes = lista;
    }


    /*
    * O ViewHolder: Cada dado exibido utiliza um ViewHolder,
    * significa que irá armazenar / guardar, cada um desses itens
    * O RecyclerView cria uma quantidade fixa de itens diferentes,
    * por exemplo, se eu coloco para exibir 10 itens, a partir desses 10  itens
    * ele utiliza a mesma visualização reaproveitando a visualização,
    * alterando apenas o conteúdo exibido dentro da lista
    * "Recicla as visulizações"
    * Precisamos do ViewHolder porque reciclamos as views, mas os dados
    * precisam ser alterados
    * */


    /*
    * o método onCreateViewHolder é chamado para que possamos criar nossas visualizações.
    * O RecyclerView vai criar as primeiras views que serão exibidas para o usuário,
    * a partir do momento que ele criar a quantidade de views que aparece para o usuário,
    * ele passa a usar a apenas o método onBindViewHolder para exibir cada um dos elementos,
    * ele não vai mais criar as visualizações
    * */

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //conventerndo o xml para o tipo view
        View itemLista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_lista, viewGroup, false);

        return new MyViewHolder(itemLista);
    }

    /*
    * Exibe os itens
    * Dentro desse método é que recuperamos os dados
    * */

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Filme filme = listaFilmes.get( i ); //recupera o item da lista que estiver na posição i
        /*
        * recupera a posição de cada item e exibe até todos os itens serem exibidos
        * */
        myViewHolder.titulo.setText(filme.getTituloFilme());
        myViewHolder.genero.setText(filme.getGenero());
        myViewHolder.ano.setText(filme.getAno());

    }

    /*
    * Retorna a quantidade de itens que serão exibidos
    * */

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    /*
     * Quando criamos uma classe dentro de outra damos o
     * nome de inner class
     * */

    /*
     * Essa classe é responsável por guardar os dados
     * antes deles serem exibidos na tela
     * */

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //localizando os ids
            titulo = itemView.findViewById(R.id.textTituloId);
            ano = itemView.findViewById(R.id.textAnoId);
            genero = itemView.findViewById(R.id.textGeneroId);
        }
    }
}
