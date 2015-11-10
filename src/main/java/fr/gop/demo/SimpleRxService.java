package fr.gop.demo;

import com.google.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

public class SimpleRxService implements RxService {
	
	@Inject
	RemoteApi remoteApi;

	@Override
	public String createSentence() throws Exception {
		final StringBuilder sentence = new StringBuilder(10);
		
		for (int i = 0; i <10; i++) {
			sentence.append(remoteApi.query()).append(" ");
		}
		
		return sentence.toString();
	}

	@Override
	public Observable<String> createRxSentence() throws Exception {
		return Observable.from(new Integer[] {1,2,3,4,5,6,7,8,9,10})
		        .map(new Func1<Integer, String>() {

			        @Override
			        public String call(Integer arg) {
				        try {
					        return remoteApi.query() + " ";
				        } catch (Exception e) {
					        e.printStackTrace();
				        }

				        return "#";
			        }
		        });
	}
}
