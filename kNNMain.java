import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{
	
	double[] accuracy=new double[1000];
	int Nbr=5;
	int maxRuns=1000;
	
	for(int j=0; j<maxRuns;j++){
    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	String PATH_TO_DATA = args[0];
	
	List<DataPoint> List_Data = DataSet.readDataSet(PATH_TO_DATA);
	DataPoint dataPoint = List_Data.get(5);
	/*
	double[] values = dataPoint.getX();
	String Label = dataPoint.getLabel();
	
	
	for(int i=0; i<values.length; i++){
		System.out.println(values[i]);
	}
	System.out.println(Label);
	*/
	
    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	List<DataPoint> Test = DataSet.getTestSet(List_Data, 0.1);
	List<DataPoint> Training = DataSet.getTrainingSet(List_Data,0.9);
	
	/*
	DataPoint IEucOne = List_Data.get(3);
	DataPoint IEucTwo = List_Data.get(5);
	double Euc_Dist  = DataSet.distanceEuclid(IEucOne,IEucTwo);
	System.out.println(Euc_Dist);
	*/
	
    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	KNNClassifier ClassTest = new KNNClassifier(Nbr);
	//System.out.println("The predicted class is: " + ClassTest.predict( Test, dataPoint));
	
	
    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
	
	int Correct=0;
	
	for(int i=0; i<Test.size();i++){
		DataPoint Point = Test.get(i);
		String prediction = ClassTest.predict(Training, Point);
		
		if(Point.getLabel().equals(prediction)){
			Correct++;
		}
	}
	double Percentage = 100.*( ( (double)(Correct) ) / ( (double)(Test.size()) ) ) ;
	//System.out.println("The percent accurate" +Percentage+"%");
	
	accuracy[j]=Percentage;
	}
	
	double avg= mean(accuracy);
	System.out.println("The mean is: "+avg+"%");
	double std= standardDeviation(accuracy);
	System.out.println("The standard deviation is: "+std);
	System.out.println("The number of neighbours is: " + Nbr);
	
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
