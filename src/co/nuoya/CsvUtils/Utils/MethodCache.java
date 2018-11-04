package co.nuoya.CsvUtils.Utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MethodCache {
	private Map<String, HashMap<String, Method>> methodCache = new HashMap<String,HashMap<String,Method>>();
	public Method getGetterMethod(Class<?> clazz, String field){
		if (clazz == null) {
			throw new NullPointerException("the clazz should not be null! ");
		}
		if (field == null) {
			throw new NullPointerException("the field should not be null! ");
		}
		Method getterMethod = null;
		if (methodCache.containsKey(clazz.getName())) {
			getterMethod = methodCache.get(clazz.getName()).get(field);
		}
		if (getterMethod == null) {
			getterMethod = ReflectionUtils.findGetter(clazz, field);
			if (methodCache.containsKey(clazz.getName())) {
				methodCache.get(clazz.getName()).put(field, getterMethod);
			} else {
				HashMap<String, Method> classMethodMap = new HashMap<>();
				methodCache.put(clazz.getName(), classMethodMap);
			}
			
		}
		return getterMethod;
	}
	
	
	
	
	
	
	
	
}
