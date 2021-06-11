/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

/**
 *
 * @author GIA KINH
 */
public class TournamentIncome extends PlayerIncome implements GradeBonus{

    private int totalMatches;
    private int battle;
    private double[] points;
    
    

    public TournamentIncome(int totalMatches, int battle, double[] points, double income) {
        super(income);
        this.totalMatches = totalMatches;
        this.battle = battle;
        this.points = points;
    }

    public TournamentIncome(int totalMatches, int battle, double[] points, double income, String name) {
        super(income, name);
        this.totalMatches = totalMatches;
        this.battle = battle;
        this.points = points;
    }

    public TournamentIncome(int totalMatches, int battle, double[] points) {
        this.totalMatches = totalMatches;
        this.battle = battle;
        this.points = points;
    }
    
     public TournamentIncome(double income, String name) {
        super(income, name);
    }

    

    public TournamentIncome() {
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public int getBattle() {
        return battle;
    }

    public void setBattle(int battle) {
        this.battle = battle;
    }

    public double[] getPoints() {
        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }

       

    @Override
    public void displayDetails() {
        System.out.println("Name player: "+super.getName());
        System.out.println("Grade bonus: "+this.calculateGradeBonus() + "%");
        System.out.println("Salary: " + (super.getIncome() - super.calculateTax()));
        System.out.println("Tax: " + super.calculateTax());
    }

    @Override
    public double calculateGradeBonus() {
        double totalPoint = 0;
        if (points.length !=0) {
            for (double i: points) {
            totalPoint += i;
        }
        }
        if (totalPoint<this.totalMatches * 100 * 0.3) {
            return GRADE_D_BONUS_PERCENT; 
        }else if(totalPoint<this.totalMatches * 100 * 0.4){
            return GRADE_C_BONUS_PERCENT;
        }else if(totalPoint<this.totalMatches * 100 * 0.5){
            return GRADE_B_BONUS_PERCENT;
        }else{
            return GRADE_A_BONUS_PERCENT;
        }
    }
    
}
