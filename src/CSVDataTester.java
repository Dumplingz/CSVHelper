import java.util.Arrays;

public class CSVDataTester {
	public static void main(String[] args) {
		
		String[] columnNames = { "xg", "yg", "zg", "g", "time"};
		CSVData testData = new CSVData("2016-10-14_11-05-41.csv", columnNames, 1);
		System.out.println(Arrays.toString(testData.getRow(0)));
	}
}
