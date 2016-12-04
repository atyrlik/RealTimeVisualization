

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class DoRandomStuff {
    public DoRandomStuff() {
        long randomWaitTime = ((long) (((java.lang.Math.random()) * 2000) + 500));
        Logger.log("Begin object creation" , "java.util.ArrayList" , "anonymous", 0);;
        new java.util.ArrayList();
        Logger.log("End object creation" , "java.util.ArrayList" , "anonymous", 0);;
        try {
            java.lang.Thread.sleep(randomWaitTime);
        } catch (java.lang.Exception exception) {
            java.lang.System.out.println(exception);
        }
        Logger.log("Begin object creation" , "java.util.HashMap" , "myHashMap", 1);;
        java.util.HashMap myHashMap = new java.util.HashMap();
        Logger.log("End object creation" , "java.util.HashMap" , "myHashMap", 1);;
    }

    public char getRandomLetter() {
        java.lang.String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return letters.charAt(((int) ((java.lang.Math.random()) * (letters.length()))));
    }

    public java.lang.String getRandomWord(int size) {
        Logger.log("Begin object creation" , "java.lang.StringBuilder" , "word", 2);;
        java.lang.StringBuilder word = new java.lang.StringBuilder();
        Logger.log("End object creation" , "java.lang.StringBuilder" , "word", 2);;
        for (int i = 0; i < size; i++)
            word.append(getRandomLetter());
        
        return word.toString();
    }
}

