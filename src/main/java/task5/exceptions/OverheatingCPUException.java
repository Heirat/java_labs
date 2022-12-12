package task5.exceptions;

public class OverheatingCPUException extends CPUException {
    private final double temp;

    public double getTemp() {
        return temp;
    }

    public OverheatingCPUException(double temp) {
        super();
        this.temp = temp;
    }

    @Override
    public String toString() {
        return String.format("Произошел перегрев процессора с температурой %.2f°C", getTemp());
    }

}
