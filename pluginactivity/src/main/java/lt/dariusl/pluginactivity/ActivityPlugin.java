package lt.dariusl.pluginactivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public interface ActivityPlugin {
    boolean onCreateOptionsMenu(Menu menu);
    boolean onOptionsItemSelected(MenuItem item);
    void onViewChange(View view);
}
