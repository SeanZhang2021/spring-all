package org.sean.config;

import org.sean.bean.ImportPersonOne;
import org.sean.bean.ImportPersonTwo;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * 这个方法可以同时注册多个Bean
 * 此时，字符串是类的完整限定名，获取的时候也是要用类的class类型或者完整限定名获取
 */
@Component
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"org.sean.bean.ImportPersonOne", ImportPersonTwo.class.getName()};
    }
}
