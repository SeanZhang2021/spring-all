package org.sean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//两个高端用法，springboot的第三方组件都是这样注册的
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class IocBaseConfig {
    @Bean
    public Object obj() {
        return new Object();
    }
}
