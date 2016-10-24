import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
	String filePathToCSV;
	int numRows;

	/**
	 * The constructor for making a new CSVData object
	 * 
	 * @param filepath
	 *            the file to read
	 * @param startRow
	 *            the number of lines at the top to ignore
	 */
	private CSVData(String filepath, int startRow) {
		this.filePathToCSV = filepath;
		String dataString = readFileAsString(filepath);
		String[] lines = dataString.split("\n");

		// create the column names from the first line
		columnNames = lines[0].split(",");

		// number of data points
		this.numRows = lines.length - startRow;
		int numColumns = columnNames.length;

		// create storage for data
		this.data = createData(lines, startRow, numColumns);
	}

	/**
	 * The constructor for making a new CSVData object
	 * 
	 * @param filepath
	 *            the file to read
	 * @param columnNames
	 *            the names of each column
	 * @param startRow
	 *            the number of lines at the top to ignore
	 */
	private CSVData(String filepath, String[] columnNames, int startRow) {
		this.filePathToCSV = filepath;

		String dataString = readFileAsString(filepath);
		String[] lines = dataString.split("\n");

		// number of data points
		this.numRows = lines.length - startRow;
		int numColumns = columnNames.length;

		// create storage for column names
		this.columnNames = columnNames;

		// create storage for data
		this.data = createData(lines, startRow, numColumns);

	}

	/**
	 * Creates a 2d array with all of the data put into it
	 * 
	 * @param lines
	 *            the lines containing the data to put into the new 2d array
	 * @param startRow
	 *            the number of lines at the top to ignore
	 * @param numColumns
	 *            the number of columns to convert
	 * @return the 2d array containing the data in String[] lines
	 */
	private double[][] createData(String[] lines, int startRow, int numColumns) {
		int n = lines.length - startRow;

		double[][] data = new double[n][numColumns];
		for (int i = 0; i < lines.length - startRow; i++) {
			String line = lines[startRow + i];
			String[] coords = line.split(",");
			for (int j = 0; j < numColumns; j++) {
				if (coords[j].endsWith("#"))
					coords[j] = coords[j].substring(0, coords[j].length() - 1);
				double val = Double.parseDouble(coords[j]);
				data[i][j] = val;
			}
		}
		return data;
	}

	/**
	 * Return a file converted into a string
	 * 
	 * @param filepath
	 *            the file to read
	 * @return a string with the file's contents
	 */
	private String readFileAsString(String filepath) {
		StringBuilder output = new StringBuilder();
		try (Scanner scanner = new Scanner(new File(filepath))) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				output.append(line + System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output.toString();
	}

	/**
	 * Returns a new CSVData object for a file ignoring lines at the top. All
	 * data is stored as doubles.
	 * 
	 * @param filepath
	 *            the file to read
	 * @param columnNames
	 *            the names of each column
	 * @param startRow
	 *            number of lines at the top to ignore
	 * @return a CSVData object for that file
	 */
	public static CSVData readCSVFile(String filepath, String[] columnNames, int startRow) {
		return new CSVData(filepath, columnNames, startRow);
	}

	/**
	 * Returns a new CSVData object for a file ignoring lines at the top. It
	 * uses the first row as the column names. All other data is stored as
	 * doubles.
	 * 
	 * @param filepath
	 *            the file to read
	 * @param startRow
	 *            number of lines at the top to ignore
	 * @return a CSVData object for that file.
	 */
	public static CSVData readCSVFile(String filepath, int startRow) {
		return new CSVData(filepath, startRow);
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
		return data[rowNumber];
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
		double[][] returnValue = new double[endRowNumber - startRowNumber][data[0].length];
		int returnValueIndex = 0;
		for (int i = startRowNumber; i < endRowNumber; i++) {
			returnValue[returnValueIndex] = getRow(i);
			returnValueIndex++;
		}
		return returnValue;
	}

	/**
	 * Returns a 2d array of doubles representing the rows specified.
	 * 
	 * @param rowNumbers
	 *            the rows to extract
	 * @return the 2d array that represents the rows
	 */
	public double[][] getRows(int[] rowNumbers) {
		double[][] returnValue = new double[rowNumbers.length][data[0].length];
		for (int i = 0; i < rowNumbers.length; i++) {
			returnValue[i] = getRow(rowNumbers[i]);
		}
		return returnValue;
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
		double[] returnValue = new double[data.length];
		for (int i = 0; i < returnValue.length; i++) {
			returnValue[i] = getValue(i, columnNumber);
		}
		return returnValue;
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
		int index = getColumnNumber(columnName);

		if (index != -1) {
			return getColumn(index);
		}
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
		double[][] returnValue = new double[data.length][endColumnNumber - startColumnNumber];

		for (int i = 0; i < returnValue.length; i++) {
			int returnIndex = 0;
			for (int j = startColumnNumber; j < endColumnNumber; j++) {
				returnValue[i][returnIndex] = data[i][j];
				returnIndex++;
			}
		}
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
		double[][] returnValue = new double[data.length][columnNumbers.length];
		for (int i = 0; i < returnValue.length; i++) {
			int returnIndex = 0;
			for (int j = 0; j < columnNumbers.length; j++) {
				returnValue[i][returnIndex] = data[i][columnNumbers[j]];
				returnIndex++;
			}
		}
		return returnValue;
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
		int[] columnNumbers = new int[columnNames.length];
		for (int i = 0; i < columnNames.length; i++) {
			columnNumbers[i] = getColumnNumber(columnNames[i]);
		}
		return getColumns(columnNumbers);
	}

	/**
	 * Returns a string array with the names of each column.
	 * 
	 * @return the array with the column names
	 */
	public String[] getColumnTitles() {
		return columnNames;
	}

	/**
	 * Returns a string of the name of the column specified.
	 * 
	 * @param columnNumber
	 *            the column to find the name of
	 * @return the name of that column
	 */
	public String getColumnTitle(int columnNumber) {
		return columnNames[columnNumber];
	}

	/**
	 * Returns the number of the column that has a certain name.
	 * 
	 * @param columnTitle
	 *            the name of the column
	 * @return the number of the column with that name
	 */
	public int getColumnNumber(String columnTitle) {
		int index = 0;
		while (index < columnNames.length && !columnTitle.equals(columnNames[index])) {
			index++;
		}
		if (index >= columnNames.length) {
			return -1;
		}
		return index;
	}

	/**
	 * Returns the value at the specified column and row.
	 * 
	 * @param rowNumber
	 *            the row to take the value out of
	 * @param columnNumber
	 *            the column to take the value out of
	 * @return the value
	 */
	public double getValue(int rowNumber, int columnNumber) {
		return data[rowNumber][columnNumber];
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
		double prevValue = getValue(rowNumber, columnNumber);
		data[rowNumber][columnNumber] = newValue;
		return prevValue;
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
