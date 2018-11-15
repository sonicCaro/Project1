package myMath;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class Draw_Polynom {


	public static void main(String[] args) throws Exception {
		// Polynom p = 0.2x^4-1.5x^3+3.0x^2-x-5
		Polynom_able p = new Polynom("-5 + -x + 3x^2 + -1.5x^3 + 0.2x^4");
		//Copy of Polynom
		Polynom_able p2 = new Polynom("-5 + -x + 3x^2 + -1.5x^3 + 0.2x^4");
		System.out.println("polynom p(x): "+p.toString());
		//axis X
		double [] X1 = new double[] {-4,0,10};
		double [] X2 = new double[] {0,0.0,0};
		//axis Y
		double [] Y1 = new double[] {0,0,0};
		double [] Y2 = new double[] {-6.5,0.0,28};

		//An array of x values at each point
		double[] xData = new double[80] ;
		double point = -2.0;
		for (int i = 0; i < xData.length; i++) {
			xData[i] = point;
			point = point + 0.1;
		}

		//An array of y values at each point
		double[] yData = new double[80];
		for (int i = 0; i < xData.length; i++) {
			yData[i] = p.f(xData[i]);
		}

	   //**Finding extreme and Intersection points**//
		
		p2.derivative();
		System.out.println("(p)' ="+p2.derivative());
		
		
		//X value at Intersection with the axis Point1
		double [] xp1 = new double[1];
		xp1[0] = p2.root(-3, 1.5, 0.01);
		
		//X value at Intersection with the axis Point2
		double [] xp4 = new double[1];
		xp4[0]=p2.root(3, 5, 0.01);
		
		//X value at extreme point 1
		double [] xp2 = new double[1];
		xp2[0]= p2.root(1, 2, 0.01);
		
		//X value at extreme point 2
		double [] xp3 = new double[1];
		xp3[0] = p2.root(3.5, 4, 0.01);
		
		//X value at extreme point 3
		double [] xp5=new double[1];
		xp5[0]=p2.root(-0.4, 0.3, 0.01);

		//Y value at Intersection with the axis Point1
		double [] yp1 = new double[1];
		yp1[0] = p.f(xp1[0]);
		
		//Y value at Intersection with the axis Point2
		double [] yp4=new double[1];
		yp4[0]=p.f(xp4[0]);
		
		//Y value at extreme point 1
		double [] yp2 = new double[1];
		yp2[0] = p.f(xp2[0]);
		
		//Y value at extreme point 2
		double [] yp3 = new double[1];
		yp3[0] = p.f(xp3[0]);
		
		//Y value at extreme point 3
		double []yp5=new double[1];
		yp5[0]=p.f(xp5[0]);
		
		
		//Extreme point 1
		System.out.println("Extreme Point1: ("+xp3[0]+" ,"+yp3[0]+")"); 
		//Extreme point 2
		System.out.println("Extreme Point2: ("+xp2[0]+" ,"+yp2[0]+")");
		//Extreme point 3
		System.out.println("Extreme Point3: ("+xp5[0]+" ,"+yp5[0]+")");
		//Intersection with the axis
		System.out.println("Intersection with the axis point1: ("+xp1[0]+" ,"+yp1[0]+")");
		//Intersection with the axis
		System.out.println("Intersection with the axis point2: ("+xp4[0]+" ,"+yp4[0]+")");

		//***area***//
		//Calculates the area above the function and under the x axis
		double root1 =  p.root(4, 5, 0.01);
		double root2 = p.root(-1, 0, 0.01);
		System.out.println("area for p(x): "+Math.abs(p.area(root2, root1, 0.01)));
		
		// Create Chart
		XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "p(x)", xData, yData);
		chart.addSeries("Intersection Point1",xp1,yp1);
		chart.addSeries("Intersection Point2", xp4, yp4);
		chart.addSeries("Extreme Point1", xp2, yp2);
		chart.addSeries("Extreme Point2", xp3, yp3);
		chart.addSeries("Extreme Point3", xp5, yp5);
		chart.addSeries("Line X", X1, X2);
		chart.addSeries("Line Y", Y1, Y2); 

		// Displays the Chart
		new SwingWrapper(chart).displayChart(); 
		
		// Save it
		BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);

	
		// or save it in high-res
		BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);

	} 
}
