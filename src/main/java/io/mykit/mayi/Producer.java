package io.mykit.mayi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author binghe
 * @version 1.0.0
 * @description 生产者线程
 */
public class Producer implements Runnable{

    private LinkedBlockingQueue<DataItem> queue;
    private File file;
    private CountDownLatch countDownLatch;
    public Producer(LinkedBlockingQueue<DataItem> queue,File file,CountDownLatch countDownLatch) {
        this.queue = queue;
        this.file = file;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader br=new BufferedReader(read);
            String line="";
            String[] arrs=null;
            while ((line=br.readLine())!=null) {
                if (line.equals("")) {
                    continue;
                }
                arrs=line.split("，");
                DataItem dataItem = new DataItem();
                dataItem.setId(arrs[0]);
                dataItem.setGroupId(arrs[1]);
                dataItem.setQuota(new Float(arrs[2]));
                queue.add(dataItem);
            }
            br.close();
            read.close();
            countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }   

    }

}