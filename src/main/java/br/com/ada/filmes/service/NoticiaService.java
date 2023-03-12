package br.com.ada.filmes.service;

import br.com.ada.filmes.dao.NoticiaDAO;
import br.com.ada.filmes.model.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.ada.filmes.dao.NoticiaDAO.noticias;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaDAO noticiaDAO;

    public void adicionar (Noticia noticia){
        try {
            noticiaDAO.adicionar(noticia);
        }catch (Exception e){
            throw new RuntimeException("");
        }
    }

    public List<Noticia> buscarTodos(){
        return noticiaDAO.buscarTodos();
    }

    public void atualizar(Noticia noticia){
        try {
        noticiaDAO.atualizar(noticia);
        }catch (Exception e){
            throw new RuntimeException("");
        }
    }

    public void remover(int id){
        try {
        noticiaDAO.remover(id);
        }catch (Exception e){
            throw new RuntimeException("");
        }
    }
    public Noticia buscarPorId(int id) {
        return noticias.stream().
                filter(n -> n.getId() == id).findFirst().orElse(null);
    }
    public List<Noticia> buscarPrincipais() {
        return noticias.stream()
                .limit(3)
                .collect(Collectors.toList());
    }




}
