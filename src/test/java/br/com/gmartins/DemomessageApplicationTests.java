package br.com.gmartins;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemomessageApplicationTests {

	@Test
	public void contextLoads() {

		try {
			Socket socket = new Socket("localhost", 8080);
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
