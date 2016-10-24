import java.util.Arrays;

public class CSVDataTester {
	public static void main(String[] args) {

		String[] columnNames = { "time", "xg", "yg", "zg", "g" };
		CSVData testData = CSVData.readCSVFile("../DisplayData/data/walkingSampleData-out.csv", columnNames, 1);

		displayArray(testData.getColumns(new String[] { "xg", "yg", "zg" }));
	}

	public static void displayArray(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
