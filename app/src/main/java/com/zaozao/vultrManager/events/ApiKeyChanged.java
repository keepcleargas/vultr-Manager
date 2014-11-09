package com.zaozao.vultrManager.events;

/**
 * Created by chenqisheng on 14/11/9.
 */
public class ApiKeyChanged {
    private boolean isClear;

    public ApiKeyChanged(boolean isClear) {
        this.isClear = isClear;
    }

    public boolean isClear() {
        return isClear;
    }

    public void setClear(boolean isClear) {
        this.isClear = isClear;
    }
}
