package LogsDemo;

import org.apache.logging.log4j.*;

public class LogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Logger log = LogManager.getLogger("LogTest");
		
		System.out.println("This is logger demo");
		
		log.info("for info only");
		log.debug("for debug");
		log.error("for error");
		log.warn("warning message");
	}

}
