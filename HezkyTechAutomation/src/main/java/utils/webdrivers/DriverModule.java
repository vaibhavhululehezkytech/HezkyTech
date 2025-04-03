package utils.webdrivers;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class DriverModule extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(DriverManager.class)
		.to(ChromeBrowser.class)
		.in(Scopes.SINGLETON);
		
	}

}
