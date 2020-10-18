package me.victor.baselibrary

import android.app.Activity
import android.view.View

/**
 *
 */
class ViewFinder() {
    private lateinit var acitivity: Activity
    private lateinit var view: View

    fun findViewById(viewId: Int): View {
        return acitivity.findViewById(viewId)
    }

    constructor(view: View) : this() {
        this.view = view;
    }

    constructor(view: Activity) : this() {
        this.acitivity = view
    }


}
