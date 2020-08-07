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

import io.mykit.spring.plugins.register.bean.Person;
import io.mykit.spring.plugins.register.config.PropertyValueConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试bean的生命周期
 */
public class PropertyValueTest {

    @Test
    public void testPropertyValue01(){
        //创建IOC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertyValueConfig.class);
        String[] names = context.getBeanDefinitionNames();
        Arrays.stream(names).forEach(System.out::println);

        System.out.println("================================");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }

    @Test
    public void testPropertyValue02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }


    @Test
    public void testPropertyValue03(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertyValueConfig.class);
        Environment environment = context.getEnvironment();
        String nickName = environment.getProperty("person.nickName");
        System.out.println(nickName);
    }
}
