public class Driver {
    public static void main(String[] args) {

        Switchable[] devices = {
                new Fan(),
                new Light()
        };

        System.out.println("\nToggle devices:");

        for (Switchable device : devices) {
            device.toggle();
        }

        int hour = 20;

        DevicePolicy anonymousPolicy = new DevicePolicy() {
            @Override
            public boolean maySwitchOn(Switchable device, int hour) {
                return hour >= 8 && hour <= 22;
            }
        };

        DevicePolicy lambdaPolicy = (device, h) -> h >= 8 && h <= 22;

        System.out.println("\nAnonymous class policy:");

        for (Switchable device : devices) {
            System.out.println(
                    "May switch on at " + hour + ":00 = "
                            + anonymousPolicy.maySwitchOn(device, hour));
        }

        System.out.println("\nLambda policy:");

        for (Switchable device : devices) {
            System.out.println(
                    "May switch on at " + hour + ":00 = "
                            + lambdaPolicy.maySwitchOn(device, hour));
        }
        System.out.println("25CE057");
    }
}