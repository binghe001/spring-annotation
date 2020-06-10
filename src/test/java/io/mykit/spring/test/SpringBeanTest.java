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
import io.mykit.spring.plugins.register.config.PersonConfig;
import io.mykit.spring.plugins.register.config.PersonConfig2;
import io.mykit.spring.plugins.register.config.PersonConfig3;
import io.mykit.spring.plugins.register.scope.ThreadScope;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Test
    public void testAnnotationConfig2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);
        //从Spring容器中获取到的对象默认是单实例的
        Object person1 = context.getBean("person");
        Object person2 = context.getBean("person");
        System.out.println(person1 == person2);
    }
    @Test
    public void testAnnotationConfig3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);
        Object person1 = context.getBean("person");
        Object person2 = context.getBean("person");
        System.out.println(person1 == person2);
    }
    @Test
    public void testAnnotationConfig4(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig3.class);
        //向容器中注册自定义的scope
        context.getBeanFactory().registerScope(ThreadScope.THREAD_SCOPE, new ThreadScope());

        //使用容器获取bean
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread() + "," + context.getBean("person"));
                System.out.println(Thread.currentThread() + "," + context.getBean("person"));
            }).start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testAnnotationConfig5(){
        ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);
        System.out.println("IOC容器创建完成");
        Person person1 = (Person) context.getBean("person");
        Person person2 = (Person) context.getBean("person");
        System.out.println(person1 == person2);
    }

    @Test
    public void testAnnotationConfig6(){
        ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println(osName);


        String[] names = context.getBeanNamesForType(Person.class);
        Arrays.stream(names).forEach(System.out::println);

        Map<String, Person> beans = context.getBeansOfType(Person.class);
        System.out.println(beans);
    }

    @Test
    public void testAnnotationConfig7(){
        ApplicationContext context = new AnnotationConfigApplicationContext(PersonConfig2.class);
        String[] names = context.getBeanDefinitionNames();
        Arrays.stream(names).forEach(System.out::println);
    }
}
