Fantasy-Clicker
===============

Summer 2013 Project -unfinished- -abandoned-
===============

Main Driver
===============
/**
 *  Fantasy Clicker main
 *  Mouse click = increment "Fantasy" counter by x value
 *  Every second, update Fantasy Counter
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class mainDriver 
{

 // variables
 private static int frameWidth = 800;
 private static int frameHeight = 600;
 
 public static void main(String[] args)
 {
  JFrame frame = new JFrame();
  
  JButton goldButton = new JButton("Gold!"); 
  JButton purchaseElfButton = new JButton("Purchase Elf (2 Income)");
  JButton purchaseFairyButton = new JButton("Purchase Fairy (5 Income)");
  JButton purchaseDwarfButton = new JButton("Purchase Dwarf (10 Income)");
  JButton purchaseOrcButton = new JButton("Purchase Orc (25 Income)");
  JButton purchasePrincessButton = new JButton("Purchase Princess (100 Income)"); 
  JButton purchasePrinceButton = new JButton("Purchase Prince (150 Income)");
  JButton purchaseCastleButton = new JButton("Purchase Castle (500 Income)");
  
  // final variables in order to use these variables/objects 
  // in the "inner" classes
  final FantasyViewer viewer = new FantasyViewer();
  
  final JLabel goldLabel = new JLabel("Gold in Bank: " + viewer.getGoldCounter()); 
  final JLabel incomeLabel = new JLabel("Income: " + viewer.getIncome());
  final JLabel totalGoldLabel = new JLabel("Total Gold Earned: " + viewer.getTotalGold());
  
  final JLabel elfLabel = new JLabel("Elves: " + viewer.getElfCount());
  final JLabel elfCostLabel = new JLabel("Elf Cost: " + viewer.getElfCost());
  
  final JLabel fairyLabel = new JLabel("Fairies: " + viewer.getFairyCount());
  final JLabel fairyCostLabel = new JLabel("Fairy Cost: " + viewer.getFairyCost());
  
  final JLabel dwarfLabel = new JLabel("Dwarves: " + viewer.getDwarfCount());
  final JLabel dwarfCostLabel = new JLabel("Dwarf Cost: " + viewer.getDwarfCost());
  
  final JLabel orcLabel = new JLabel("Orcs: " + viewer.getOrcCount());
  final JLabel orcCostLabel = new JLabel("Orc Cost: " + viewer.getOrcCost());
  
  final JLabel princessLabel = new JLabel("Princesses: " + viewer.getPrincessCount());
  final JLabel princessCostLabel = new JLabel("Princess Cost: " + viewer.getPrincessCost());
  
  final JLabel princeLabel = new JLabel("Princes: " + viewer.getPrinceCount());
  final JLabel princeCostLabel = new JLabel("Prince Cost: " + viewer.getPrinceCost());
  
  final JLabel castleLabel = new JLabel("Castles: " + viewer.getCastleCount());
  final JLabel castleCostLabel = new JLabel("Castle Cost: " + viewer.getCastleCost());
  
  final int horizontalGap = 10;
  final int verticalGap = 10;
  
  JPanel innerPanel = new JPanel();
  JPanel outerPanel = new JPanel();
  JPanel subPanelTop = new JPanel();
  innerPanel.setLayout(new GridLayout(7, 3));
  outerPanel.setLayout(new BorderLayout(horizontalGap, verticalGap));
  
  // add the components to the panel/frame
  outerPanel.add(goldButton, BorderLayout.LINE_START);
  subPanelTop.add(goldLabel);
  subPanelTop.add(incomeLabel);
  subPanelTop.add(totalGoldLabel);
  innerPanel.add(purchaseElfButton);
  innerPanel.add(elfLabel);
  innerPanel.add(elfCostLabel);
  innerPanel.add(purchaseFairyButton);
  innerPanel.add(fairyLabel);
  innerPanel.add(fairyCostLabel);
  innerPanel.add(purchaseDwarfButton);
  innerPanel.add(dwarfLabel);
  innerPanel.add(dwarfCostLabel);
  innerPanel.add(purchaseOrcButton);
  innerPanel.add(orcLabel);
  innerPanel.add(orcCostLabel);
  innerPanel.add(purchasePrincessButton);
  innerPanel.add(princessLabel);
  innerPanel.add(princessCostLabel);
  innerPanel.add(purchasePrinceButton);
  innerPanel.add(princeLabel);
  innerPanel.add(princeCostLabel);
  innerPanel.add(purchaseCastleButton);
  innerPanel.add(castleLabel);
  innerPanel.add(castleCostLabel);
  outerPanel.add(innerPanel, BorderLayout.LINE_END);
  outerPanel.add(subPanelTop, BorderLayout.PAGE_START);
  frame.add(outerPanel);
  
  // On "Gold!" button press, increment counter
  class AddGoldListener implements ActionListener
  {
   public void actionPerformed(ActionEvent event)
   {
    viewer.incrementGoldCounter();
    viewer.totalGoldUpdate();
    goldLabel.setText("Gold in Bank: " + viewer.getGoldCounter());
    totalGoldLabel.setText("Total Gold Earned: " + viewer.getTotalGold());
   }
  }
  
  // Updates the amount of gold constantly
  class GoldUpdater implements ActionListener
  {
   // Use timer to vary the color of the Gold Label
   int colorChanger = 0;
   Color indigo = new Color(75,0,130);
   Color violet = new Color(111,0,255);
   
   public void actionPerformed(ActionEvent e)
   {
    goldLabel.setText("Gold in Bank: " + viewer.getGoldCounter());

    switch (colorChanger)
    {
    case 0: goldLabel.setForeground(Color.RED);
      colorChanger++;
      break;
    case 1: goldLabel.setForeground(Color.ORANGE);
      colorChanger++;
      break;
    case 2: goldLabel.setForeground(Color.YELLOW);
      colorChanger++;
      break;
    case 3: goldLabel.setForeground(Color.GREEN);
      colorChanger++;
      break;
    case 4: goldLabel.setForeground(Color.BLUE);
      colorChanger++;
      break;
    case 5: goldLabel.setForeground(indigo);
      colorChanger++;
      break;
    case 6: goldLabel.setForeground(violet);
      colorChanger = 0;
      break;
    }
   }
  }
  
  // Updates the counter by the increment factor every second
  class GoldPerSecondTimer implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    viewer.incrementGoldCounter();
    viewer.totalGoldUpdate();
    goldLabel.setText("Gold in Bank: " + viewer.getGoldCounter());
    totalGoldLabel.setText("Total Gold Earned: " + viewer.getTotalGold());
   }
  }
  
  // Purchases an elf
  class AddElfListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    viewer.purchaseElf();
    incomeLabel.setText("Income: " + viewer.getIncome());
    elfLabel.setText("Elves: " + viewer.getElfCount());
    elfCostLabel.setText("Elf Cost: " + viewer.getElfCost());
   }
  }
  
  //Purchases a fairy
  class AddFairyListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    viewer.purchaseFairy();
    incomeLabel.setText("Income: " + viewer.getIncome());
    fairyLabel.setText("Fairies: " + viewer.getFairyCount());
    fairyCostLabel.setText("Fairy Cost: " + viewer.getFairyCost()); 
   }
  }
  
  //Purchases a dwarf
  class AddDwarfListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    viewer.purchaseDwarf();
    incomeLabel.setText("Income: " + viewer.getIncome());
    dwarfLabel.setText("Dwarves: " + viewer.getDwarfCount());
    dwarfCostLabel.setText("Dwarf Cost: " + viewer.getDwarfCost());
   }
  }
  
  //Purchases an orc
  class AddOrcListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    viewer.purchaseOrc();
    incomeLabel.setText("Income: " + viewer.getIncome());
    orcLabel.setText("Orcs: " + viewer.getOrcCount());
    orcCostLabel.setText("Orc Cost: " + viewer.getOrcCost());
   }
  }
  
  //Purchases a princess
  class AddPrincessListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    viewer.purchasePrincess();
    incomeLabel.setText("Income: " + viewer.getIncome());
    princessLabel.setText("Princesses: " + viewer.getPrincessCount());
    princessCostLabel.setText("Princess Cost: " + viewer.getPrincessCost());
   }
  }
  
  //Purchases a prince
  class AddPrinceListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    viewer.purchasePrince();
    incomeLabel.setText("Income: " + viewer.getIncome());
    princeLabel.setText("Princes: " + viewer.getPrinceCount());
    princeCostLabel.setText("Prince Cost: " + viewer.getPrinceCost());
   }
  }
  
  // Purchases a castle
  class AddCastleListener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
    viewer.purchaseCastle();
    incomeLabel.setText("Income: " + viewer.getIncome());
    castleLabel.setText("Castles: " + viewer.getCastleCount());
    castleCostLabel.setText("Castle Cost: " + viewer.getCastleCost());
   }
  }
  
  // ActionListener objects
  // Counter
  ActionListener counterListener = new AddGoldListener();
  goldButton.addActionListener(counterListener);
  
  // Updater
  ActionListener updater = new GoldUpdater();
  final int updateTimer = 175; //ms delays, allowing amount to be updated very quickly
  Timer update = new Timer(updateTimer, updater);
  update.start();
  
  // Gold Per Second
  ActionListener timer = new GoldPerSecondTimer();
  final int delay = 1000; //millisecond delay between timer ticks
  Timer GoldperSecond = new Timer(delay, timer);
  GoldperSecond.start(); 
  
  // Elves
  ActionListener elfListener = new AddElfListener();
  purchaseElfButton.addActionListener(elfListener);
  
  // Fairies
  ActionListener fairyListener = new AddFairyListener();
  purchaseFairyButton.addActionListener(fairyListener);
  
  // Dwarves
  ActionListener dwarfListener = new AddDwarfListener();
  purchaseDwarfButton.addActionListener(dwarfListener);

  // Orcs
  ActionListener orcListener = new AddOrcListener();
  purchaseOrcButton.addActionListener(orcListener);
  
  // Princesses
  ActionListener princessListener = new AddPrincessListener();
  purchasePrincessButton.addActionListener(princessListener);
  
  // Princes
  ActionListener princeListener = new AddPrinceListener();
  purchasePrinceButton.addActionListener(princeListener);
  
  // Castles
  ActionListener castleListener = new AddCastleListener();
  purchaseCastleButton.addActionListener(castleListener);
  
  // Frame
  frame.setSize(frameWidth, frameHeight);
  frame.setTitle("Fantasy Clicker");
  frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
  frame.setVisible(true);
 }

}
Fantasy Viewer
===============
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


