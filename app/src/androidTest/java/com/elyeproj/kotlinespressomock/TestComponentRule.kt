package com.elyeproj.kotlinespressomock

import android.content.Context

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class TestComponentRule(val context: Context) : TestRule {

    private var mTestComponent: ApplicationTestComponent? = null

    val mockInjectedData: InjectedData
        get() = mTestComponent!!.dataManager()

    private fun setupDaggerTestComponentInApplication() {
        val application = MainApplication[context]
        mTestComponent = DaggerApplicationTestComponent.builder().applicationTestModule(ApplicationTestModule(application)).build()
        application.component = mTestComponent as ApplicationComponent
    }

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                try {
                    setupDaggerTestComponentInApplication()
                    base.evaluate()
                } finally {
                    mTestComponent = null
                }
            }
        }
    }
}
