public class Thermostat_p2_1 {
  private String location;
  private int temperature;
  private static final int min = 16;
  private static final int max = 30;
  private static int activeCount = 0;

  Thermostat_p2_1() {
  }

  Thermostat_p2_1(String l, int st) {
    l = location;
    if (temperature >= min && temperature <= max) {
      st = temperature;
    } else {
      temperature = 22;
    }
    activeCount++;
  }

  Thermostat_p2_1(String l) {
    this(l, 22);
  }

  void raise() {
    if (temperature < max) {
      temperature++;
    }
  }

  void lower() {
    if (temperature > min) {
      temperature--;
    }

  }

  int getTemperature() {
    return temperature;
  }

  int getActiveCount() {
    return activeCount;
  }

  public static void main(String[] args) {
    Thermostat_p2_1 t1 = new Thermostat_p2_1("samtrampur", 17);
    Thermostat_p2_1 t2 = new Thermostat_p2_1("samtrampur", 17);
    for (int i = 0; i < 10; i++) {
      t1.raise();
      System.out.println(t1.getTemperature());
      if (t1.getTemperature() == 30) {
        System.out.println(" Already at maximum (30)");
        break;
      }

    }
    for (int i = 0; i < 20; i++) {
      t1.lower();
      System.out.println(t1.getTemperature());
      if (t1.getTemperature() == 16) {
        System.out.println(" Already at minimum (16)");
        break;
      }
    }
    System.out.println(t1.getActiveCount());
    System.out.println("25ce057");
  }

}
