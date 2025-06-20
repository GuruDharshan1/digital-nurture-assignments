package exercise2_factorymethod;

public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF Document...");
    }
}
