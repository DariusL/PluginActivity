package lt.dariusl.pluginactivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.fakes.RoboMenuItem;
import org.robolectric.util.ActivityController;

import static org.mockito.Mockito.*;

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

        verify(plugin).onCreateOptionsMenu(any(Menu.class));

        MenuItem item = new RoboMenuItem();
        activity.onOptionsItemSelected(item);

        verify(plugin).onOptionsItemSelected(item);
    }

    @Test
    @SuppressWarnings("ResourceType")
    public void testViewCallbacks() throws Exception {
        ActivityController<PluginActivity> controller = Robolectric.buildActivity(PluginActivity.class);
        PluginActivity activity = controller.get();

        activity.plugin(plugin);
        controller.setup();
        View view = new View(activity);
        view.setId(500);
        activity.setContentView(view);

        verify(plugin).onViewChange(argThat(new ArgumentMatcher<View>() {
            @Override
            public boolean matches(Object argument) {
                return ((View) argument).findViewById(500) != null;
            }
        }));
    }
}