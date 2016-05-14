package lt.dariusl.pluginactivity;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

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

    public void plugin(ActivityPlugin plugin) {
        plugins.add(plugin);
    }
}
