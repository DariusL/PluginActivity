package lt.dariusl.pluginactivity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashSet;
import java.util.Set;

public class PluginActivity extends AppCompatActivity {
    private final Set<ActivityPlugin> plugins = new HashSet<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean display = false;
        for (ActivityPlugin plugin : plugins){
            display |= plugin.onCreateOptionsMenu(menu);
        }
        display |= super.onCreateOptionsMenu(menu);
        return display;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        for (ActivityPlugin plugin : plugins){
            if (plugin.onOptionsItemSelected(item)){
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        onViewChange();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChange();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        onViewChange();
    }

    private void onViewChange(){
        View view = getWindow().getDecorView();
        for (ActivityPlugin plugin : plugins){
            plugin.onViewChange(view);
        }
    }

    public void plugin(ActivityPlugin plugin) {
        plugins.add(plugin);
    }
}
