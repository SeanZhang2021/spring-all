package org.sean.config;

import org.sean.bean.ImportPersonOne;
import org.sean.bean.ImportPersonThree;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

@Component
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        GenericBeanDefinition gbd = new GenericBeanDefinition();
        //生产一个bean，完全由beanDefinition来决定,并且可以注册多个
        gbd.setBeanClass(ImportPersonThree.class);
        registry.registerBeanDefinition("importPersonThree", gbd);
    }
}
