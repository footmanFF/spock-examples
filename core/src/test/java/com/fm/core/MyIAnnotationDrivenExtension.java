package com.fm.core;

import org.spockframework.runtime.extension.ExtensionAnnotation;
import org.spockframework.runtime.extension.IAnnotationDrivenExtension;
import org.spockframework.runtime.model.FeatureInfo;
import org.spockframework.runtime.model.FieldInfo;
import org.spockframework.runtime.model.MethodInfo;
import org.spockframework.runtime.model.SpecInfo;
import spock.config.ConfigurationObject;

import java.lang.annotation.Annotation;

/**
 * @author zhangli on 2017/10/21.
 */
public class MyIAnnotationDrivenExtension implements IAnnotationDrivenExtension {

    @Override
    public void visitSpecAnnotation(Annotation annotation, SpecInfo spec) {

    }

    @Override
    public void visitFeatureAnnotation(Annotation annotation, FeatureInfo feature) {
        System.out.println(feature.getName() + "\n");
    }

    @Override
    public void visitFixtureAnnotation(Annotation annotation, MethodInfo fixtureMethod) {

    }

    @Override
    public void visitFieldAnnotation(Annotation annotation, FieldInfo field) {

    }

    @Override
    public void visitSpec(SpecInfo spec) {

    }

}
