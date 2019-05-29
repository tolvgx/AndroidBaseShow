package com.tolvgx.show.jetpack;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2019/5/28
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 */
public class TestViewModel extends ViewModel {
    private MutableLiveData<String> liveData = new MutableLiveData<>();

    public MutableLiveData<String> getLiveData() {
        return liveData;
    }
}
