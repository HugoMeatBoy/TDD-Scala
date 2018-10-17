package bowling

import org.scalatest.FunSuite
import org.scalacheck.Gen
import org.scalacheck.Prop.forAll

class BowlingSpec extends FunSuite{

    test("All tries : 0 pins") {
        val game = new Bowling
        //Ten frames played
        game.roll((0,0)); game.roll((0,0)); game.roll((0,0)); game.roll((0,0)); game.roll((0,0));
        game.roll((0,0)); game.roll((0,0)); game.roll((0,0)); game.roll((0,0)); game.roll((0,0));

        assert(game.score === 0)
      }


      test("All tries : 1 pin") {
          val game = new Bowling
          //Ten frames played
          game.roll((1,1)); game.roll((1,1)); game.roll((1,1)); game.roll((1,1)); game.roll((1,1));
          game.roll((1,1)); game.roll((1,1)); game.roll((1,1)); game.roll((1,1)); game.roll((1,1));

          assert(game.score === 20)
        }



        test("All tries : Strike") {
            val game = new Bowling
            game.roll((10,0)); game.roll((10,0)); game.roll((10,0)); game.roll((10,0)); game.roll((10,0));
            game.roll((10,0)); game.roll((10,0)); game.roll((10,0)); game.roll((10,0));

            //10th FRAME : 1st and 2nd rolls
            game.roll((10,10))

            //12 frame
            game.roll((10,0))


            assert(game.score === 300)
          }

          test("10 tries : 5-Spare, Final : Strike") {
              val game = new Bowling
              game.roll((5,5))
              game.roll((5,5))
              game.roll((5,5))
              game.roll((5,5))
              game.roll((5,5))
              game.roll((5,5))
              game.roll((5,5))
              game.roll((5,5))
              game.roll((5,5))
              game.roll((5,5))
              game.roll((10,0))
              assert(game.score === 155)
            }


            test("9 tries : Strike, 10th : Spare") {
                val game = new Bowling
                game.roll((10,0));game.roll((10,0));game.roll((10,0));game.roll((10,0));game.roll((10,0));
                game.roll((10,0));game.roll((10,0));game.roll((10,0));game.roll((10,0));

                game.roll((9,1));
                game.roll((5,0));


                assert(game.score === 255)
              }
/*
            var r1 : Gen[Int] = for(n <- Gen.choose(0,10)) yield n
            var r2 : Gen[Int] = Gen.choose(0,10)
            def randomlast(first: Int) : Gen[Int] = Gen.choose(0,10-first)


            forAll(r1, r2) { (x: Int, y: Int) =>
                whenever(true) {
                    println(x)
                }
            }
*/

}
