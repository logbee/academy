package server

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.{SelectionKey, Selector, ServerSocketChannel, SocketChannel}
import java.nio.charset.StandardCharsets
import scala.jdk.CollectionConverters.*


@main
def server(): Unit = {

  val selector = Selector.open()

  val serverSocket = ServerSocketChannel.open()
  serverSocket.bind(InetSocketAddress("0.0.0.0", 4711))
  serverSocket.configureBlocking(false)
  serverSocket.register(selector, SelectionKey.OP_ACCEPT)

  val buffer = ByteBuffer.allocate(1024)

  while (true) {
    selector.select()
    val selectedKeys = selector.selectedKeys()
    for (key <- selectedKeys.asScala) {
      if (key.isAcceptable) {
        register(selector, serverSocket)
      }
      if (key.isReadable) {
        echo(buffer, key)
      }
      selectedKeys.remove(key)
    }
  }
}

def register(selector: Selector, serverSocket: ServerSocketChannel): Unit = {
  println("registering new client")
  val client = serverSocket.accept()
  client.configureBlocking(false)
  client.register(selector, SelectionKey.OP_READ)
  println("new client registered")
}

def echo(buffer: ByteBuffer, key: SelectionKey): Unit = {
  val client = key.channel().asInstanceOf[SocketChannel]
  client.read(buffer)
  buffer.flip()
  val message = String(buffer.array(), StandardCharsets.UTF_8).trim
  println(s"received message: $message")
  println("echoing...")
  client.write(buffer)
  buffer.clear()
}
