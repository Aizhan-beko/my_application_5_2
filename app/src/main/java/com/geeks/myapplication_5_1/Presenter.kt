package com.geeks.myapplication_5_1

class Presenter {
    private val model = CounterModel()
    private var view: CounterView? = null

    fun attachView(view: CounterView) {
        this.view = view
    }

    fun onIncrementButtonClicked() {
        model.inc()
        val result = model.getResult()
        view?.updateCount(result)

        when (result) {
            10 -> view?.showCongratulationsMessage()
            15 -> view?.changeTextColor()
            else -> view?.resetTextColor()
        }
    }

    fun onDecrementButtonClicked() {
        model.dec()
        val result = model.getResult()
        view?.updateCount(result)

        when (result) {
            10 -> view?.showCongratulationsMessage()
            15 -> view?.changeTextColor()
            else -> view?.resetTextColor()
        }
        if (result != 15) {
            view?.resetTextColor()
        }
    }

    fun detachView() {
        this.view = null
    }
}


