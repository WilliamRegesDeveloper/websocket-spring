package br.com.gmartins;

import java.time.LocalDate;

public class OutputMessage {

  private String from;
  private String text;
  private String now;

  public OutputMessage(String from, String text, String now) {
    this.from = from;
    this.text = text;
    this.now = now;
  }
}
