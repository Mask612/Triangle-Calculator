import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.math.*;

public class triangleUI extends JPanel implements ActionListener {
	//Panels
	private JPanel mainPanel;
	
	//button
	private JButton clearButton;
	private JButton solveButton;
	
	//Label
	private JLabel sideALabel;
	private JLabel sideBLabel;
	private JLabel sideCLabel;
	private JLabel angleALabel;
	private JLabel angleBLabel;
	private JLabel angleCLabel;
	private JLabel areaLabel;
	private JLabel area;
	
	
	//textfields
	private JTextField sideAField;
	private JTextField sideBField;
	private JTextField sideCField;
	private JTextField angleAField;
	private JTextField angleBField;
	private JTextField angleCField;	
	
	//variables for fields
	double sideA;
	double sideB;
	double sideC;
	double angleA;
	double angleB;
	double angleC;
	
	double toRadians = Math.PI/180;
	double toDegrees = 180/Math.PI;
	
	public triangleUI(){
		//add main panel
		mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(8,2));
		
		//add labels and textfields for sides and angles
		sideALabel = new JLabel("Side A");
		mainPanel.add(sideALabel);
		
		sideAField = new JTextField(10);
		mainPanel.add(sideAField);
		
		sideBLabel = new JLabel("Side B");
		mainPanel.add(sideBLabel);
		
		sideBField = new JTextField(10);
		mainPanel.add(sideBField);
		
		sideCLabel = new JLabel("Side C");
		mainPanel.add(sideCLabel);
		
		sideCField = new JTextField(10);
		mainPanel.add(sideCField);
		
		angleALabel = new JLabel("Angle A");
		mainPanel.add(angleALabel);
		
		angleAField = new JTextField(10);
		mainPanel.add(angleAField);
		
		angleBLabel = new JLabel("Angle B");
		mainPanel.add(angleBLabel);
		
		angleBField = new JTextField(10);
		mainPanel.add(angleBField);
		
		angleCLabel = new JLabel("Angle C");
		mainPanel.add(angleCLabel);
		
		angleCField = new JTextField(10);
		mainPanel.add(angleCField);
		
		//area label and display
		areaLabel = new JLabel("Area:");
		mainPanel.add(areaLabel);
		
		//will be filled in with calculations
		area = new JLabel("");
		mainPanel.add(area);
		
		
		//add blank label and button so button is on right
		
		clearButton = new JButton("clear");
		mainPanel.add(clearButton);
		clearButton.addActionListener(this);
		
