

package main;


public class TestWithSleep {
    public static void main(java.lang.String[] args) {
        java.lang.System.out.println("Let's creating 10 objects!");
        for (int i = 0; i < 10; i++) {
            System.out.println("Begin java.lang.Object creation");
            new java.lang.Object();
            System.out.println("End java.lang.Object creation");
            try {
                java.lang.Thread.sleep(2000);
            } catch (java.lang.Exception exception) {
                java.lang.System.out.println(exception);
            }
        }
        java.lang.System.out.println("All objects have been created!");
    }
}

