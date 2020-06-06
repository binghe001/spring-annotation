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

import io.mykit.spring.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author binghe
 * @version 1.0.0
 * @description 以注解的形式来配置Person
 */
@Configuration
//@ComponentScan(value = "io.mykit.spring", excludeFilters = {
//        @Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class, Repository.class})
//})
//@ComponentScan(value = "io.mykit.spring", includeFilters = {
//        @Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//}, useDefaultFilters = false)
//@ComponentScan(value = "io.mykit.spring", includeFilters = {
//        @Filter(type = FilterType.ANNOTATION, classes = {Service.class})
//}, useDefaultFilters = false)

@ComponentScans(value = {
        @ComponentScan(value = "io.mykit.spring", includeFilters = {
                @Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
        }, useDefaultFilters = false),
        @ComponentScan(value = "io.mykit.spring", includeFilters = {
                @Filter(type = FilterType.ANNOTATION, classes = {Service.class})
        }, useDefaultFilters = false)
})
public class PersonConfig {

    @Bean("person")
    public Person person01(){
        return new Person("binghe001", 18);
    }
}
