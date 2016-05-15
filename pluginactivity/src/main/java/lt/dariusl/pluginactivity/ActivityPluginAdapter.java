package lt.dariusl.pluginactivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ActivityPluginAdapter implements ActivityPlugin {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onViewChange(View view) {

    }
}
