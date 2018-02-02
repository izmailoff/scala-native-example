import scala.io.Source
import scala.io.Codec
import java.nio.charset.CodingErrorAction
import java.io.File

object WC extends App {

  val decoder = Codec.UTF8.decoder.onMalformedInput(CodingErrorAction.IGNORE)
  val bufferSize = 8192
  val file = new File(args(0))
  val count = Source.fromFile(file, bufferSize)(decoder).count(_ == '\n')
  println(s"Number of lines: $count")
}
