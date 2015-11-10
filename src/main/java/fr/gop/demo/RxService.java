package fr.gop.demo;

import rx.Observable;

public interface RxService {
	
	String createSentence() throws Exception;

	Observable<String> createRxSentence() throws Exception;

}
