package lt.dariusl.pluginactivity;

import android.view.Menu;
import android.view.MenuItem;

class TerminalActivityPlugin implements ActivityPlugin {
    private final PluginActivity activity;

    public TerminalActivityPlugin(PluginActivity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return activity.onCreateOptionsMenuInternal(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return activity.onOptionsItemSelectedInternal(item);
    }
}
