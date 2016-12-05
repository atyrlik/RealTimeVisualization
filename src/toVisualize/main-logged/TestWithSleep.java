

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class TestWithSleep {
    public static int numberOfSleep = 0;

    public static void main(java.lang.String[] args) {
        Logger.logBeginMethodCall("main");;
        java.lang.System.out.println("Begin program!");
        for (int i = 0; i < 10; i++) {
            Logger.logBeginObjectCreation(3);;
            DoRandomStuff rand = new DoRandomStuff();
            Logger.logEndObjectCreation("DoRandomStuff", 3);;
            java.lang.System.out.println(rand.getRandomLetter());
            try {
                java.lang.Thread.sleep(1000);
                (TestWithSleep.numberOfSleep)++;
            } catch (java.lang.Exception exception) {
                java.lang.System.out.println(exception);
            }
        }
        java.lang.System.out.println("End program");
    }
}

