package br.com.ada.filmes.service;


import br.com.ada.filmes.dao.FilmeDAO;
import br.com.ada.filmes.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.ada.filmes.dao.FilmeDAO.filmes;

@Service
public class FilmeService {
    @Autowired
    private FilmeDAO filmeDAO;


    public void adicionar (Filme filme){
        try {
            filmeDAO.adicionar(filme);
        }catch (Exception e){
            throw new RuntimeException("");
        }
    }

    public List<Filme> buscarTodos(){
        return filmeDAO.buscarTodos();
    }

    public void atualizar(Filme filme){
        try {
            filmeDAO.atualizar(filme);
        }catch (Exception e){
            throw new RuntimeException("");
        }
    }

    public void remover(int id){
        try {
            filmeDAO.remover(id);
        }catch (Exception e){
            throw new RuntimeException("");
        }
    }
    public Filme buscarPorId(int id) {
        return filmes.stream().
                filter(f -> f.getId() == id).findFirst().orElse(null);
    }
    public void like (int id){
        for (int i = 0; i < filmes.size(); i++){
            Filme f = filmes.get(i);
            if (f.getId()==id){
                f.setLike(f.getLike()+1);
                break;
            }
        }
    }
    public List<Filme> buscarPrincipais() {
        Comparator<Filme> filmesLikesComparator = Comparator.comparing(Filme::getLike).reversed();

        System.out.println(filmesLikesComparator.toString());
        return filmes.stream()
                .sorted(filmesLikesComparator)
                .limit(3)
                .collect(Collectors.toList());
    }
    public void dislike (int id){
        for (int i = 0; i < filmes.size(); i++){
            Filme f = filmes.get(i);
            if (f.getId()==id){
                f.setDisLike(f.getDisLike()+1);
                break;
            }
        }
    }
}
