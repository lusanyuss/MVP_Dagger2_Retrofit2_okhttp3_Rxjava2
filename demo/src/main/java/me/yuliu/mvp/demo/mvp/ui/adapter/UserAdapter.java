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
package me.yuliu.mvp.demo.mvp.ui.adapter;

import android.support.annotation.NonNull;
import android.view.View;

import com.yuliu.base.BaseHolder;
import com.yuliu.base.DefaultAdapter;

import java.util.List;

import me.jessyan.mvparms.demo.R;
import me.yuliu.mvp.demo.mvp.model.entity.User;
import me.yuliu.mvp.demo.mvp.ui.holder.UserItemHolder;

/**
 * ================================================
 * 展示 { DefaultAdapter} 的用法
 * ================================================
 */
public class UserAdapter extends DefaultAdapter<User> {

    public UserAdapter(List<User> infos) {
        super(infos);
    }

    @NonNull
    @Override
    public BaseHolder<User> getHolder(@NonNull View v, int viewType) {
        return new UserItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.recycle_list;
    }
}
