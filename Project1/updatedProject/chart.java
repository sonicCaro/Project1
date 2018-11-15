package myMath;

import java.io.IOException;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;



public class chart

{
	public static void main(String[] args) throws IOException {

		double[] xData = new double[] { 0.0, 1.0, 2.0 };
		double[] yData = new double[] { 2.0, 1.0, 0.0 };

		// Create Chart
		XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

		// Show it
		new SwingWrapper(chart).displayChart();

		// Save it
		BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);

		// or save it in high-res
		BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);
	
	}
	public void graph(double start, double end, double eps,Polynom p) throws IOException
	{
	
	double distance=((end-start)/eps)+1;	
		double[] xData=new double[(int)distance];
		double[] yData=new double[(int)distance];
	for(int i=0; i<distance ; i++){
		yData[i]=p.f(i*eps+start);
		xData[i]=i*eps+start;
			
		}
		
	// Create Chart
			XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

			// Show it
			new SwingWrapper(chart).displayChart();

			// Save it
			BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);

			// or save it in high-res
			BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);
		
		}
		
	}
	

