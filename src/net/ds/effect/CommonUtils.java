package net.ds.effect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.os.Build;

public class CommonUtils {
    public static boolean isEnable() {
        return Build.VERSION.SDK_INT >= 14;
    }

    public static Object invokeMethod(Class<?> cls, Object object, String methodName, Class<?>[] paramTypes, Object... paramValues) throws Exception {
        Method method = cls.getDeclaredMethod(methodName, paramTypes);
        boolean accessible = method.isAccessible();
        try {
            method.setAccessible(true);
            return method.invoke(object, paramValues);
        } finally {
            method.setAccessible(accessible);
        }
    }

    public static Object invokeField(Class<?> cls, Object object, String fieldName) throws Exception {
        Field field = cls.getDeclaredField(fieldName);

        boolean accessible = field.isAccessible();
        try {
            field.setAccessible(true);
            return field.get(object);
        } finally {
            field.setAccessible(accessible);
        }
    }
}
