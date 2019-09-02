package br.com.gmartins;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args){
      try {
        Socket socket = new Socket("localhost", 8080);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}
