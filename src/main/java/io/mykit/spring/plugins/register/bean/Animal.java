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

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试InitializingBean接口和DisposableBean接口
 */
@Component
public class Animal implements InitializingBean, DisposableBean {
    public Animal(){
        System.out.println("执行了Animal类的无参数构造方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行了Animal类的初始化方法。。。。。");

    }
    @Override
    public void destroy() throws Exception {
        System.out.println("执行了Animal类的销毁方法。。。。。");

    }
}
