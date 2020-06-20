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

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试bean的初始化和销毁方法
 */
public class Student {

    public Student(){
        System.out.println("Student类的构造方法");
    }

    public void init(){
        System.out.println("初始化Student对象");
    }

    public void destroy(){
        System.out.println("销毁Student对象");
    }
}
