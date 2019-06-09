package com.test.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * ClassName: MyAnnoParser
 * Function:  TODO
 * Date:      2019-06-08 08:28
 * author     daguang
 * version    V1.0
 */
public enum  MyAnnoParser {
	INSTANCE;

	public boolean parseAnnotation(Object object) throws AnnoException, IllegalAccessException {
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldValue = (String) field.get(object);
			Annotation ano = field.getAnnotation(MyNotNull.class);
			if (ano != null && fieldValue == null) {
				return false;
//				throw new AnnoException("field can't be null");
			}
		}
		return true;
	}
}
