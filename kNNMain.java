import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
	String PATH_TO_DATA = args[0];
	
	List<DataPoint> Iris_Data = DataSet.readDataSet(PATH_TO_DATA);
	DataPoint IrisPoint = Iris_Data.get(5);
	
	double[] values = IrisPoint.getX();
	String Flower = IrisPoint.getLabel();
	
	for(int i=0; i<values.length; i++){
		System.out.println(values[i]);
	}
	System.out.println(Flower);
	
    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
	List<DataPoint> IrisTest = DataSet.getTestSet(Iris_Data, 0.9);
	List<DataPoint> IrisTraining = DataSet.getTrainingSet(Iris_Data,0.1);
	
	//DataSet Iris_Training = new DataSet();
	//DataSet Iris_Test = new DataSet();
	
	
    // TASK 4: write a new method in DataSet.java which takes as arguments two DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
	
	
	
    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
	
	
	
    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.


  }

}
