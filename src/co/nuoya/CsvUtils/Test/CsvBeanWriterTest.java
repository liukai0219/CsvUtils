package co.nuoya.CsvUtils.Test;

import java.io.IOException;

import co.nuoya.CsvUtils.CsvWriter.CsvBeanWriter;

public class CsvBeanWriterTest {

	public static void main(String[] args) {
		TestBean bean = new TestBean();
		bean.setIntNum(123);
		bean.setIntegerNum(1234);
		bean.setFloatNum1(1.234f);
		bean.setFloatNum2(1.23456f);
		bean.setDoubleNum1(1.897);
		bean.setDoubleNum2(1.897);
		bean.setShortNum1((short) 1);
		bean.setShortNum2((short) 2);
		bean.setLongnum1(12344L);
		bean.setLongnum2(4567L);
		bean.setCharChar1('a');
		bean.setCharChar2('b');
		bean.setBytebyte1((byte) 1);
		bean.setBytebyte2((byte) 1);
		bean.setBooleanflg1(true);
		bean.setBooleanflg2(false);
		bean.setName("Tom");

		String[] headers = { "intNum", "integerNum", "floatNum1", "floatNum2", "doubleNum1", "doubleNum2", "shortNum1",
				"shortNum2", "longnum1", "longnum2", "charChar1", "charChar2", "bytebyte1", "bytebyte2", "booleanflg1",
				"booleanflg2", "name" };
		
		CsvBeanWriter cw = new CsvBeanWriter();
		try {
			cw.write(bean, "D:\\csv\\test_bean.csv", headers);
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
