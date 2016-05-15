package lt.dariusl.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import lt.dariusl.pluginactivity.ActivityPluginAdapter;
import lt.dariusl.pluginactivity.PluginActivity;

public class MenuButtonActivity extends PluginActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        plugin(new MenuPlugin(this));
        plugin(new ToolbarPlugin(this));
    }

    private static class MenuPlugin extends ActivityPluginAdapter {

        private final AppCompatActivity activity;

        private MenuPlugin(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            activity.getMenuInflater().inflate(R.menu.menu_sample, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == R.id.menu_sample) {
                Toast.makeText(activity, "Plugin button clicked!", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                return false;
            }
        }
    }

    static class ToolbarPlugin extends ActivityPluginAdapter {

        private final AppCompatActivity activity;

        @Bind(R.id.toolbar)
        Toolbar toolbar;

        private ToolbarPlugin(AppCompatActivity activity) {
            this.activity = activity;
        }

        @Override
        public void onViewChange(View view) {
            ButterKnife.bind(this, view);
            activity.setSupportActionBar(toolbar);
            setupToolbar(toolbar);
        }

        // override to customize the toolbar after setup
        protected void setupToolbar(Toolbar toolbar){}
    }
}
