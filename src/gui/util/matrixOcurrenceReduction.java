package gui.util;

public class matrixOcurrenceReduction {

	public static int[][] reduceMatrix(int[][] initialMatrix, int[] vector){
		
		var totalElements=0;
		
		for(int element : vector) {
			if(element==0) {
				totalElements++;
			}
		}
		
		System.out.println("parte 1");
		
		int columns = initialMatrix[0].length;
		
		//int[][] newMatrixResulted = new int[totalElements][columns];
		
		int initialRows=0;
		
		System.out.println("parte 2");
		
		for(int i=0; i<initialMatrix.length; i++) {
			if(vector[i]==0) {
				initialRows++;
			}
		}
		
		int[][] newMatrixResulted = new int[initialRows][columns];		
		
		initialRows=0;
		
		for(int i=0; i<initialMatrix.length; i++) {
			if(vector[i]==0) {
				for(int j=0; j<initialMatrix[0].length; j++) {
					newMatrixResulted[initialRows][j] = initialMatrix[i][j];
				}
				initialRows++;
			}
		}
		
		return newMatrixResulted;
	}
}
