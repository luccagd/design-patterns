package singleton.implementation;

public class Singleton {
  private static Singleton uniqueInstance = null;

  // outras variáveis de instância úteis aqui

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Singleton();
    }

    return uniqueInstance;
  }

  // outros métodos úteis aqui
}
