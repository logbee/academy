package client

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SocketChannel
import java.nio.charset.{Charset, StandardCharsets}


@main
def client(): Unit = {

  val client = SocketChannel.open(new InetSocketAddress("localhost", 4711))
  val buffer = ByteBuffer.allocate(1024)

  while (true) {
    print("Enter message: ")
    val message = Console.in.readLine()
    buffer.put(message.getBytes(StandardCharsets.UTF_8))
    buffer.flip()
    client.write(buffer)
    buffer.clear()
    client.read(buffer)
    val response = String(buffer.array()).trim
    println(s"Response: $response")
    buffer.clear()
  }
}
