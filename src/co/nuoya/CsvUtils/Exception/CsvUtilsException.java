package co.nuoya.CsvUtils.Exception;

public class CsvUtilsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CsvUtilsException(String msg) {
		super(msg);
	}

	public CsvUtilsException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
