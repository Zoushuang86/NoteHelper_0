package com.ustc.leo.util.timer;

import java.util.TimerTask;

/**
 * Created by dell on 2018/1/22.
 */

public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if(mITimerListener != null){
            mITimerListener.onTimer();
        }
    }
}
