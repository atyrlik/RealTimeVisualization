

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class DoRandomStuff {
    public DoRandomStuff() {
        long randomWaitTime = ((long) (((java.lang.Math.random()) * 2000) + 500));
        Logger.logBeginObjectCreation(0);;
        new java.util.ArrayList();
        Logger.logEndObjectCreation("java.util.ArrayList", 0, "anonymous", 1);;
        try {
            java.lang.Thread.sleep(randomWaitTime);
        } catch (java.lang.Exception exception) {
            java.lang.System.out.println(exception);
        }
        Logger.logBeginObjectCreation(1);;
        java.util.HashMap myHashMap = new java.util.HashMap();
        Logger.logEndObjectCreation("java.util.HashMap", 1, "myHashMap", 1);;
    }

    public char getRandomLetter() {
        Logger.logBeginMethodCall("getRandomLetter");;
        java.lang.String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Logger.logEndMethodCall("getRandomLetter");;
        return letters.charAt(((int) ((java.lang.Math.random()) * (letters.length()))));
    }

    public java.lang.String getRandomWord(int size) {
        Logger.logBeginMethodCall("getRandomWord");;
        Logger.logBeginObjectCreation(2);;
        java.lang.StringBuilder word = new java.lang.StringBuilder();
        Logger.logEndObjectCreation("java.lang.StringBuilder", 2, "word", 1);;
        for (int i = 0; i < size; i++)
            word.append(getRandomLetter());
        
        Logger.logEndMethodCall("getRandomWord");;
        return word.toString();
    }
}

