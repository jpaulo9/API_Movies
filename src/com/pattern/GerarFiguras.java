package com.pattern;


import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.Format;

public class GerarFiguras {


    public void criar (InputStream inputStream, String nomeArquivo) throws Exception{

        // ler imagem
//        InputStream  inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMGEzN2VkMmUtMGM1Zi00Y2U1LTlkMDktMTlhMTdmYzZmZDlhXkEyXkFqcGdeQXVyODEyNjEwMDk@.jpg").openStream();
        BufferedImage imgOriginal = ImageIO.read(inputStream);

        //nova imagem em memória, tamanho diferente
        int largura = imgOriginal.getWidth();
        int altura  = imgOriginal.getHeight();
        int novaAltura = altura+200;
        BufferedImage novaImage = new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);

        //copia a imagem original
        Graphics2D graphics2D = (Graphics2D) novaImage.getGraphics();
        graphics2D.drawImage(imgOriginal,0,0,null);

        // nova frase
        var fonte = new Font(Font.SANS_SERIF,Font.BOLD,64);
        graphics2D.setFont(fonte);
        graphics2D.setColor(Color.RED);

        graphics2D.drawString("NEMAGE",0, novaAltura - 100);

        //salvar nova imagem
        ImageIO.write(novaImage, "png",new File("saida/"+nomeArquivo));



    }



}
