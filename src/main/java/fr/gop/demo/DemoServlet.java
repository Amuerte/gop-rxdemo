package fr.gop.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

import rx.functions.Action1;

public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final Logger LOG = LoggerFactory.getLogger(DemoServlet.class);

	@Inject
	RxService demoService = GuiceListener.get().getInstance(RxService.class);

	public DemoServlet() {
	}

	protected void doGet(HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		response.getWriter()
		        .append("Served at: ")
		        .append(request.getContextPath())
		        .append("\n");

//		try {
//			response.getWriter().append(demoService.createSentence());
//		} catch (Exception e) {
//			LOG.error("Proccessing Sentence error", e);
//		}
		
		try {
			demoService.createRxSentence().subscribe(new Action1<String>() {
				@Override
				public void call(String word) {
					try {
						response.getWriter().append(word);
					} catch (IOException e) {
						LOG.error("Error while writing response", e);
					}
				}
			});
		} catch (Exception e) {
			LOG.error("Proccessing Sentence error", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
