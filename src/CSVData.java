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
	 * Returns a new CSVData object for a file ignoring lines at the top. All
	 * data is stored as doubles.
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

	/**
	 * Returns an array of doubles representing the row at the specified row
	 * number.
	 * 
	 * @param rowNumber
	 *            the row to extract
	 * @return an array for the row
	 */
	public double[] getRow(int rowNumber) {
		return null;
	}

	/**
	 * Returns an 2d array of doubles representing the rows between two start
	 * and end row numbers.
	 * 
	 * @param startRowNumber
	 *            the beginning row to extract
	 * @param endRowNumber
	 *            the end row to extract
	 * @return the 2d array that represents the rows
	 */
	public double[][] getRows(int startRowNumber, int endRowNumber) {
		return null;
	}

	/**
	 * Returns a 2d array of doubles representing the rows specified.
	 * 
	 * @param rowNumbers
	 *            the rows to extract
	 * @return the 2d array that represents the rows
	 */
	public double[][] getRows(int[] rowNumbers) {
		return null;
	}

	/**
	 * Returns an array of doubles representing the column at the specified
	 * column number.
	 * 
	 * @param columnNumber
	 *            the column to extract
	 * @return an array for the column
	 */
	public double[] getColumn(int columnNumber) {
		return null;
	}

	/**
	 * Returns an array of doubles representing the column with a specified
	 * name.
	 * 
	 * @param columnName
	 *            the name of the column to extract
	 * @return an array for the column
	 */
	public double[] getColumn(String columnName) {
		return null;
	}

	/**
	 * Returns an 2d array of doubles representing the columns between two start
	 * and end column numbers.
	 * 
	 * @param startColumnNumber
	 *            the beginning column to extract
	 * @param endColumnNumber
	 *            the end column to extract
	 * @return the 2d array that represents the columns
	 */
	public double[][] getColumns(int startColumnNumber, int endColumnNumber) {
		return null;
	}

	/**
	 * Returns a 2d array of doubles representing the columns specified.
	 * 
	 * @param columnNumbers
	 *            the columns to extract
	 * @return the 2d array that represents the columns
	 */
	public double[][] getColumns(int[] columnNumbers) {
		return null;
	}

	/**
	 * Returns a 2d array of doubles representing the columns of all the
	 * specified names.
	 * 
	 * @param columnNames
	 *            names of the columns to extract
	 * @return the 2d array that represents the columns
	 */
	public double[][] getColumns(String[] columnNames) {
		return null;
	}

	/**
	 * Returns a string array with the names of each column.
	 * 
	 * @return the array with the column names
	 */
	public String[] getColumnTitles() {
		return null;
	}

	/**
	 * Returns a string of the name of the column specified.
	 * 
	 * @param columnNumber
	 *            the column to find the name of
	 * @return the name of that column
	 */
	public String getColumnTitle(int columnNumber) {
		return null;
	}

	/**
	 * Returns the number of the column that has a certain name.
	 * 
	 * @param columnTitle
	 *            the name of the column
	 * @return the number of the column with that name
	 */
	public String getColumnNumber(String columnTitle) {
		return null;
	}

	/**
	 * Sets a value at a specified column and row.
	 * 
	 * @param newValue
	 *            the value to replace
	 * @param rowNumber
	 *            the row the value is at
	 * @param columnNumber
	 *            the column the value is at
	 * @return the replaced number
	 */
	public double setValue(double newValue, int rowNumber, int columnNumber) {
		return 0;
	}

	/**
	 * Saves the data in the CSVData in a file.
	 * 
	 * @param filename
	 *            the name of the file
	 */
	public void saveData(String filename) {

	}

}
