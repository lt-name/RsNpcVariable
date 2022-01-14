package cn.lanink.rsnpcvariable.task;

import cn.nukkit.scheduler.AsyncTask;
import com.smallaswater.npc.variable.VariableManage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VariableUpdateTask extends AsyncTask {

    private int tick = 0;

    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    public VariableUpdateTask() {

    }

    @Override
    public void onRun() {
        long startTime = System.currentTimeMillis();
        while(true) {
            try {
                this.work(this.tick);
            } catch (Exception ignored) {

            }

            long duration = System.currentTimeMillis() - startTime;
            if (duration < 50L) {
                try {
                    Thread.sleep(50L - duration);
                } catch (InterruptedException ignored) {

                }
            }

            startTime = System.currentTimeMillis();
            ++this.tick;
        }
    }

    private void work(int tick) {
        if (this.tick%40 == 0) {
            if (this.queue.isEmpty()) {
                for (int i = 0; i < 5; i++) {
                    this.queue.add(this.get("https://v1.hitokoto.cn/?encode=text"));
                }
            }
            VariableManage.addVariable("{一言}", this.queue::poll);
        }
    }

    private String get(String url) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            uc.setConnectTimeout(5000);
            uc.setReadTimeout(5000);
            uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
