package service;

import model.Forma;

public class Retangulo implements Forma {
    private int altura;
    private int largura;

    public Retangulo(int altura, int largura){
        this.altura = altura;
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public int setAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }
    public int setLargura(){
        return largura;
    }

    @Override
    public int getArea() {
        return largura * altura;
    }
}
