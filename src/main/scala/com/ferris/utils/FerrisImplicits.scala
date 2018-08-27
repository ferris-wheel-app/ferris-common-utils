package com.ferris.utils

import java.sql.{Date, Time, Timestamp}
import java.time.{LocalDate, LocalDateTime, LocalTime, ZoneId}
import java.util.UUID

import scala.language.implicitConversions

object FerrisImplicits {
  implicit class LocalDateTimeOps(time: LocalDateTime) {
    def toLong: Long = time.atZone(ZoneId.systemDefault()).toInstant.toEpochMilli
    def toTimestamp: Timestamp = new Timestamp(time.toLong)
  }

  implicit class LocalDateOps(date: LocalDate) {
    def toSqlDate: Date = Date.valueOf(date)
  }

  implicit class LocalTimeOps(time: LocalTime) {
    def toSqlTime: Time = Time.valueOf(time)
  }

  implicit def uuid2String(uuid: UUID): String = uuid.toString

  implicit def uuid2String(uuid: Option[UUID]): Option[String] = uuid.map(_.toString)

  implicit def uuid2String(uuid: Seq[UUID]): Seq[String] = uuid.map(_.toString)

  implicit def localDate2SqlDate(date: LocalDate): Date = Date.valueOf(date)

  implicit def byte2Boolean(byte: Byte): Boolean = byte == 1

  implicit def boolean2Byte(bool: Boolean): Byte = if (bool) 1 else 0
}
