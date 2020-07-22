package io.mykit.mayi;

import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author binghe
 * @version 1.0.0
 * @description 数据仓库
 */
public class DataWareHouse {

    private static final int THREAD_POOL_SIZE = 10;
    private LinkedBlockingQueue<DataItem> queue;//缓存生产者线程从文件读取的数据
    private TreeMap<String, DataItem> treeMap;//存储消费者线程处理后的数据（排序、获取同组指标最小的数据）
    private ExecutorService threadPool;//线程池
    public DataWareHouse() {
        queue = new LinkedBlockingQueue<>();
//        treeMap = new TreeMap<String, DataItem>(new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                return Long.valueOf(o1).compareTo(Long.valueOf(o2));
//            }
//        });

        treeMap = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
        threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }
    public LinkedBlockingQueue<DataItem> getQueue() {
        return queue;
    }
    public void setQueue(LinkedBlockingQueue<DataItem> queue) {
        this.queue = queue;
    }
    public TreeMap<String, DataItem> getTreeMap() {
        return treeMap;
    }
    public void setTreeMap(TreeMap<String, DataItem> treeMap) {
        this.treeMap = treeMap;
    }
    public ExecutorService getThreadPool() {
        return threadPool;
    }
    public void setThreadPool(ExecutorService threadPool) {
        this.threadPool = threadPool;
    }

}