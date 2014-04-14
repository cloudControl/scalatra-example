package sifue.scalatra

import org.scalatra._
import scalate.ScalateSupport

class MyScalatraServlet extends ScalatraServlet with ScalateSupport {

  get("/") {
    <html>
    <head>
        <link href='css/helloworld.css' rel='stylesheet' type='text/css'/>
        <title>Hello World in Scala</title>
    </head>
    <body>
        <strong>Hello world, I'm a Scala app running on cloudControl!</strong>
      <footer>
        Coming from the <a href="https://www.cloudcontrol.com/dev-center/Quickstart">Quickstart</a>?
        Check out <a href="https://www.cloudcontrol.com/dev-center/Guides/Java/Scala%20-%20HelloWorld">the explanation</a>.
      </footer>
    </body>
    </html>
  }

  notFound {
    // Try to render a ScalateTemplate if no route matched
    findTemplate(requestPath) map { path =>
      contentType = "text/html"
      layoutTemplate(path)
    } orElse serveStaticResource() getOrElse resourceNotFound()
  }
}
