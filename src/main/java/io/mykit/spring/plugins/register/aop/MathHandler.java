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
package io.mykit.spring.plugins.register.aop;

/**
 * @author binghe
 * @version 1.0.0
 * @description 定义一个数据处理器类，用于测试AOP
 */
public class MathHandler {

    public int add(int i, int j){
        System.out.println("目标方法执行");
        throw new RuntimeException();
       //return i + j;
    }
}
