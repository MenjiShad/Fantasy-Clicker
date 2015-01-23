
public class FantasyViewer 
{

 // variables
 private static int totalGoldCounter = 0;    // Keeps track of total gold earned
 private int goldCounter = 0;
 private int income = 1;
 private int elfCount = 0;
 private int elfCost = 50;
 private int fairyCount = 0;
 private int fairyCost = 90;
 private int dwarfCount = 0;
 private int dwarfCost = 150;
 private int orcCount = 0;
 private int orcCost = 400;
 private int princessCount = 0;
 private int princessCost = 1200;
 private int princeCount = 0;
 private int princeCost = 1500;
 private int castleCount = 0;
 private int castleCost = 9000;
 
 // Total amount of gold
 public int getTotalGold()
 {
  return totalGoldCounter;
 }
 
 // Updates totalGoldCounter each time gold is earned
 public void totalGoldUpdate()
 {
  totalGoldCounter = totalGoldCounter + income;
 }
 
 // Current amount of gold
 public int getGoldCounter()
 {
  return goldCounter;
 }
 
 // gold per second/click
 public int getIncome()
 {
  return income;
 }
 
 // updates the counter
 public void incrementGoldCounter()
 {
  goldCounter = goldCounter + income;
 }
 
 // returns number of elves
 public int getElfCount()
 {
  return elfCount;
 }
 
 // returns how much an elf costs
 public int getElfCost()
 {
  return elfCost;
 }
 
 // Purchases an elf which raises income by 2 and cost by 10
 // subtract cost funds from gold
 // should check to see if player has enough to purchase an elf
 public void purchaseElf()
 {
  if (goldCounter >= elfCost)
  {
   elfCount++;
   goldCounter = goldCounter - elfCost;
   elfCost = elfCost + 40;
   income = income + 2;
  }
 }
 
 // returns # of fairies
 public int getFairyCount()
 {
  return fairyCount;
 }
 
 // returns cost of a fairy
 public int getFairyCost()
 {
  return fairyCost;
 }
 
 // purchases a fairy
 public void purchaseFairy()
 {
  if (goldCounter >= fairyCost)
  {
   fairyCount++;
   goldCounter = goldCounter - fairyCost;
   fairyCost = fairyCost + 75;
   income = income + 5;
  }
 }
 
 public int getDwarfCount()
 {
  return dwarfCount;
 }
 
 public int getDwarfCost()
 {
  return dwarfCost;
 }
 
 public void purchaseDwarf()
 {
  if (goldCounter >= dwarfCost)
  {
   dwarfCount++;
   goldCounter = goldCounter - dwarfCost;
   dwarfCost = dwarfCost + 130;
   income = income + 10;
  }
 }
 
 public int getOrcCount()
 {
  return orcCount;
 }
 
 public int getOrcCost()
 {
  return orcCost;
 }
 
 public void purchaseOrc()
 {
  if (goldCounter >= orcCost)
  {
   orcCount++;
   goldCounter = goldCounter - orcCost;
   orcCost = orcCost + 345;
   income = income + 25;
  }
 }
 
 public int getPrincessCount()
 {
  return princessCount;
 }
 
 public int getPrincessCost()
 {
  return princessCost;
 }
 
 public void purchasePrincess()
 {
  if (goldCounter >= princessCost)
  {
   princessCount++;
   goldCounter = goldCounter - princessCost;
   princessCost = princessCost + 1800;
   income = income + 100;
  }
 }
 
 public int getPrinceCount()
 {
  return princeCount;
 }
 
 public int getPrinceCost()
 {
  return princeCost;
 }
 
 public void purchasePrince()
 {
  if (goldCounter >= princeCost)
  {
   princeCount++;
   goldCounter = goldCounter - princeCost;
   princeCost = princeCost + 2000;
   income = income + 150;
  }
 }
 
 public int getCastleCount()
 {
  return castleCount;
 }
 
 public int getCastleCost()
 {
  return castleCost;
 }
 
 public void purchaseCastle()
 {
  if (goldCounter >= castleCost)
  {
   castleCount++;
   goldCounter = goldCounter - castleCost;
   castleCost = castleCost + 7650;
   income = income + 500;
  }
 }
}
