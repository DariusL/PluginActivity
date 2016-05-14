package lt.dariusl.pluginactivity;

import android.view.Menu;
import android.view.MenuItem;

public interface ActivityPlugin {
    boolean onCreateOptionsMenu(Menu menu);
    boolean onOptionsItemSelected(MenuItem item);
}
