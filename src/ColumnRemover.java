import java.util.Arrays;

public class ColumnRemover {
	public static void main(String[] args) {
		String[] columnNames;
		String[] columnsToRemove = { "loggingTime", "loggingSample", "identifierForVendor", "deviceID",
				"gyroTimestamp_sinceReboot", "IP_en0", "IP_pdp_ip0", "deviceOrientation", "batteryState",
				"batteryLevel" };
		String filepath = "data/Trial9Raw.csv";
		String file = FileIO.readFileAsString(filepath);

		String[] lines = file.split(System.getProperty("line.separator"));

		columnNames = lines[0].split(",");

		System.out.println(Arrays.toString(columnNames));
		boolean[] columnsRemoved = new boolean[columnNames.length];
		for (int i = 0; i < columnNames.length; i++) {
			String name = columnNames[i];
			
			for (int j = 0; j < columnsToRemove.length; j++) {
				if (name.equals(columnsToRemove[j])) {

					columnsRemoved[i] = true;
				}
			}
		}
		System.out.println(Arrays.toString(columnsRemoved));
		String[] newRows = new String[lines.length];
		for (int i = 0; i < newRows.length; i++) {
			newRows[i] = "";
		}
		for (int i = 0; i < lines.length; i++) {
			String[] line = lines[i].split(",");
			for (int j = 0; j < line.length; j++) {
				if (!columnsRemoved[j]) {
					newRows[i] += line[j] + ",";
				}
			}
			if (newRows[i].substring(newRows[i].length() - 1, newRows[i].length()).equals(",")) {
				System.out.println(",");
				newRows[i] = newRows[i].substring(0, newRows[i].length()-1);
			}
		}
		String finalValue = "";
		for (int i = 0; i < newRows.length; i++) {
			finalValue += (newRows[i] + System.getProperty("line.separator"));
		}
		FileIO.writeDataToFile("Trial9.csv", finalValue);
	}
}
