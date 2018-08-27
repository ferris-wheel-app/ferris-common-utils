package com.ferris.utils

import java.sql.{Date, Timestamp}
import java.time.{LocalDate, LocalDateTime, ZoneId}

object FerrisImplicits {
  implicit class LocalDateTimeOps(time: LocalDateTime) {
    def toLong: Long = time.atZone(ZoneId.systemDefault()).toInstant.toEpochMilli
    def toTimestamp: Timestamp = new Timestamp(time.toLong)
  }

  implicit class LocalDateOps(date: LocalDate) {
    def toSqlDate: Date = Date.valueOf(date)
  }
}
