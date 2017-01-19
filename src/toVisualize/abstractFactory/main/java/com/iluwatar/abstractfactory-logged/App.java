

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class App {
    private King king;

    private Castle castle;

    private Army army;

    public void createKingdom(final KingdomFactory factory) {
        Logger.logBeginMethodCall("createKingdom");;
        setKing(factory.createKing());
        setCastle(factory.createCastle());
        setArmy(factory.createArmy());
        Logger.logEndMethodCall("createKingdom");;
    }

    King getKing(final KingdomFactory factory) {
        Logger.logBeginMethodCall("getKing");;
        Logger.logEndMethodCall("getKing");;
        return factory.createKing();
    }

    public King getKing() {
        Logger.logBeginMethodCall("getKing");;
        Logger.logEndMethodCall("getKing");;
        return king;
    }

    private void setKing(final King king) {
        Logger.logBeginMethodCall("setKing");;
        App.this.king = king;
        Logger.logEndMethodCall("setKing");;
    }

    Castle getCastle(final KingdomFactory factory) {
        Logger.logBeginMethodCall("getCastle");;
        Logger.logEndMethodCall("getCastle");;
        return factory.createCastle();
    }

    public Castle getCastle() {
        Logger.logBeginMethodCall("getCastle");;
        Logger.logEndMethodCall("getCastle");;
        return castle;
    }

    private void setCastle(final Castle castle) {
        Logger.logBeginMethodCall("setCastle");;
        App.this.castle = castle;
        Logger.logEndMethodCall("setCastle");;
    }

    Army getArmy(final KingdomFactory factory) {
        Logger.logBeginMethodCall("getArmy");;
        Logger.logEndMethodCall("getArmy");;
        return factory.createArmy();
    }

    public Army getArmy() {
        Logger.logBeginMethodCall("getArmy");;
        Logger.logEndMethodCall("getArmy");;
        return army;
    }

    private void setArmy(final Army army) {
        Logger.logBeginMethodCall("setArmy");;
        App.this.army = army;
        Logger.logEndMethodCall("setArmy");;
    }

    public static void main(java.lang.String[] args) {
        Logger.logBeginMethodCall("main");;
        Logger.logBeginObjectCreation(0);;
        App app = new App();
        Logger.logEndObjectCreation("App", 0, "app", 1);;
        java.lang.System.out.println("Elf Kingdom");
        Logger.logBeginObjectCreation(1);;
        app.createKingdom(new ElfKingdomFactory());
        Logger.logEndObjectCreation("ElfKingdomFactory", 1, "(App#createKingdom(KingdomFactory)(new ElfKingdomFactory#ElfKingdomFactory()))", 1);;
        java.lang.System.out.println(app.getArmy().getDescription());
        java.lang.System.out.println(app.getCastle().getDescription());
        java.lang.System.out.println(app.getKing().getDescription());
        java.lang.System.out.println("Orc Kingdom");
        Logger.logBeginObjectCreation(2);;
        app.createKingdom(new OrcKingdomFactory());
        Logger.logEndObjectCreation("OrcKingdomFactory", 2, "(App#createKingdom(KingdomFactory)(new OrcKingdomFactory#OrcKingdomFactory()))", 1);;
        java.lang.System.out.println(app.getArmy().getDescription());
        java.lang.System.out.println(app.getCastle().getDescription());
        java.lang.System.out.println(app.getKing().getDescription());
        Logger.logEndMethodCall("main");;
    }
}

