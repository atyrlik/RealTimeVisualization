/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


public class App {


  private King king;
  private Castle castle;
  private Army army;

  /**
   * Creates kingdom
   */
  public void createKingdom(final KingdomFactory factory) {
    setKing(factory.createKing());
    setCastle(factory.createCastle());
    setArmy(factory.createArmy());
  }

  King getKing(final KingdomFactory factory) {
    return factory.createKing();
  }

  public King getKing() {
    return king;
  }

  private void setKing(final King king) {
    this.king = king;
  }
  
  Castle getCastle(final KingdomFactory factory) {
    return factory.createCastle();
  }

  public Castle getCastle() {
    return castle;
  }

  private void setCastle(final Castle castle) {
    this.castle = castle;
  }
  
  Army getArmy(final KingdomFactory factory) {
    return factory.createArmy();
  }

  public Army getArmy() {
    return army;
  }

  private void setArmy(final Army army) {
    this.army = army;
  }
  
  /**
   * Program entry point
   * 
   * @param args
   *          command line args
   */
  public static void main(String[] args) {

    App app = new App();

    System.out.println("Elf Kingdom");
    app.createKingdom(new ElfKingdomFactory());
    System.out.println(app.getArmy().getDescription());
    System.out.println(app.getCastle().getDescription());
    System.out.println(app.getKing().getDescription());

    System.out.println("Orc Kingdom");
    app.createKingdom(new OrcKingdomFactory());
    System.out.println(app.getArmy().getDescription());
    System.out.println(app.getCastle().getDescription());
    System.out.println(app.getKing().getDescription());

  }

}
