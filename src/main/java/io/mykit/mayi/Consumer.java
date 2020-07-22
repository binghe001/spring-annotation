package io.mykit.mayi;

import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author binghe
 * @version 1.0.0
 * @description 消费者线程
 */
public class Consumer implements Runnable{

    private LinkedBlockingQueue<DataItem> queue;
    private TreeMap<String, DataItem> treeMap;
    private CountDownLatch countDownLatch;
    public Consumer(LinkedBlockingQueue<DataItem> queue,TreeMap<String, DataItem> treeMap,CountDownLatch countDownLatch) {
        this.queue = queue;
        this.treeMap = treeMap;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            while(true){
                if (!queue.isEmpty()) {
                    DataItem dataItem = queue.take();
                    DataItem mydataItem = treeMap.get(dataItem.getGroupId());
                    if (mydataItem == null) {
                        treeMap.put(dataItem.getGroupId(), dataItem);
                    }else{
                        if (dataItem.getQuota() < mydataItem.getQuota()) {
                            treeMap.put(dataItem.getGroupId(), dataItem);
                        }
                    }
                }else{
                    if(countDownLatch.getCount() <= 1){
                        countDownLatch.countDown();
                        break;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}