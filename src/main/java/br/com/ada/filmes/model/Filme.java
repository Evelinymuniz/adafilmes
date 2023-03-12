package br.com.ada.filmes.model;

public class Filme {
    private Integer id = 1;
    private String titulo;
    private String genero;
    private String duracao;
    private String sinopse;
    private String imdb;
    private String imagem;
    private Integer like = 0;
    private Integer DisLike = 0;

    public Filme() {
    }

    public Filme(Integer id, String titulo, String genero, String duracao, String sinopse, String imdb, String imagem) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.sinopse = sinopse;
        this.imdb = imdb;
        this.imagem = imagem;
    }

    public Integer getDisLike() {
        return DisLike;
    }

    public void setDisLike(Integer disLike) {
        DisLike = disLike;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
