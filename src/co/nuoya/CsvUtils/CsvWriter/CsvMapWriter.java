package co.nuoya.CsvUtils.CsvWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class CsvMapWriter extends AbstractCsvWriter{
	
	public void write(Map<?,?> data, String file) throws IOException {
		if(data == null) {
			throw new NullPointerException("the map to write should not be null!");
		}
		if(file == null) {
			throw new NullPointerException("the file name should not be null!");
		}
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		write(data,bw);
		
	}
	public void write(Map<?,?> data, Writer writer) throws IOException {
		if(data == null) {
			throw new NullPointerException("the map to write should not be null!");
		}
		if(writer == null) {
			throw new NullPointerException("the file name should not be null!");
		}
		writeHeader(data);
		writeContent(data);
		writeToFile(writer);
	}
	private void writeHeader(Map<?,?> map) {
		map.forEach((k,v)->{
			sb.append(k);
			sb.append(",");
		});
		sb.replace(sb.length()-1, sb.length(), "\r\n");
	}
	private void writeContent(Map<?,?> map) {
		map.forEach((k,v)->{
			sb.append(v);
			sb.append(",");
		});
		sb.replace(sb.length()-1, sb.length(), "\r\n");
	}
	
}
