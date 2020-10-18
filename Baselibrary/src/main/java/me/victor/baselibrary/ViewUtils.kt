package me.victor.baselibrary

import android.app.Activity
import android.view.View
import java.lang.reflect.Method

object ViewUtils {

    fun inject(view: View) {
        inject(ViewFinder(view), view)
    }

    fun inject(activity: Activity) {
        inject(ViewFinder(activity), activity)
    }

    fun inject(view: View, any: Any) {
        inject(ViewFinder(view), any)
    }

    fun inject(finder: ViewFinder, any: Any) {
        injectField(finder, any)
        injectEvent(finder, any)
    }

    /**
     * 通过反射，注入成员
     */
    private fun injectField(finder: ViewFinder, any: Any) {
        val javaClass = any.javaClass
        val declaredFields = javaClass.declaredFields
        declaredFields.forEach {

            //获取注解属性
            val byId = it.getAnnotation(FindView::class.java)

            if (byId != null) {
                val view = finder.findViewById(byId.value)

                //访问私有属性
                it.isAccessible = true

                it.set(any, view)
            }
        }
    }

    /**
     * 注入点击事件
     */
    private fun injectEvent(finder: ViewFinder, any: Any) {
        val javaClass = any.javaClass
        //反射到所有的方法
        val declaredMethods = javaClass.declaredMethods
        //遍历方法的注解
        declaredMethods.forEach { method ->
            val annotation = method.getAnnotation(Onclick::class.java)
            //遍历注解的参数
            annotation?.list?.forEach {
                finder.findViewById(it)?.setOnClickListener(ViewLisentner(method, any))
            }
        }
    }
}

/**
 * 自定义listener
 */
class ViewLisentner : View.OnClickListener {
    private var any: Any
    private var method: Method?

    constructor(method: Method?, any: Any) {
        this.method = method
        this.any = any
    }

    /**
     * 点击事件中反射调用方法
     */
    override fun onClick(view: View?) {
        method?.invoke(any, view)
    }

}
