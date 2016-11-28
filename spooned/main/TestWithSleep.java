

package main;


public class TestWithSleep {
    public static void main(java.lang.String[] args) {
        java.lang.System.out.println("Begin program!");
        for (int i = 0; i < 10; i++) {
            System.out.println("Begin main.DoRandomStuff rand creation");
            main.DoRandomStuff rand = new main.DoRandomStuff();
            System.out.println("End main.DoRandomStuff rand creation");
            rand.printRandomLetter();
            try {
                java.lang.Thread.sleep(2000);
            } catch (java.lang.Exception exception) {
                java.lang.System.out.println(exception);
            }
        }
        java.lang.System.out.println("End program");
    }
}

