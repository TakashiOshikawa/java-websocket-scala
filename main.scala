import java.net.InetSocketAddress;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

// connectionsで取得したjavaのcollectionをScalaで扱えるようにする
import collection.JavaConversions._


object SimpleServer {

  def main(args: Array[String]): Unit = {
    val host: String = "localhost"
    val port: Int = 9000

    var server: WebSocketServer = new MyWebSocketServer(new InetSocketAddress(host, port))
    server.run()
  }

}

class MyWebSocketServer(address: InetSocketAddress) extends WebSocketServer(address) {

  override def onOpen(conn: WebSocket, handshake: ClientHandshake): Unit = {
    println("connection open!!")
  }

  override def onMessage(conn: WebSocket, message: String): Unit = {
    println("messsssssage")
    var con = connections()
    
    for ( c <- con ) {
      c.send(message)
    }
  }

  override def onClose(conn: WebSocket, code: Int, reason: String, remote: Boolean): Unit = {
    println("clooooooooooooose")
  }

  override def onError(conn: WebSocket, e: Exception): Unit = {
    println(conn.getRemoteSocketAddress())
    println("errrrrrrrrrrrrrrrrrrorrrr")
  }

}