		solveButton = new JButton("Solve");
		mainPanel.add(solveButton);
		solveButton.addActionListener(this);
		
	}
	
	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == this.solveButton) {
			//this function sets inputed variables
			initialize();
		}
		
		else if (e.getSource() == this.clearButton) {
			//clear all fields
			sideAField.setText("");
			sideBField.setText("");
			sideCField.setText("");
			angleAField.setText("");
			angleBField.setText("");
			angleCField.setText("");
			area.setText("");
		}
	}
	
	public void initialize(){
		//gets enter sides/angles and inputs them to doubles
		//if no input the variables are set to 0
		//initialize side A
		if (sideAField.getText() != null && !sideAField.getText().isEmpty()) {
		    sideA = Float.parseFloat(sideAField.getText());
		}
		else{
			sideA = 0;
		}
		//initialize side B
		if (sideBField.getText() != null && !sideBField.getText().isEmpty()) {
		    sideB = Float.parseFloat(sideBField.getText());
		}
		else{
			sideB = 0;
		}
		//initialize side C
		if (sideCField.getText() != null && !sideCField.getText().isEmpty()) {
		    sideC = Float.parseFloat(sideCField.getText());
		}
		else{
			sideC = 0;
		}
		//initialize angle A
		if (angleAField.getText() != null && !angleAField.getText().isEmpty()) {
		    angleA = Float.parseFloat(angleAField.getText());
		}
		else{
			angleA = 0;
		}
		//initialize angle B
		if (angleBField.getText() != null && !angleBField.getText().isEmpty()) {
		    angleB = Float.parseFloat(angleBField.getText());
		}
		else{
			angleB = 0;
		}
		//initialize angle C
		if (angleCField.getText() != null && !angleCField.getText().isEmpty()) {
		    angleC = Float.parseFloat(angleCField.getText());
		}
		else{
			angleC = 0;
		}
		//go on to solve
		solve();
		//tests to make sure variables are correctly read
		System.out.println("Angle A: " + angleA + "\tAngle B: " + angleB + "\tAngle C: " + angleC);
		System.out.println("Side A: " + sideA + "\tSide B: " + sideB + "\tSide C: " + sideC);
	}
	
	public void solve(){
		int i;
		//iterate through equations until all values are solved if possible 
		//3 fields must have values to solve, at least 1 side and angle
		//all values are sent the the round() function before being assigned
		for(i=0; i<5; i++){
		//first get remaining angles if possible
		if(angleA == 0 && angleB > 0 && angleC > 0){
			angleA = 180 - angleB - angleC;
			angleAField.setText(String.valueOf(angleA));
		}
		if(angleB == 0 && angleA > 0 && angleC > 0){
			angleB = 180 - angleA - angleC;
			angleBField.setText(String.valueOf(angleB));
		}
		if(angleC == 0 && angleB > 0 && angleA > 0){
			angleC = 180 - angleB - angleA;
			angleCField.setText(String.valueOf(angleC));
		}
		
		//////////////////////////////////////////////////////////
		//law of cosines
		//side c
		if(sideC == 0 && sideA > 0 && sideB > 0 && angleC > 0){
			sideC = round(Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - 2 * sideA * sideB * Math.cos(angleC*toRadians)));
			sideCField.setText(String.valueOf(sideC));
		}
		//side b
		if(sideB == 0 && sideA > 0 && sideC > 0 && angleB > 0){
			sideB = round(Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideC, 2) - 2 * sideA * sideC * Math.cos(angleB*toRadians)));
			sideBField.setText(String.valueOf(sideB));
		}
		//side a
		if(sideA == 0 && sideC > 0 && sideB > 0 && angleA > 0){
			sideA = round(Math.sqrt(Math.pow(sideC, 2) + Math.pow(sideB, 2) - 2 * sideC * sideB * Math.cos(angleA*toRadians)));
			sideAField.setText(String.valueOf(sideA));
		}
		
		//angle C
		if (angleC == 0 && sideA > 0 && sideB > 0 && sideC > 0){
			angleC = round(Math.acos(((Math.pow(sideA, 2) + Math.pow(sideB, 2) - Math.pow(sideC, 2))/(2*sideA*sideB)))*toDegrees);
			angleCField.setText(String.valueOf(angleC));
		}
		//angle B
				if (angleB == 0 && sideA > 0 && sideB > 0 && sideC > 0){
					angleB = round(Math.acos(((Math.pow(sideA, 2) - Math.pow(sideB, 2) + Math.pow(sideC, 2))/(2*sideA*sideC)))*toDegrees);
					angleBField.setText(String.valueOf(angleB));
				}
		//angle A
		if (angleA == 0 && sideA > 0 && sideB > 0 && sideC > 0){
			angleA = round(Math.acos(((-Math.pow(sideA, 2) + Math.pow(sideB, 2) + Math.pow(sideC, 2))/(2*sideC*sideB)))*toDegrees);
			angleAField.setText(String.valueOf(angleA));
		}		
		
		
		
		/////////////////////////////////////////////////////////////
		//check law of sines
		
				//side A with law of sines
				if (sideA == 0 && angleA > 0 && sideB > 0 && angleB > 0){
					sideA = round(Math.sin(angleA*toRadians)*sideB/Math.sin(angleB*toRadians));
					sideAField.setText(String.valueOf(sideA));
				}
				if (sideA == 0 && angleA > 0 && sideC > 0 && angleC > 0){
					sideA = round(Math.sin(angleA*toRadians)*sideC/Math.sin(angleC*toRadians));
					sideAField.setText(String.valueOf(sideA));
				}
				//side B with law of sines
				if (sideB == 0 && angleB > 0 && sideA > 0 && angleA > 0){
					sideB = round(Math.sin(angleB*toRadians)*sideA/Math.sin(angleA*toRadians));
					sideBField.setText(String.valueOf(sideB));
				}
				if (sideB == 0 && angleB > 0 && sideC > 0 && angleC > 0){
					sideB = round(Math.sin(angleB*toRadians)*sideC/Math.sin(angleC*toRadians));
					sideBField.setText(String.valueOf(sideB));
				}
				//side C with law of sines
				if (sideC == 0 && angleC > 0 && sideB > 0 && angleB > 0){
					sideC = round(Math.sin(angleC*toRadians)*sideB/Math.sin(angleB*toRadians));
					sideCField.setText(String.valueOf(sideC));
				}
				if (sideC == 0 && angleC > 0 && sideA > 0 && angleA > 0){
					sideC = round(Math.sin(angleC*toRadians)*sideA/Math.sin(angleA*toRadians));
					sideCField.setText(String.valueOf(sideC));
				}
				
				//angle A with law of sines
				if(angleA == 0 && sideA > 0 && sideB > 0 && angleB > 0){
					angleA = round(Math.asin((sideA*Math.sin(angleB*toRadians)/sideB))*toDegrees);
					angleAField.setText(String.valueOf(angleA));
				}
				//angle A with law of sines
				if(angleA == 0 && sideA > 0 && sideC > 0 && angleC > 0){
					angleA = round(Math.asin(sideA*Math.sin(angleC*toRadians)/sideC)*toDegrees);
					angleAField.setText(String.valueOf(angleA));
				}
				//angle B with law of sines
				if(angleB == 0 && sideB > 0 && sideA > 0 && angleA > 0){
					angleB = round(Math.asin(sideB*Math.sin(angleA*toRadians)/sideA)*toDegrees);
					angleBField.setText(String.valueOf(angleB));
				}
				//angle B with law of sines
				if(angleB == 0 && sideB > 0 && sideC > 0 && angleC > 0){
					angleB = round(Math.asin(sideB*Math.sin(angleC*toRadians)/sideC)*toDegrees);
					angleBField.setText(String.valueOf(angleB));
				}
				//angle C with law of sines
				if(angleC == 0 && sideC > 0 && sideB > 0 && angleB > 0){
					angleC = round(Math.asin(sideC*Math.sin(angleB*toRadians)/sideB)*toDegrees);
					angleCField.setText(String.valueOf(angleC));
				}
				//angle C with law of sines
				if(angleC == 0 && sideC > 0 && sideA > 0 && angleA > 0){
					angleC = round(Math.asin(sideC*Math.sin(angleA*toRadians)/sideA)*toDegrees);
					angleCField.setText(String.valueOf(angleC));
				}
			}//for loop
			
			//check if solved, if not give error
			if (sideA == 0 || sideB == 0 || sideC == 0 || angleA == 0 || angleB == 0 || angleC == 0){
				JOptionPane.showMessageDialog(null, "Not enough information given", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			}
			getArea();
	}
	//if you get .999 repeating round up
	public double round(double number){
		if(number > (int)number + 0.999){
			number = (int)number + 1;
		}
		//if number has .000001 round down
		else if(number < (int)number + .0001){
			number = (int)number;
		}
		//round to 5 decimal places if long decimal
		else if (number > (int)number + .001 && number < (int)number + 0.999){
			number = (double)Math.round(number * 10000d) / 10000d;
			//number = (float)number;
		}
		
		return number;
	}
	public void getArea(){
		//herons formula for area
		double k;
		double s;
		s = .5*(sideA+sideB+sideC);
		k = Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
		k = round(k);
		area.setText(String.valueOf(k));
		
	}
}
