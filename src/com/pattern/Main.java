package com.pattern;


import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        //Http
        String urlmovies = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        String urlnasa = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        var client = new ClienteHttp();
        String url = client.buscarDados(urlmovies);

        //Visualizar os dados
        ExtratorConteudoIMDB  extrator = new ExtratorConteudoIMDB();
        List<Conteudo> conteudos = extrator.extrairConteudos(url);
        GerarFiguras gerar = new GerarFiguras();

        for(int i =0; i<10;i++){
           Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();

            String arquivo = conteudo.getTitulo()+".png";
            gerar.criar(inputStream,arquivo );
            System.out.println(conteudo.getTitulo());

        }

    }


}
