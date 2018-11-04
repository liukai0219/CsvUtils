package co.nuoya.CsvUtils.CsvWriter;

import java.io.IOException;
import java.io.Writer;

public class AbstractCsvWriter{
	StringBuilder sb = new StringBuilder();
	
	protected void writeToFile(Writer writer) throws IOException {
		writer.write(sb.toString());
		writer.flush();
		writer.close();
	}
}
