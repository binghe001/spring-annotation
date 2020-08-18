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

import io.mykit.spring.plugins.register.bean.Cat;
import io.mykit.spring.plugins.register.bean.Dog;
import io.mykit.spring.plugins.register.bean.Fish;
import io.mykit.spring.plugins.register.config.AutowiredConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试自动装配
 */
public class AutowiredTest {

    @Test
    public void testAutowired01(){
        //创建IOC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        //PersonService personService = context.getBean(PersonService.class);
        //System.out.println(personService);
        Dog dog = context.getBean(Dog.class);
        System.out.println(dog.toString());
        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);
        context.close();
    }
    @Test
    public void testAutowired02(){
        //创建IOC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        Fish fish = context.getBean(Fish.class);
        System.out.println(fish);
        context.close();
    }
}
