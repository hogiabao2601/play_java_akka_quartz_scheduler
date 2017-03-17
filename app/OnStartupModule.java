import com.google.inject.AbstractModule;

/**
 * Created by wilson on 3/17/17.
 */
public class OnStartupModule extends AbstractModule {
    @Override
    public void configure() {
        bind(OnStartup.class).asEagerSingleton();
    }
}
