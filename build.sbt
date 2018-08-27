name := "ferris-common-utils"

organization := "com.ferris"

version := "0.0.4"

scalaVersion := "2.12.1"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val scalaTestV                  = "3.0.1"
  val mockitoV                    = "1.10.19"
  Seq(
    "org.scalatest" %% "scalatest"   % scalaTestV,
    "org.mockito"   %  "mockito-all" % mockitoV
  )
}
