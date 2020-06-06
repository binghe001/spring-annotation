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
package io.mykit.spring.test;

import io.mykit.spring.bean.Person;
import io.mykit.spring.plugins.register.config.PersonConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试XML配置方式
 */
public class SpringBeanTest {
    @Test
    public void testXmlConfig(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }

    @Test
    public void testAnnotationConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person);

        //按照类型找到对应的bean名称数组
        String[] names = context.getBeanNamesForType(Person.class);
        Arrays.stream(names).forEach(System.out::println);

    }

    @Test
    public void testComponentScanByXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        String[] names = context.getBeanDefinitionNames();
        Arrays.stream(names).forEach(System.out::println);
    }

    @Test
    public void testComponentScanByAnnotation(){
        ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig.class);
        String[] names = context.getBeanDefinitionNames();
        Arrays.stream(names).forEach(System.out::println);
    }
}
