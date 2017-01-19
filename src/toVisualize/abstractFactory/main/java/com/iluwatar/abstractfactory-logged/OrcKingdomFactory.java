

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class OrcKingdomFactory implements KingdomFactory {
    public Castle createCastle() {
        Logger.logBeginMethodCall("createCastle");;
        Logger.logBeginObjectCreation(6);;
        OrcCastle t = new OrcCastle();
        Logger.logEndObjectCreation("OrcCastle", 6, "t", 1);;
        Logger.logEndMethodCall("createCastle");;
        return t;
    }

    public King createKing() {
        Logger.logBeginMethodCall("createKing");;
        Logger.logBeginObjectCreation(7);;
        OrcKing t = new OrcKing();
        Logger.logEndObjectCreation("OrcKing", 7, "t", 1);;
        Logger.logEndMethodCall("createKing");;
        return t;
    }

    public Army createArmy() {
        Logger.logBeginMethodCall("createArmy");;
        Logger.logBeginObjectCreation(8);;
        OrcArmy t = new OrcArmy();
        Logger.logEndObjectCreation("OrcArmy", 8, "t", 1);;
        Logger.logEndMethodCall("createArmy");;
        return t;
    }
}

