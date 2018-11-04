package co.nuoya.CsvUtils.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import co.nuoya.CsvUtils.CsvWriter.CsvMapWriter;

public class CsvMapWriterTest {

	public static void main(String[] args) throws IOException {
		Map<String,String> mapData = new LinkedHashMap<>();
		mapData.put("Name", "Tom");
		mapData.put("Age", "11");
		mapData.put("Address", "America");
		mapData.put("Phone", "123456789");
		
		BufferedWriter bw = null;
		
		CsvMapWriter csvWriter = new CsvMapWriter();
		try {
			csvWriter.write(mapData, "D:\\csv\\test_map.csv");
			
			bw = new BufferedWriter(new FileWriter("D:\\csv\\test_map.csv"));
			csvWriter.write(mapData, bw);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bw.close();
		}
	}

}
