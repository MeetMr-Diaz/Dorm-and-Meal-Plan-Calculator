import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DormMealCalculator extends JFrame {
    private JPanel totalPanel,dormPanel,mealPanel;
    private JComboBox dorm,meal;
    private JTextField mealText, dormText,totalCostText;
    private final double AllenHall = 1500;
    private final double PikeHall = 1600;
    private final double FarthingHall = 1200;
    private  final double UniSuites = 1800;
    private final double sevenMeals = 560;
    private final double fourteenMeals = 1095;
    private final double unlimitedMeals = 1500;
    private String[] hallsOptions = {"Allen Hall","Pike Hall","Farthing Hall","University Suites"};
    private String[] mealsOptions = {"7 Meals","14 Meals","unlimited Meals"};
    private double dormCost = 0;
    private double mealCost = 0;
    public DormMealCalculator(){
        setTitle("Dorm and Meal Plan Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buildDormPanel();
        buildMealPanel();
        totalCost();

        totalPanel = new JPanel();
        totalCostText = new JTextField(10);
        totalCostText.setEditable(false);
        totalPanel.add(new JLabel("Total Cost: $"));
        totalPanel.add(totalCostText);

        add(dormPanel,BorderLayout.NORTH);
        add(mealPanel,BorderLayout.CENTER);
        add(totalPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    public void buildMealPanel() {
        mealPanel = new JPanel();
        JLabel label1 = new JLabel("Pick Meal Plan");
        meal = new JComboBox(mealsOptions);
        meal.addActionListener(new mealComboBoxListener());
        mealText = new JTextField(15);
        mealText.setEditable(false);
        mealPanel.add(label1);
        mealPanel.add(meal);
        mealPanel.add(mealText);
    }
    private class mealComboBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selection = (String) meal.getSelectedItem();

            if (selection.equals("7 Meals")) {
                mealCost = sevenMeals;
            } else if (selection.equals("14 Meals")) {
                mealCost = fourteenMeals;
            } else if (selection.equals("unlimited Meals")) {
                mealCost = unlimitedMeals;
            }
            mealText.setText(String.valueOf(mealCost));
            totalCost();
        }
    }
    public void buildDormPanel() {
        dormPanel = new JPanel();
        JLabel dormLabel = new JLabel("Pick a Hall");
        dorm = new JComboBox(hallsOptions);
        dorm.addActionListener(new DormComboBoxListener());
        dormText = new JTextField(15);
        dormText.setEditable(false);
        dormPanel.add(dormLabel);
        dormPanel.add(dorm);
        dormPanel.add(dormText);
    }
    private  class DormComboBoxListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            String dormSelection = (String) dorm.getSelectedItem();
            if(dormSelection.equals("University Suites")){
                dormCost = UniSuites;
            } else if (dormSelection.equals("Pike Hall")) {
                dormCost=PikeHall ;
            } else if (dormSelection.equals("Allen Hall")) {
                dormCost=AllenHall ;
            } else if (dormSelection.equals("Farthing Hall")) {
                dormCost =FarthingHall ;
            }

            dormText.setText(String.valueOf(dormCost));
            totalCost();
        }
    }
    public void totalCost() {
        double total = dormCost + mealCost;
        if (totalCostText != null) {
            totalCostText.setText(String.format("%.2f", total));
        }
    }
    public static void main(String[] args) {
        new DormMealCalculator();
    }
}

