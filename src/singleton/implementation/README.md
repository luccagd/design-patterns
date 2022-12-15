# Exemplo de implementação

*A implementação do padrão Singleton é bastante simples. Então, não seguiremos o mesmo padrão de exemplos dos outros padrões.*

Para aplicar o padrão, precisamos que nossa classe Singleton possua um construtor privado, para que não seja possível instanciá-la de fora da própria classe.

Adicionamos também uma variável de instância privada e estática, que irá conter a instância única a ser retornada quando for solicitada. Por último, criamos um método `getInstance()`, que também é estático e irá retornar a instância única que criamos dentro da nossa classe Singleton. Dentro deste método verificamos se já existe uma instância criada, se não, criamos antes de retorná-la. Esse processo é chamado de *Lazy initialization*.

*Obs.: Quando criamos um Singleton, devemos nos atentar à possibilidade de diferentes threads criarem diferentes singletons.*
```java
public class Singleton {
  private static Singleton uniqueInstance = null;

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Singleton();
    }

    return uniqueInstance;
  }
}
```

<br>

A forma anterior garante que uma instância nunca será criada caso não seja solicitada. Porém, também poderíamos implementar já criando um novo objeto no momento da declaração da variável:
```java
private static Singleton uniqueInstance = new Singleton();

public static Singleton getInstance() {
  return uniqueInstance;
}
```

<br>

A única forma de obtermos uma instância dessa classe é através do método estático `getInstance()`
```java
Singleton.getInstance()
```
