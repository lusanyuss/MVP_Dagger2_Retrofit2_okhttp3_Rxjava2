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
package com.yuliu.integration;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.yuliu.base.delegate.AppLifecycles;
import com.yuliu.di.module.GlobalConfigModule;

import java.util.List;

/**
 * ================================================
 * { ConfigModule} 可以给框架配置一些参数,需要实现 { ConfigModule} 后,在 AndroidManifest 中声明该实现类
 * ================================================
 */
public interface ConfigModule {
    /**
     * 使用 { GlobalConfigModule.Builder} 给框架配置一些配置参数
     *
     * @param context { Context}
     * @param builder { GlobalConfigModule.Builder}
     */
    void applyOptions(@NonNull Context context, @NonNull GlobalConfigModule.Builder builder);

    /**
     * 使用 { AppLifecycles} 在 { Application} 的生命周期中注入一些操作
     *
     * @param context    { Context}
     * @param lifecycles { Application} 的生命周期容器, 可向框架中添加多个 { Application} 的生命周期类
     */
    void injectAppLifecycle(@NonNull Context context, @NonNull List<AppLifecycles> lifecycles);

    /**
     * 使用 { Application.ActivityLifecycleCallbacks} 在 { Activity} 的生命周期中注入一些操作
     *
     * @param context    { Context}
     * @param lifecycles { Activity} 的生命周期容器, 可向框架中添加多个 { Activity} 的生命周期类
     */
    void injectActivityLifecycle(@NonNull Context context, @NonNull List<Application.ActivityLifecycleCallbacks> lifecycles);

    /**
     * 使用 { FragmentManager.FragmentLifecycleCallbacks} 在 { Fragment} 的生命周期中注入一些操作
     *
     * @param context    { Context}
     * @param lifecycles { Fragment} 的生命周期容器, 可向框架中添加多个 { Fragment} 的生命周期类
     */
    void injectFragmentLifecycle(@NonNull Context context, @NonNull List<FragmentManager.FragmentLifecycleCallbacks> lifecycles);
}
