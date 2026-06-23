public class Logger {
    private static Logger log = new Logger();

    private Logger() {
        System.out.println("created a logger instance");
    }

    public static Logger getinstance() {
        // made this function static cuz while using this function in test file which
        // has the main function(a static function), we cant reference a non static
        // function in a static function.
        return log;
    }
}
