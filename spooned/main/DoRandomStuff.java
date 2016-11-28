

package main;


public class DoRandomStuff {
    public void printRandomLetter() {
        java.lang.String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        java.lang.System.out.println(letters.charAt(((int) ((java.lang.Math.random()) * (letters.length())))));
    }
}

