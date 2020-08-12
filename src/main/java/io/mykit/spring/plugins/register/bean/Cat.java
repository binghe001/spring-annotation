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
package io.mykit.spring.plugins.register.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试@PostConstruct注解和@PreDestroy注解
 */
public class Cat {
    public Cat(){
        System.out.println("Cat类的构造方法...");
    }

    public void init(){
        System.out.println("Cat的init()方法...");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Cat的postConstruct()方法...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Cat的preDestroy()方法...");
    }

    public void destroy(){
        System.out.println("Cat的destroy()方法...");
    }
}
