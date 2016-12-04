package org.scalajs.google

import org.scalajs.dom.raw.{Document, HTMLElement, Window}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobalScope

/**
  * Created by johann on 11/25/16.
*/

@js.native
@JSGlobalScope
object GoogleAnalytics extends js.Object {
  def ga(command: String, parameters: js.Object): Unit = js.native
}

class Analytics(trackingId: String, cookieDomain: Option[String] = None,
                name: Option[String] = None, transport: Option[String] = None) {



  //ga('create', [trackingId], [cookieDomain], [name], [fieldsObject]);
  GoogleAnalytics.ga("create",
    js.Dynamic.literal(
      trackingId = trackingId,
      cookieDomain = cookieDomain.getOrElse(null),
      name = name.getOrElse(null),
      transport = transport.getOrElse(null)
    )
  )


  //ga('[trackerName.]send', [hitType], [...fields], [fieldsObject]);
  def pageView(trackerName: Option[String] = None, db: Option[String] = None) = {
    GoogleAnalytics.ga(s"${trackerName.map(_ + ".").getOrElse("")}send",
      js.Dynamic.literal(
        hitType = "pageview",
        dp = db.getOrElse(null)
      )
    )
  }

  //ga('send', 'event', [eventCategory], [eventAction], [eventLabel], [eventValue], [fieldsObject]);
  def event(eventCategory: String, eventAction: String, eventLabel: Option[String] = None, eventValue: Option[Integer] = None): Unit =
    GoogleAnalytics.ga("send",  js.Dynamic.literal(
      hitType = "event",
      eventCategory = eventCategory,
      eventAction = eventAction,
      eventLabel = eventLabel.getOrElse(null),
      eventValue = eventValue.getOrElse(null)
    ))

}
