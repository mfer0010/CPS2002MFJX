package main;

public class HelloWorld {

    public String getMessage() {
        return "Hello World!!";
    }

    public String getMessage(String name) {

        if (name == null) {
            return getMessage();
        }

        if (name == "Marc" || name == "Jasmine") {
            return "Aw";
        }

        return "Hello " + name + "!!";
    }

    public String getMessage(int n) {

        String result = "";

        for (int i=0; i<n; i++) {
            result += getMessage();
        }

        return result;
    }

}
