

// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class ElfKingdomFactory implements KingdomFactory {
    public Castle createCastle() {
        Logger.logBeginMethodCall("createCastle");;
        Logger.logBeginObjectCreation(3);;
        ElfCastle t = new ElfCastle();
        Logger.logEndObjectCreation("ElfCastle", 3, "t", 1);;
        Logger.logEndMethodCall("createCastle");;
        return t;
    }

    public King createKing() {
        Logger.logBeginMethodCall("createKing");;
        Logger.logBeginObjectCreation(4);;
        ElfKing t = new ElfKing();
        Logger.logEndObjectCreation("ElfKing", 4, "t", 1);;
        Logger.logEndMethodCall("createKing");;
        return t;
    }

    public Army createArmy() {
        Logger.logBeginMethodCall("createArmy");;
        Logger.logBeginObjectCreation(5);;
        ElfArmy t = new ElfArmy();
        Logger.logEndObjectCreation("ElfArmy", 5, "t", 1);;
        Logger.logEndMethodCall("createArmy");;
        return t;
    }
}

