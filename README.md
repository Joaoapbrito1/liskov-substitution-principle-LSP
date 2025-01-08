# Exercícios para praticar SOLID!


## Exercício 3: Liskov Substitution Principle (LSP)

### Enunciado:
Você está criando um sistema para calcular áreas de formas geométricas. Atualmente, a classe Quadrado herda de Retangulo, mas isso está causando problemas porque o comportamento de Quadrado não é consistente com o de Retangulo. Refatore o código para que ele siga o Princípio da Substituição de Liskov (LSP).

Código inicial (errado):
```java
public class Retangulo {
    protected int largura;
    protected int altura;

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getArea() {
        return largura * altura;
    }
}

public class Quadrado extends Retangulo {
    @Override
    public void setLargura(int largura) {
        this.largura = largura;
        this.altura = largura;
    }

    @Override
    public void setAltura(int altura) {
        this.altura = altura;
        this.largura = altura;
    }
}
```

### Tarefa:
- Crie uma interface Forma com o método getArea().
- Implemente classes separadas para Retangulo e Quadrado, sem herança direta entre elas.

## Resolução

O Princípio da Substituição de Liskov (LSP) é um dos cinco princípios do SOLID, essenciais para a programação orientada a objetos. Ele estabelece que "Subtipos devem poder substituir seus tipos base sem alterar o comportamento esperado do programa".

- Interface Forma

```java
package model;

public interface Forma {
    int getArea();
}
```
Define o método getArea() que todas as formas geométricas devem implementar.

- Classe Quadrado 

```java
package service;

import model.Forma;

public class Quadrado implements Forma {
    private int lado;

    public Quadrado(int lado) {
        this.lado = lado;
    }
    
    @Override
    public int getArea() {
        return lado * lado;
    }
}
```
Possui uma única propriedade, lado, para representar a medida do lado do quadrado, implementa o método getArea() com base no cálculo específico para quadrados.

- Classe Retangulo

```java
package service;

import model.Forma;

public class Retangulo implements Forma {
    private int altura;
    private int largura;

    public Retangulo(int altura, int largura){
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public int getArea() {
        return largura * altura;
    }
}
```
Possui propriedades independentes para largura e altura, implementa o método getArea() de acordo com as características de um retângulo.

## Conclusão
As classes não possuem relação de herança entre si, garantindo que as alterações no comportamento de uma não afetam a outra. Cada classe respeita o contrato da interface Forma e segue o Princípio da Substituição de Liskov, pois instâncias de Quadrado ou Retangulo podem ser usadas de forma intercambiável onde uma Forma é esperada.
