package com.famlabs

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http

object Server extends App {

  implicit val system = ActorSystem()

  val service = system.actorOf(Props[BiddingService], "bidding-service")

//  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)

  IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)
}
