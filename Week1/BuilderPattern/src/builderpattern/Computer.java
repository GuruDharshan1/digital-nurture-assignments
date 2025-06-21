package builderpattern;

public class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String gpu;
    private final String keyboard;

    // Private constructor to enforce object creation via Builder
    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.keyboard = builder.keyboard;
    }

    @Override
    public String toString() {
        return "---- Computer Specs ----\n" +
               "CPU       : " + cpu + "\n" +
               "RAM       : " + ram + "\n" +
               "Storage   : " + (storage != null ? storage : "Not included") + "\n" +
               "GPU       : " + (gpu != null ? gpu : "Integrated") + "\n" +
               "Keyboard  : " + (keyboard != null ? keyboard : "Standard");
    }

    // Static nested builder class
    public static class ComputerBuilder {
        private final String cpu;
        private final String ram;

        private String storage;
        private String gpu;
        private String keyboard;

        public ComputerBuilder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public ComputerBuilder addStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder addGPU(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public ComputerBuilder addKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
