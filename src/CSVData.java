/**
 * This is a class to read/write numerical CSV files and allow easy access of
 * data.
 * 
 * @author czhu906
 *
 */
public class CSVData {
	private double[][] data;
	private String[] columnNames;

	/**
	 * Returns a new CSVData object for a file ignoring lines at the top.
	 * 
	 * @param filename
	 *            the file to read
	 * @param numLinesToIgnore
	 *            number of lines at the top to ignore
	 * @param columnNames
	 *            the names of each column
	 * @return a CSVData object for that file
	 */
	public static CSVData readCSVFile(String filename, int numLinesToIgnore, String[] columnNames) {
		return null;
	}

	/**
	 * Returns a new CSVData object for a file ignoring lines at the top. It
	 * uses the first row as the column names. All other data is stored as
	 * doubles.
	 * 
	 * @param filename
	 *            the file to read
	 * @param numLinesToIgnore
	 *            number of lines at the top to ignore
	 * @return a CSVData object for that file.
	 */
	public static CSVData readCSVFile(String filename, int numLinesToIgnore) {
		return null;
	}

	public double[] getRow(int rowNumber) {
		return null;
	}

	public double[][] getRows(int startRowNumber, int endRowNumber) {
		return null;
	}

	public double[][] getRows(int[] rowNumbers) {
		return null;
	}

	public double[] getColumn(int columnNumber) {
		return null;
	}

	public double[] getColumn(String columnName) {
		return null;
	}

	public double[][] getColumns(int startColumnNumber, int endColumnNumber) {
		return null;
	}

	public double[][] getColumns(int[] columnNumbers) {
		return null;
	}

	public double[][] getColumns(String[] columnNames) {
		return null;
	}

	public String[] getColumnTitles() {
		return null;
	}

	public String getColumnTitle(int columnNumber) {
		return null;
	}

	public String getColumnNumber(String columnTitle) {
		return null;
	}

	public double setValue(double newValue, int rowNumber, int columnNumber) {
		return 0;
	}

	public void saveData(String filename) {

	}

}
