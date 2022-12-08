# Exemplo de implementação

### Cenário 
Temos uma estação meteorológica que manipula dados de temperatura, humidade e pressão através de seus sensores. Temos também alguns displays que dependem dos dados da estação meteorológica para exibir informações.

Portanto, queremos que sempre que os dados da estação meteorolóogica mudarem, os display sejam atualizados com essas informações.
Neste exemplo de implementação, queremos que dois displays sejam atualizados:
* CurrentConditionsDisplay: exibe o estado atual da temperatura, humidade e pressão.
* HeadIndexDisplay: índice de aquecimento calculado através da temperatura e humidade.

Podemos dizer que:
* os displays vão observar a estação meteorológica. Eles são os `Observers`.
* a estação meteorológica notificará e será observada pelos displays. Ela é o `Subject`.

<br>

## Sem o padrão Observer
Sem a utilização do padrão, seria necessário tem um acoplamento muito grande com os Observers. A classe teria uma variável de instância para cada um dos displays e chamaria um método de update em cada um dos objetos.

Dessa maneira, sempre que quiséssemos ter um novo display recebendo notificações, precisaríamos mudar o código.
```java
public class WeatherData {
  
  // declarações de variável de instância...

  public void measurementsChanged() {
      float temp = getTemperature();
      float humidity = getHumidity();
      fload pressure = getPressure();
      
      currentConditionsDisplay.update(temp, humidity, pressure);
      heatIndexDisplay.update(temp, humidity, pressure);
      /* 
        sempre que quisermos enviar notificações para um novo display, teremos que alterar esse código.
        dessa forma quebramos o princípio aberto/fechado do SOLID.
      */
  }

  // outros métodos de WeatherData aqui...
}
```

<br>

## Com o padrão Observer
No padrão Observer, nossa classe WeatherData passar a ter uma lista de Observers. Para enviar notificações para cada um deles, a única coisa que precisamos fazer é iterar sobre essa lista chamando o método update de cada Observer.

Perceba que com ou sem o padrão, precisaremos chamar um método de update do Observer. A diferença é que agora nós não codificamos para implementações concretas, e sim para uma interface. A classe WeatherData não sabe se ela está enviando uma notificação para um CurrentConditionsDisplay ou um HeadIndexDisplay. Tudo que ela sabe é que ela está notificando um Observer.

Para isso, nossos displays devem implementar a inteface Observer. Já a nossa classe WeatherData, vai implementar a interface Subject, que conta com métodos de inclusão e remoção de Observers de sua lista interna.
```java
// Classe WeatherData com o padão observer

public class WeatherData implements Subject {
  private List<Observer> observers;
  
  // declarações de variável de instância...

  public WeatherData() {
    this.observers = new ArrayList<>();
  }

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(this.temperature, this.humidity, this.pressure);
    }
  }

  // outros métodos de WeatherData aqui...
}
```

```java
// Implementação de um de nossos displays. É através do método update que os dados desse display são atualizados.

public class CurrentConditionsDisplay implements Observer {
  private float temperature;
  private float humidity;
  private Subject weatherData;

  public CurrentConditionsDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    this.temperature = temp;
    this.humidity = humidity;
  }
}
```
