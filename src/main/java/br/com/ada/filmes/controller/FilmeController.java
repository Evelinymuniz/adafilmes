package br.com.ada.filmes.controller;

import br.com.ada.filmes.service.FilmeService;
import br.com.ada.filmes.model.Filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public String listar(Model model) {
        List<Filme> lista = filmeService.buscarTodos();
        model.addAttribute("filmes", lista);
        return "filmes_listar";
    }

    @GetMapping("/editar/{id}")//so pode ser aplicado em um metodo
    public String editar(@PathVariable int id, Model model) {
        Filme filme = filmeService.buscarPorId(id);
        model.addAttribute("filme", filme);
        return "filme_editar";
    }

    @PostMapping("/editar")
    public String atualizar(Filme filme) {
        filmeService.atualizar(filme);
        return "redirect:/filme";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable int id) {
        filmeService.remover(id);
        return "redirect:/filme";
    }

    @GetMapping("/novo")//colocar rota
    public String novo(Model model) {//produto que vai ser salvo no momento que chamar o post
        model.addAttribute("filme", new Filme());
        return "filme_novo";
    }

    @PostMapping("/novo")
    public String adicionar(Filme filme) {
        filmeService.adicionar(filme);
        return "redirect:/filme";//vai direcionar para a tela /produto
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable int id, @RequestHeader(value = HttpHeaders.REFERER, required = false) final String referrer) {
        filmeService.like(id);
        return "redirect:" + referrer;
    }

    @GetMapping("/dislike/{id}")
    public String dislike(@PathVariable int id, @RequestHeader(value = HttpHeaders.REFERER, required = false) final String referrer) {
        filmeService.dislike(id);
        return "redirect:" + referrer;
    }
}
