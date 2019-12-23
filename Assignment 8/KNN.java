import java.util.*;

/**
 * A kNN classification algorithm implementation.
 * 
 */

public class KNN {

	/**
	 * In this method, you should implement the kNN algorithm. You can add 
	 * other methods in this class, or create a new class to facilitate your
	 * work. If you create other classes, DO NOT FORGET to include those java
   * files when preparing your code for hand in.
   *
	 * Also, Please DO NOT MODIFY the parameters or return values of this method,
   * or any other provided code.  Again, create your own methods or classes as
   * you need them.
	 * 
	 * @param trainingData
	 * 		An Item array of training data
	 * @param testData
	 * 		An Item array of test data
	 * @param k
	 * 		The number of neighbors to use for classification
	 * @return
	 * 		The object KNNResult contains classification accuracy, 
	 * 		category assignment, etc.
	 */
	public KNNResult classify(Item[] trainingData, Item[] testData, int k) {
	    KNNResult result = new KNNResult();
	    result.categoryAssignment = new String[testData.length];
	    result.nearestNeighbors = new String[testData.length][k];
	    for(int i = 0; i < testData.length; i++) {
	        Item[] neighbours = new Item[k];
	        for(int j = 0; j < trainingData.length; j++) {
	            if(j < k) {
	                neighbours[j] = trainingData[j];
	            }
	            else {
	                int maxIndex = 0;
	                double max = Double.MIN_VALUE;
	                for(int l = 0; l < neighbours.length; l++) {
	                    double curr = Utils.calcDistance(testData[i], neighbours[l]);
	                    if(max < curr){
	                        max = curr;
	                        maxIndex = l;
	                    }
	                }
	                if(Utils.calcDistance(testData[i], trainingData[j]) < max) {
	                    neighbours[maxIndex] = trainingData[j];
	                }
	            }
	        }
	        int nationCount = 0;
	        int fruitCount = 0;
	        int machineCount = 0;
	        for(int x = 0; x < neighbours.length; x++) {
                if(neighbours[x].category.equals("nation")){
                    nationCount++;
                }
                else if(neighbours[x].category.equals("fruit")){
                    fruitCount++;
                }
                else if(neighbours[x].category.equals("machine")){
                    machineCount++;
                }
            }
	        int largest = Math.max(nationCount, Math.max(fruitCount, machineCount));
	        if(largest == nationCount) {
	            result.categoryAssignment[i] = "nation";
            }
	        else if(largest == machineCount) {
                result.categoryAssignment[i] = "machine";
            }
	        else if(largest == fruitCount) {
                result.categoryAssignment[i] = "fruit";
            }
	        Item test = testData[i];
	        Arrays.sort(neighbours, new Comparator<Item>() {
	            @Override
	            public int compare(Item a, Item b) {
	                double disA = Utils.calcDistance(a, test);
	                double disB = Utils.calcDistance(b, test);
	                if(disA > disB) {
	                    return 1;
	                }
	                else if(disA < disB) {
	                    return -1;
	                }
	                else {
	                    return 0;
	                }
	            }
	        });
	        for(int y = 0; y < neighbours.length; y++) {
	            result.nearestNeighbors[i][y] = neighbours[y].name;
	        }
	    }
	    int correctCount = 0;
	    for(int i = 0; i < testData.length; i++) {
	        if(result.categoryAssignment[i].equals(testData[i].category)) {
	            correctCount++;
	        }
	    }
	    result.accuracy = correctCount / (double)testData.length;
		return result;
	}
}
