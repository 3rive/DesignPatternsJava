package com.threerive.patterns.facade;

/** Facade provides a single entry point to a home theater subsystem. */
public final class HomeTheaterFacade {

  private final Projector projector = new Projector();
  private final Amplifier amplifier = new Amplifier();
  private final DvdPlayer dvdPlayer = new DvdPlayer();

  public String watchMovie(String movie) {
    projector.on();
    projector.wideScreenMode();
    amplifier.on();
    amplifier.setVolume(5);
    dvdPlayer.on();
    dvdPlayer.play(movie);
    return "Watching " + movie;
  }
}
