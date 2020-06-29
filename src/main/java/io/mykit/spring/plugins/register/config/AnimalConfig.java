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

import io.mykit.spring.plugins.register.bean.Animal;
import io.mykit.spring.plugins.register.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author binghe
 * @version 1.0.0
 * @description AnimalConfig
 */
@Configuration
@ComponentScan("io.mykit.spring.plugins.register.bean")
public class AnimalConfig {

    @Bean
    @Scope("prototype")
    public Animal animal(){
        return new Animal();
    }

    @Bean
    public Cat cat(){
        return new Cat();
    }
}
