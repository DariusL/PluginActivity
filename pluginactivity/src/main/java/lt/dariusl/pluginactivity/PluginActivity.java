package lt.dariusl.pluginactivity;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class PluginActivity extends AppCompatActivity {

    private ActivityPlugin head = new TerminalActivityPlugin(this);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return head.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return head.onOptionsItemSelected(item);
    }

    boolean onCreateOptionsMenuInternal(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    boolean onOptionsItemSelectedInternal(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void plugin(AbstractActivityPlugin plugin) {
        ActivityPlugin last = head;
        plugin.setNext(last);
        head = plugin;
    }
}
