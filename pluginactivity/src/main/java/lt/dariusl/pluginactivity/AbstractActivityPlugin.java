package lt.dariusl.pluginactivity;

import android.view.Menu;
import android.view.MenuItem;

public class AbstractActivityPlugin implements ActivityPlugin{
    private ActivityPlugin next;

    void setNext(ActivityPlugin next) {
        this.next = next;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return next.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return next.onOptionsItemSelected(item);
    }
}
