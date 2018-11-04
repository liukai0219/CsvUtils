package co.nuoya.CsvUtils.CsvWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import co.nuoya.CsvUtils.Exception.CsvUtilsReflectException;
import co.nuoya.CsvUtils.Utils.MethodCache;

public class CsvBeanWriter extends AbstractCsvWriter {
	private final MethodCache cache = new MethodCache();

	public void write(Object data, String file, String... headers) throws IOException {
		if (data == null) {
			throw new NullPointerException("the map to write should not be null!");
		}
		if (file == null) {
			throw new NullPointerException("the file name should not be null!");
		}
		if (headers == null) {
			throw new NullPointerException("the headers should not be null!");
		}
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		write(data, bw, headers);

	}

	public void write(Object data, Writer writer, String... headers) throws IOException {
		if (data == null) {
			throw new NullPointerException("the map to write should not be null!");
		}
		if (writer == null) {
			throw new NullPointerException("the writer should not be null!");
		}
		if (headers == null) {
			throw new NullPointerException("the headers should not be null!");
		}
		writeHeader(headers);
		writeContent(data, headers);
		writeToFile(writer);
	}

	private void writeHeader(String... headers) {
		Arrays.asList(headers).forEach($ -> {
			sb.append($);
			sb.append(",");
		});
		sb.replace(sb.length() - 1, sb.length(), "\r\n");
	}

	private void writeContent(Object data, String... headers) {
		for (String header : headers) {
			Method method = cache.getGetterMethod(data.getClass(), header);
			try {
				sb.append(method.invoke(data)).append(",");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new CsvUtilsReflectException(String.format("error extracting bean value for field %s", header),
						e);
			}
		}
		sb.replace(sb.length() - 1, sb.length(), "\r\n");
	}
}
