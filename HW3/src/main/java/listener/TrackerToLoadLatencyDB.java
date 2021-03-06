package listener;

import dao.LatencyDao;

import java.sql.SQLException;

public class TrackerToLoadLatencyDB extends Thread {
    private LatencyDao latencyDao;

    public TrackerToLoadLatencyDB(){
        latencyDao = LatencyDao.getInstance();
    }

    public void run(){
        while(true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int size =  Listener.QUEUE_PERFORMANCE.size() < 10000? Listener.QUEUE_PERFORMANCE.size() : 10000;
            if (size == 0) continue;
            try {
                System.out.println(Listener.QUEUE_PERFORMANCE.size());
                latencyDao.multiInsert(size);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

