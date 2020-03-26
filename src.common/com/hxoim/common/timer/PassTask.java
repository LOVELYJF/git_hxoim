package com.hxoim.common.timer;

import com.hxoim.common.listener.TokenExpireListener;
import com.hxoim.common.utils.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 */
public class PassTask extends TimerTask {

    private String key;
    private Map<String, Object> map;

    private PassTask(String key, Map map, Timer timer) {
        this.key = key;
        this.map = map;
        map.put(key, timer);
    }

    @Override
    public void run() {
        this.map.remove(this.key);
    }

    public static void setPassTaskForCacheMap(String key, String mins) {
        if (StringUtils.isBlank(mins)) {
            mins = Constants.DEFAULT_PASS_MINS;
        }
        //取消之前的定时器
        Timer oldTimer = (Timer) TokenExpireListener.getTokenCacheMap().get(key);
        if (oldTimer != null) {
            oldTimer.cancel();
        }
        //设置新定时器
        Timer timer = new Timer();
        timer.schedule(new PassTask(key, TokenExpireListener.getTokenCacheMap(), timer), Long.valueOf(mins) * 60000);
    }
}
