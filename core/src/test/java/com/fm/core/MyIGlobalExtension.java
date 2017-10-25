package com.fm.core;

import org.spockframework.runtime.extension.IGlobalExtension;
import org.spockframework.runtime.model.SpecInfo;

/**
 * @author zhangli on 2017/10/21.
 */
public class MyIGlobalExtension implements IGlobalExtension {

    /**
     * 由spock自动注入
     */
    private ExtensionConfig config;

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void visitSpec(SpecInfo specInfo) {
        System.out.println("visitSpec: " + specInfo.getName() + "\n");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

}
