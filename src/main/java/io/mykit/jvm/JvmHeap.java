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
package io.mykit.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binghe
 * @version 1.0.0
 * @description Jvm堆实例
 */
public class JvmHeap {

    private byte[] bys = new byte[1024 * 100];

    public static void main(String[] args) throws InterruptedException {
        List<JvmHeap> list = new ArrayList<>();
        while (true){
            //死循环，内存是否会装满，这与内存区域有关
            //使用new创建的对象会存放在JVM的堆内存中
            //程序运行的时候会伴随GC，如果没有GC机制，最终的结果一定是OOM的
            list.add(new JvmHeap());
            Thread.sleep(1);
        }
    }
}
