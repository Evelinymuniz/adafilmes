package br.com.ada.filmes.dao;
import br.com.ada.filmes.model.Noticia;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NoticiaDAO {

    public static List<Noticia> noticias = new ArrayList<>();
    private static int proximoId = 1;

    public void adicionar(Noticia noticia) {
        noticia.setId(proximoId++);
        noticias.add(noticia);
    }

    public void atualizar(Noticia noticia) {
        for (int i = 0; i < noticias.size(); i++) {
            Noticia n = noticias.get(i);
            if (n.getId() == noticia.getId()) {
                noticias.set(i, noticia);
                break;
            }
        }
    }

    public void remover(int id) {
        noticias.removeIf(n -> n.getId() == id);
    }

    /*public Noticia buscarPorId(int id) {
        return noticias.stream().filter(n -> n.getId() == id).findFirst().orElse(null);
    }
    public List<Noticia> buscarPrincipais() {
        return noticias.stream()
                .limit(3)
                .collect(Collectors.toList());
    }*/
    public List<Noticia> buscarTodos() {
        return noticias;
    }
}