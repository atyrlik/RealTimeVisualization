

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class DoRandomStuff {
    public char getRandomLetter() {
        java.lang.String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return letters.charAt(((int) ((java.lang.Math.random()) * (letters.length()))));
    }
}

