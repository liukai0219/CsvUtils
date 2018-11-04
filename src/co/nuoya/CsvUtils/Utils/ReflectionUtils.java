package co.nuoya.CsvUtils.Utils;

import java.lang.reflect.Method;

public class ReflectionUtils {
	private static final String PREFIX_GET = "get";
	private static final String PREFIX_SET = "set";
	private static final String PREFIX_IS = "is";

	public static Method findGetter(Class<?> clazz, String filedName) {
		if (clazz == null) {
			throw new NullPointerException("the clazz should not be null! ");
		}
		if (filedName == null) {
			throw new NullPointerException("the field should not be null! ");
		}
		String methodName = getMethodNameByFieldName(PREFIX_GET, filedName);
		Method[] methods = clazz.getMethods();
		Method getterMethod = null;
		for (Method method : methods) {
			if (methodName.equalsIgnoreCase(method.getName()) && method.getParameterTypes().length == 0
					&& method.getReturnType() != void.class) {
				getterMethod = method;
			}
		}
		if(getterMethod == null) {
			methodName = getMethodNameByFieldName(PREFIX_IS, filedName);
			for (Method method : methods) {
				if (methodName.equalsIgnoreCase(method.getName()) && method.getParameterTypes().length == 0
						&& method.getReturnType() == boolean.class) {
					getterMethod = method;
				}
			}
		}
		return getterMethod;
	}
	

	private static String getMethodNameByFieldName(String prefix, String fieldName) {
		return prefix + fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());
	}
}
