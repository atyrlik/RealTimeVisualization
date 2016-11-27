

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class TestA {
    public TestA() {
        System.out.println("Begin java.lang.String creation");
        new java.lang.String();
        System.out.println("End java.lang.String creation");
        System.out.println("Begin java.lang.String o1 creation");
        java.lang.String o1 = new java.lang.String();
        System.out.println("End java.lang.String o1 creation");
        System.out.println("Begin java.lang.Object o creation");
        java.lang.Object o = new java.lang.Object();
        System.out.println("End java.lang.Object o creation");
    }

    public static void main(java.lang.String[] args) {
        System.out.println("Begin TestA t creation");
        TestA t = new TestA();
        System.out.println("End TestA t creation");
    }
}

