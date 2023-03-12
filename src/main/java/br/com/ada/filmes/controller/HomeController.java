package br.com.ada.filmes.controller;


import br.com.ada.filmes.model.Filme;
import br.com.ada.filmes.model.Noticia;
import br.com.ada.filmes.service.FilmeService;
import br.com.ada.filmes.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private FilmeService filmeService;
    @Autowired
    private NoticiaService noticiaService;


    @GetMapping
    public String listarHome(Model model) {
        List<Filme> listaFilmes = filmeService.buscarPrincipais();
        List<Noticia> listaNoticias = noticiaService.buscarPrincipais();
        model.addAttribute("filmes", listaFilmes);
        model.addAttribute("noticias", listaNoticias);
        return "home_listar";
    }

    //FILME
    @GetMapping("/todos-filmes")
    public String listarTodosFilmes(Model model) {
        List<Filme> lista = filmeService.buscarTodos();
        model.addAttribute("filmes", lista);
        return "filmes_listar";
    }

    @GetMapping("/editar-filme/{id}")
    public String editarFilme(@PathVariable int id, Model model) {
        Filme filme = filmeService.buscarPorId(id);
        model.addAttribute("filme", filme);
        return "filme_editar";
    }

    @PostMapping("/editar-filme")
    public String atualizarFilme(Filme filme) {
        filmeService.atualizar(filme);
        return "redirect:/home/filmes_listar";
    }

    @GetMapping("todos-filmes/like/{id}")
    public String atualizarLikeFilme(@PathVariable int id) {
        filmeService.like(id);
        return "redirect:/home/filmes_listar";
    }

    @GetMapping("todos-filmes/deslike/{id}")
    public String atualizarDeslikeFilme(@PathVariable int id) {
        filmeService.dislike(id);
        return "redirect:/home/filmes_listar";
    }

    @GetMapping("/remover-filme/{id}")
    public String removerFilme(@PathVariable int id) {
        filmeService.remover(id);
        return "redirect:/home/filmes_listar";
    }

    @GetMapping("/novo-filme")
    public String novoFilme(Model model) {
        model.addAttribute("filme", new Filme());
        return "filme_novo";
    }

    @PostMapping("/novo-filme")
    public String adicionarFilme(Filme filme) {
        filmeService.adicionar(filme);
        return "redirect:/home/filmes_listar";
    }

    //NOTICIA

    @GetMapping("/todas-noticias")
    public String listarTodasNoticias(Model model) {
        List<Noticia> lista = noticiaService.buscarTodos();
        model.addAttribute("noticias", lista);
        return "noticia_listar";
    }

    @GetMapping("/editar-noticia/{id}")
    public String editarNoticia(@PathVariable int id, Model model) {
        Noticia noticia = noticiaService.buscarPorId(id);
        model.addAttribute("noticia", noticia);
        return "noticia_editar";
    }

    @PostMapping("/editar-noticia")
    public String atualizarNoticia(Noticia noticia) {
        noticiaService.atualizar(noticia);
        return "redirect:/home/noticia_listar";
    }

    @GetMapping("/remover-noticia/{id}")
    public String removerNoticia(@PathVariable int id) {
        noticiaService.remover(id);
        return "redirect:/home/noticias_listar";
    }

    @GetMapping("/nova-noticia")
    public String novaNoticia(Model model) {
        model.addAttribute("noticia", new Noticia());
        return "noticia_novo";
    }

    @PostMapping("/nova-noticia")
    public String adicionarNoticia(Noticia noticia) {
        noticiaService.adicionar(noticia);
        return "redirect:/home/noticias_listar";
    }


}
