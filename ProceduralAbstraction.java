package lab2;

public class ProceduralAbstraction {

	// Requires: None
	// Modifies: None
	// Effects: Returns the smallest positive integer n for which n!
	// (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
	// integerx. Otherwise returns 1.
	public static int reverseFactorial(int x) {
		for (int i = 1; i <= x; i++) {
			if (factorial(i) >= x)
				return i;
		}
		return 1;
	}

	// Requires: None
	// Modifies: None
	// Effects: If the matrix arr satisfies Nice property, prints the sum
	// and returns true. Otherwise returns false.
	public static boolean isMatrixNice(int[][] arr) {
		int rowSum, columnSum, diagSum;
		int expectedSum, antiDiagSum, i, j;

		if (arr == null || arr.length == 0 || arr[0].length == 0)
			return false;

		expectedSum = 0;

		for (i = 0; i < arr.length; i++) {
			if (arr[i].length != arr.length)
				return false;
			expectedSum += arr[0][i];
		}
		diagSum = 0;
		antiDiagSum = 0;
		for (i = 0; i < arr.length; i++) {
			columnSum = 0;
			rowSum = 0;
			diagSum += arr[i][i];
			antiDiagSum += arr[i][arr.length - 1 - i];

			for (j = 0; j < arr[0].length; j++) {
				rowSum += arr[i][j];
				columnSum += arr[j][i];
			}
			if (rowSum != expectedSum || columnSum != expectedSum)
				return false;
		}
		if (diagSum != expectedSum || antiDiagSum != expectedSum)
			return false;

		System.out.printf("Is the matrix nice?: %b\n Sum: %d\n", true, expectedSum);
		return true;

	}

	// Helper function for reverse factorial
	// Requires: x > 0
	// Modifies: None
	// Effects: Returns the factorial of the positive integer x. Otherwise
	// returns 1.
	private static int factorial(int x) {
		if (x <= 1)
			return 1;
		return x * factorial(x - 1);
	}

	public static void main(String[] args) {

		int emptyArr[][] = {};
		int singleEArr[][] = { { 5 } };
		int notSqArr[][] = { { 1, 2 }, { 3, 4, 5 } };
		int niceArr[][] = {
				{ 2, 7, 6 },
				{ 9, 5, 1 },
				{ 4, 3, 8 }
		};
		int notNiceArr[][] = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
		int zeroArr[][] = {
				{ 0, 0, 0 },
				{ 0, 0, 0 },
				{ 0, 0, 0 },
		};

		// Testing isMatrixNice
		// Note: that all nice matrices will
		// have their own outputs to terminal
		// from within the isMatrixNice function.
		System.out.println("Testing isMatrixNice:");

		// Empty array, should return false
		System.out.println("Test empty matrix " + isMatrixNice(emptyArr));

		// Single element array is always Nice.
		// Should return true
		System.out.println("Test single element matrix " + isMatrixNice(singleEArr));

		// Not square array, should return false
		System.out.println("Test non-square matrix " + isMatrixNice(notSqArr));

		// Nice matrix, should return true.
		System.out.println("Test nice matrix " + isMatrixNice(niceArr));

		// Square, not nice array.
		// Should return false
		System.out.println("Test non-nice matrix " + isMatrixNice(notNiceArr));

		// Square, zero array.
		// All sums are 0
		// Should return true.
		System.out.println("Test zero Matrix " + isMatrixNice(zeroArr));

		// testing reverse factorial
		System.out.println("Testing reverse factorial.");

		System.out.println(reverseFactorial(1)); // Expecting 1
		System.out.println(reverseFactorial(2)); // Expecting 2
		System.out.println(reverseFactorial(5)); // Expecting 3
		System.out.println(reverseFactorial(6)); // Expecting 3
		System.out.println(reverseFactorial(120)); // Expecting 5
		System.out.println(reverseFactorial(150)); // Expecting 6
		System.out.println(reverseFactorial(0)); // Expecting 1
		System.out.println(reverseFactorial(-5)); // Expecting 1

	}

}
