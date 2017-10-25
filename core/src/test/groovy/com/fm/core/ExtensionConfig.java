package com.fm.core;

import spock.config.ConfigurationObject;

/**
 * extensionConfig被配置到resources.SpockConfig.groovy中，config如果有定义，会被自动读取
 *
 * @author zhangli on 2017/10/25.
 */
@ConfigurationObject("extensionConfig")
public class ExtensionConfig {

    private String config;

}
