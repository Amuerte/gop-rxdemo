package fr.gop.demo;

import javax.servlet.ServletContextListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Application Lifecycle Listener implementation class GuiceListener
 *
 */
public class GuiceListener extends GuiceServletContextListener implements ServletContextListener {
	
	private static Injector injector;

    public GuiceListener() {
    }

	@Override
	protected Injector getInjector() {
		injector = Guice.createInjector(new RxDemoServiceModule());
		return injector;
	}
	
	public static Injector get() {
		return injector;
	}

}
