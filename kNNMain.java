import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{
	  
	int max = 1000;  
	double [] accuracy = new double [max];
	double [] recall = new double [max]; 
	double [] precision = new double [max]; 
	
    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
   for (int j = 0; j < max; j++)
	{ 
	String PATH_TO_DATA = args[0];
	List<DataPoint> IrisList = DataSet.readDataSet(PATH_TO_DATA);
	/*
	//DataPoint IrisPoint = IrisList.get(5);
	//double [] values = IrisPoint.getX();
	//String label = IrisPoint.getLabel();
	
	//for(int i = 0; i < values.length; i++)
	{
		//System.out.println(values[i]);
	}
	
	//System.out.println(label);
	
    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	*/
	List<DataPoint> HeldOut = DataSet.getTestSet(IrisList, 0.30);
	List<DataPoint> Training = DataSet.getTrainingSet(IrisList, 0.70);
	
    /*// TASK 4: write a new method in DataSet.java which takes as arguments two DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
	
	double [] x = {0.0,0.0,0.0};
	double [] y = {0.0,3.0,4.0};
	
	DataPoint Iris1 = new DataPoint ("dog", y);
	DataPoint Iris2 = new DataPoint ("cat", x);
	
	double [] x1 = Iris1.getX();
	double [] y1 = Iris2.getX();
	
	double distance = DataSet.distanceEuclid(Iris1, Iris2);
	System.out.println(distance);
	for (int i = 1; i < x.length; i++)
	{
		System.out.println(x[i] + "\t" + y[i]);
	}
	*/
	
    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make it print a predicted target label
	
	KNNClassifier Test = new KNNClassifier(35);
	//String label1 = Test.predict(IrisList, IrisPoint);
	//System.out.println("The predicted class is " + label1);
	
    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.

	int ctr = 0;
	int sum = 0;
	int falseNegative = 0;
	int falsePositive = 0;
	
	for (int i = 0; i < HeldOut.size(); i++)
	{
		DataPoint point = HeldOut.get(i);
		String label2 = Test.predict(Training, point);
		//System.out.println(label2 + "\t" + point.getLabel());
		if (point.getLabel().equals(label2))
		{
			ctr++;
		}
		
		if (point.getLabel().equals("malignant") && label2.equals("malignant"))
		{
			sum++;
		}
		
	    else if(point.getLabel().equals("malignant") && label2.equals("benign"))
		{
			falseNegative++;
		}
		
		else if(point.getLabel().equals("benign") && label2.equals("malignant"))
	    {
			falsePositive++;
		}
	}
	//System.out.println("The accuracy of the prediciton is " + (((double)(ctr))/((double)(HeldOut.size()))));
	double percentage = 100.0 * ((double)(ctr))/((double)(HeldOut.size()));
	double rec = ((double)(sum))/(double)(sum+falseNegative);
	double prec = ((double)(sum))/(double)(sum+falsePositive);
	accuracy [j] = percentage;
	recall[j] = rec;
	precision[j] = prec;
	}
	
	double average = mean(accuracy);
	double SD = standardDeviation(accuracy);
	double Recall = mean(recall);
	double Precision = mean(precision);
	System.out.println("The mean is " + average); 
	System.out.println("The Standard Deviation is " + SD);
	System.out.println("The precision is " + Precision);
    System.out.println("The recall is " + Recall);	
}

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }
}
