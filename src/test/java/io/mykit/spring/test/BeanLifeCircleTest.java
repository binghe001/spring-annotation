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

import io.mykit.spring.plugins.register.config.AnimalConfig;
import io.mykit.spring.plugins.register.config.LifeCircleConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试bean的生命周期
 */
public class BeanLifeCircleTest {

    @Test
    public void testBeanLifeCircle01(){
        //创建IOC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCircleConfig.class);
        System.out.println("容器创建完成...");
        //context.getBean(Student.class);
        context.close();
    }

    @Test
    public void testBeanLifeCircle02(){
        //创建IOC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnimalConfig.class);
        System.out.println("IOC容器创建完成...");
        //关闭IOC容器
        context.close();
    }

    @Test
    public void testBeanLifeCircle03(){
        //创建IOC容器
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnimalConfig.class);
        System.out.println("IOC容器创建完成...");
        System.out.println("-------");
        //调用时创建对象
        Object bean = ctx.getBean("animal");
        System.out.println("-------");
        //调用时创建对象
        Object bean1 = ctx.getBean("animal");
        System.out.println("-------");
        //关闭IOC容器
        ctx.close();
    }

    @Test
    public void testBeanLifeCircle04(){
        //创建IOC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnimalConfig.class);
        //关闭IOC容器
        context.close();
    }
}
