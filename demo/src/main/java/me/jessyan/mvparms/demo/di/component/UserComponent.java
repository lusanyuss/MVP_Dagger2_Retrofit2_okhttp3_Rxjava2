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
package me.jessyan.mvparms.demo.di.component;

import com.yuliu.di.component.AppComponent;
import com.yuliu.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;
import me.jessyan.mvparms.demo.di.module.UserModule;
import me.jessyan.mvparms.demo.mvp.contract.UserContract;
import me.jessyan.mvparms.demo.mvp.ui.activity.UserActivity;

/**
 * ================================================
 * 展示 Component 的用法
 * ================================================
 */
@ActivityScope
@Component(modules = UserModule.class, dependencies = AppComponent.class)
public interface UserComponent {
    void inject(UserActivity activity);
    @Component.Builder
    interface Builder {
        @BindsInstance
        UserComponent.Builder view(UserContract.View view);
        UserComponent.Builder appComponent(AppComponent appComponent);
        UserComponent build();
    }
}
