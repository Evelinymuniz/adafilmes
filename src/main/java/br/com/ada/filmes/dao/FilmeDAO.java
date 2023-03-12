package br.com.ada.filmes.dao;

import br.com.ada.filmes.model.Filme;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FilmeDAO {
    public static List<Filme> filmes = new ArrayList<>();
    private static int proximoId = 1;

    public void adicionar(Filme filme) {
        filme.setId(proximoId++);
        filmes.add(filme);
    }

    public void atualizar(Filme filme) {
        for (int i = 0; i < filmes.size(); i++) {
            Filme f = filmes.get(i);
            if (f.getId() == filme.getId()) {
                filmes.set(i, filme);
                break;
            }
        }
    }
    /*public List<Filme> buscarPrincipais() {
        Comparator<Filme> filmesLikesComparator = Comparator.comparing(Filme::getLike).reversed();

        System.out.println(filmesLikesComparator.toString());
        return filmes.stream()
                .sorted(filmesLikesComparator)
                .limit(3)
                .collect(Collectors.toList());
    }*/

  /*  public void like (int id){
        for (int i = 0; i < filmes.size(); i++){
            Filme f = filmes.get(i);
            if (f.getId()==id){
                f.setLike(f.getLike()+1);
                break;
            }
        }
    }
    public void dislike (int id){
        for (int i = 0; i < filmes.size(); i++){
            Filme f = filmes.get(i);
            if (f.getId() == f.getId()){
                f.setDisLike(f.getDisLike()+1);
                break;
            }
        }
    }*/

    public void remover(int id) {
        filmes.removeIf(f -> f.getId() == id);
    }

    /*public Filme buscarPorId(int id) {

        return filmes.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
    }*/
    public List<Filme> buscarTodos() {
        return filmes;
    }


}