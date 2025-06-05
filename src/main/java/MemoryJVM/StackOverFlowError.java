package MemoryJVM;

public class StackOverFlowError {
    public static void main(String[] args) {
        sofe();
    }
    public static void sofe() {
        sofe();
    }
}
