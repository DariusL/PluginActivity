package lt.dariusl.pluginactivity;

import android.view.Menu;
import android.view.MenuItem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.fakes.RoboMenuItem;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.*;

@RunWith(RobolectricGradleTestRunner.class)
public class PluginActivityTest {

    public @Rule MockitoRule mockitoRule = MockitoJUnit.rule();
    private @Mock ActivityPlugin plugin;

    @Test
    public void testMenuCallbacks() throws Exception {

        ActivityController<PluginActivity> controller = Robolectric.buildActivity(PluginActivity.class);
        PluginActivity activity = controller.get();

        activity.plugin(plugin);
        controller.setup();

        Mockito.verify(plugin).onCreateOptionsMenu(Mockito.any(Menu.class));

        MenuItem item = new RoboMenuItem();
        activity.onOptionsItemSelected(item);

        Mockito.verify(plugin).onOptionsItemSelected(item);
    }
}