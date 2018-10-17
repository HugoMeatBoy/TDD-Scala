package bowling

import scala.collection.mutable.ListBuffer

class Bowling{
    val NB_PINS = 10;
    var rolls = ListBuffer[Tuple2[Int,Int]]()

    def roll(result: Tuple2[Int, Int]){
        rolls += result
    }

    def score():Int={
        scoreTest(rolls.toList)
    }


    def scoreTest(r : List[Tuple2[Int,Int]], score: Int = 0, frame: String = "Regular",lastFrame: String = "Regular", index :Int = 0):Int={
        if(index > 9 || r.tail == Nil){
            var res = r.head._1 + r.head._2

            if(r.tail != Nil){
                scoreTest(r.tail, score+res, "Regular", frame, index)
            }else{
                score+res
            }

        }else{
            var x = 1
            var y = 1
            frame match{
                case "Strike" => {
                    x = 2
                    if(lastFrame == "Strike"){
                        x = 3
                    }
                    y = 2
                }
                case "Spare" => x = 2
                case _ => {}
            }



            var res = r.head._1 * x + r.head._2 * y


            if(r.head._1 == 10){
                scoreTest(r.tail, score+res, "Strike", frame, index+1)

            }else if(r.head._1 + r.head._2 == 10){
                scoreTest(r.tail, score+res, "Spare", frame, index+1)

            }else{
                scoreTest(r.tail, score+res, "Regular", frame, index+1)
            }
        }
    }
}
