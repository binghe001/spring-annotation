package io.mykit.mayi;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        String dirPath = "src/main/resources/files";
        File dirFile = new File(dirPath);
        File[] files = dirFile.listFiles();
        DataWareHouse dataWareHouse = new DataWareHouse();
        CountDownLatch countDownLatch = new CountDownLatch(files.length + 1);
        for(File file : files){
            Producer producer = new Producer(dataWareHouse.getQueue(), file,countDownLatch);
            //生产者线程使用线程池
            dataWareHouse.getThreadPool().execute(producer);
        }
        Consumer consumer = new Consumer(dataWareHouse.getQueue(), dataWareHouse.getTreeMap(),countDownLatch);
        //一个消费者线程消费
        new Thread(consumer).start();
        try {
            //生产者线程和消费者线程执行完成，关闭线程池，输出结果
            countDownLatch.await();
            dataWareHouse.getThreadPool().shutdownNow();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<Map.Entry<String, DataItem>> it = dataWareHouse.getTreeMap().entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, DataItem> entry = it.next();
            DataItem dataItem = entry.getValue();
            System.out.println(dataItem.getGroupId() + "，" + dataItem.getId()+"，"+dataItem.getQuota());
        }
    }
}