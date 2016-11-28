

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class DoRandomStuff {
    public char getRandomLetter() {
        java.lang.String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return letters.charAt(((int) ((java.lang.Math.random()) * (letters.length()))));
    }

    public java.lang.String getRandomWord(int size) {
        Logger.log("Begin java.lang.StringBuilder word creation");
        java.lang.StringBuilder word = new java.lang.StringBuilder();
        Logger.log("End java.lang.StringBuilder word creation");
        for (int i = 0; i < size; i++)
            word.append(getRandomLetter());
        
        return word.toString();
    }
}

