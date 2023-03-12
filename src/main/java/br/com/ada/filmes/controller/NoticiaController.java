package br.com.ada.filmes.controller;



import br.com.ada.filmes.model.Noticia;
import br.com.ada.filmes.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/noticia")
public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @GetMapping
    public String listar(Model model) {
        List<Noticia> noticias = noticiaService.buscarTodos();
        model.addAttribute("noticias", noticias);
        return "noticia_listar";
    }

    @GetMapping("/editar/{id}")//so pode ser aplicado em um metodo
    public String editar(@PathVariable int id, Model model) {
        Noticia noticia = noticiaService.buscarPorId(id);
        model.addAttribute("noticia", noticia);
        return "noticia_editar";
    }

    @PostMapping("/editar")
    public String atualizar(Noticia noticia) {
        noticiaService.atualizar(noticia);
        return "redirect:/noticia";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable int id) {
        noticiaService.remover(id);
        return "redirect:/noticia";
    }

    @GetMapping("/novo")//colocar rota
    public String novo(Model model) {//produto que vai ser salvo no momento que chamar o post
        model.addAttribute("noticia", new Noticia());
        return "noticia_novo";
    }

    @PostMapping("/novo")
    public String adicionar(Noticia noticia) {
        noticiaService.adicionar(noticia);
        return "redirect:/noticia";//vai direcionar para a tela /produto
    }
}
