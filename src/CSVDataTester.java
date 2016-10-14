import java.util.Arrays;

public class CSVDataTester {
	public static void main(String[] args) {
		double[][] testArray = { { 3, 2, 6 }, { 1, 39, 2 }, { 5, 7, 29 } };
		String[] columnNames = { "jeff", "joe", "pew" };
		CSVData testData = new CSVData(testArray, columnNames);
		System.out.println(Arrays.toString(testData.getRows(new int[] { 1, 2 })[0]));
	}
}
