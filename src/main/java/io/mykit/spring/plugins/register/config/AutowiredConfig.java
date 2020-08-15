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
package io.mykit.spring.plugins.register.config;

import io.mykit.spring.plugins.register.bean.Cat;
import io.mykit.spring.plugins.register.bean.Fish;
import io.mykit.spring.plugins.register.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试自动装配组件的Config配置类
 */
@Configuration
@ComponentScan(value = {
        "io.mykit.spring.plugins.register.dao",
        "io.mykit.spring.plugins.register.service",
        "io.mykit.spring.plugins.register.controller",
        "io.mykit.spring.plugins.register.bean"})
public class AutowiredConfig {

    @Primary
    @Bean("personDao2")
    public PersonDao personDao(){
        PersonDao personDao = new PersonDao();
        personDao.setRemark("2");
        return personDao;
    }

    @Bean
    public Fish fish(@Autowired  Cat cat){
        Fish fish = new Fish();
        fish.setCat(cat);
        return fish;
    }
}
