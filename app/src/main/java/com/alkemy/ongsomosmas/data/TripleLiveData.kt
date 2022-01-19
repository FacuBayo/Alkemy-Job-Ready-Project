package com.alkemy.ongsomosmas.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class TripleLiveData<E, M, K, C>(
    liveData1: LiveData<E>,
    liveData2: LiveData<M>,
    liveData3: LiveData<K>,
    private val combine: (data1: E?, data2: M?, data3: K?) -> C,
) : MediatorLiveData<C>() {

    private var data1: E? = null
    private var data2: M? = null
    private var data3: K? = null

    init {
        addSource(liveData1) {
            data1 = it
            value = combine(data1, data2, data3)
        }
        addSource(liveData2) {
            data2 = it
            value = combine(data1, data2, data3)
        }
        addSource(liveData3) {
            data3 = it
            value = combine(data1, data2, data3)
        }
    }
}

