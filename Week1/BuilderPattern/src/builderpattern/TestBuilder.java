package builderpattern;

public class TestBuilder {
    public static void main(String[] args) {
        // Creating a simple office PC
        Computer officePC = new Computer.ComputerBuilder("Intel i3", "4GB")
                .build();

        // Creating a custom gaming rig
        Computer gamingRig = new Computer.ComputerBuilder("Ryzen 9", "32GB")
                .addStorage("2TB NVMe SSD")
                .addGPU("NVIDIA RTX 4080")
                .addKeyboard("Corsair Mechanical RGB")
                .build();

        System.out.println(officePC);
        System.out.println();
        System.out.println(gamingRig);
    }
}
