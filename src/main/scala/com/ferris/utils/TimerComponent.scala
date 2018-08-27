package com.ferris.utils

import java.sql.Timestamp
import java.time.LocalDate

import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar

trait TimerComponent {
  def timer: Timer

  trait Timer {
    def now: Long
    def timestampOfNow: Timestamp
    def today: LocalDate
  }
}

trait DefaultTimerComponent extends TimerComponent {
  val timer: Timer = Timer

  private object Timer extends Timer {
    override def now: Long = System.currentTimeMillis
    override def timestampOfNow: Timestamp = new Timestamp(now)
    override def today: LocalDate = LocalDate.now
  }
}

trait MockTimerComponent extends TimerComponent with MockitoSugar {
  override val timer: Timer = mock[Timer]
  when(timer.timestampOfNow).thenReturn(new Timestamp(System.currentTimeMillis))
  when(timer.now).thenReturn(System.currentTimeMillis)
  when(timer.today).thenReturn(LocalDate.now)
}
