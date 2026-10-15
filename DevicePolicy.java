@FunctionalInterface
public interface DevicePolicy {
    boolean maySwitchOn(Switchable device, int hour);
}