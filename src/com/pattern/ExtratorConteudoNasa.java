package com.pattern;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo{

    public List<Conteudo> extrairConteudos(String json) {
         var parser = new JsonParse();
        List<Map<String, String>> listFilmes = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for(Map<String, String> atributos : listFilmes){

            String titulo = atributos.get("title");
            String urlImage = atributos.get("url");
            var conteudo = new Conteudo(titulo,urlImage);
            conteudos.add(conteudo);

        }

        return conteudos;

    }
}
