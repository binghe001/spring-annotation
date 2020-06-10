/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mykit.spring.plugins.register.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author binghe
 * @version 1.0.0
 * @description Linux条件，判断操作系统是否是Linux
 */
public class LinuxCondition implements Condition {
    /**
     * ConditionContext：判断条件使用的上下文环境
     * AnnotatedTypeMetadata：注释信息
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //判断是否是Linux系统
        //1.获取到IOC容器使用的BeanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3.获取当前的环境信息
        Environment environment = context.getEnvironment();
        //4.获取bean定义的注册类，我们可以通过BeanDefinitionRegistry对象查看
        //Spring容器中注册了哪些bean，也可以通过BeanDefinitionRegistry对象向
        //Spring容器中注册bean，移除bean，查看bean的定义，查看是否包含某个bean的定义
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");

        return property.contains("linux");
    }
}
