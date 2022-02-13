package com.skippersoft.testng.listener;

import com.skippersoft.testng.annotation.Unstable;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

import static java.lang.Boolean.parseBoolean;

public class FlakyTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod, Class<?> occurringClazz) {
        String skipProp = System.getProperty("skipUnstable", "false");
        boolean toSkip = (skipProp.isEmpty() || parseBoolean(skipProp)) && (testMethod.getAnnotation(Unstable.class) != null);
        if (toSkip) {
            annotation.setEnabled(false);
        }
        System.out.printf(
                "%s %s%s (groups: %s)%n",
                toSkip?"Skipping":"Starting",
                occurringClazz.getName(),
                testMethod.getName(),
                Arrays.toString(annotation.getGroups())
        );
    }
}
