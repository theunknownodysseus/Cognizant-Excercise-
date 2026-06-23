
public class Test {
    public static void main(String[] args) {
        // Logger obj1 = new Logger(); this won't work because the constructor is
        // private so i create a public getter function for the object ()
        Logger obj1 = Logger.getinstance();
        Logger obj2 = Logger.getinstance();

        if (obj1 == obj2) {
            System.out.println("Both the objects point to the same instance of the Logger class");
        }
    }
}
