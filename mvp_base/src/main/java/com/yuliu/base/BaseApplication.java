/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yuliu.base;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.yuliu.base.delegate.AppDelegate;
import com.yuliu.base.delegate.AppLifecycles;
import com.yuliu.di.component.AppComponent;
import com.yuliu.utils.ArmsUtils;
import com.yuliu.utils.Preconditions;

/**
 * ================================================
 * MVP + Dagger2 + Retrofit2 + RxJava2 项目
 * ================================================
 */
public class BaseApplication extends Application implements com.yuliu.base.App {
    private AppLifecycles mAppDelegate;

    /**
     * 这里会在 { BaseApplication#onCreate} 之前被调用,可以做一些较早的初始化
     * 常用于 MultiDex 以及插件化框架的初始化
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        if (mAppDelegate == null)
            this.mAppDelegate = new AppDelegate(base);
        this.mAppDelegate.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mAppDelegate != null)
            this.mAppDelegate.onCreate(this);
    }

    /**
     * 在模拟环境中程序终止时会被调用
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mAppDelegate != null)
            this.mAppDelegate.onTerminate(this);
    }

    /**
     * 将 { AppComponent} 返回出去, 供其它地方使用, { AppComponent} 接口中声明的方法所返回的实例, 在 { #getAppComponent()} 拿到对象后都可以直接使用
     *
     * @return AppComponent
     * @see ArmsUtils#obtainAppComponentFromContext(Context) 可直接获取 { AppComponent}
     */
    @NonNull
    @Override
    public AppComponent getAppComponent() {
        Preconditions.checkNotNull(mAppDelegate, "%s cannot be null", AppDelegate.class.getName());
        Preconditions.checkState(mAppDelegate instanceof com.yuliu.base.App, "%s must be implements %s", mAppDelegate.getClass().getName(), com.yuliu.base.App.class.getName());
        return ((com.yuliu.base.App) mAppDelegate).getAppComponent();
    }
}
