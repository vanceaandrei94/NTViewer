package com.unbm.andrei.ntviewer.plugins.activities.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei.vancea on 2/27/2017.
 */

public class PluginActivity extends AppCompatActivity {

    private List<Plugin> plugins = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        for (Plugin plugin : plugins) {
            plugin.beforeOnCreate(savedInstanceState);
        }
        super.onCreate(savedInstanceState);
        for (Plugin plugin : plugins) {
            plugin.afterOnCreate(savedInstanceState);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        for (Plugin plugin : plugins) {
            plugin.beforeOnNewIntent(intent);
        }
        super.onNewIntent(intent);
        for (Plugin plugin : plugins) {
            plugin.afterOnNewIntent(intent);
        }
    }

    public void addPlugin(Plugin plugin) {
        plugins.add(plugin);
    }
}
