package fr.gop.demo;

import com.google.inject.AbstractModule;

public class RxDemoServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(RemoteApi.class).to(RemoteApiTest.class);
		bind(RxService.class).to(SimpleRxService.class);
	}
}
