package com.fm.core;

import org.spockframework.runtime.extension.ExtensionAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhangli on 2017/10/21.
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
@ExtensionAnnotation( MyIAnnotationDrivenExtension.class )
public @interface Anno {
}
