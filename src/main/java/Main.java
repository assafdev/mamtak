import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("The sever is running on: " + "http://localhost:4567/hello");
        get("/hello", (req, res) -> "Hello World");
    }
}