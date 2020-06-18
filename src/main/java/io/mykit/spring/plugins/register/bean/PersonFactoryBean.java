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

import org.springframework.beans.factory.FactoryBean;

/**
 * @author binghe
 * @version 1.0.0
 * @description 商品的FactoryBean，测试FactoryBean
 */
public class PersonFactoryBean implements FactoryBean<Person> {

    //返回一个Person对象，这个对象会被注册到Spring容器中
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    //bean是否为单例;true:是；false:否
    @Override
    public boolean isSingleton() {
        return false;
    }
}
