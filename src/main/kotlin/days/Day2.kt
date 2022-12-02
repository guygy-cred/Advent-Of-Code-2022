package days

class Day2 : Day(2) {
    override fun partOne(): Any {
        var score = 0
        for(round in inputList){
            when (round) {
                "A X" -> score += 4
                "A Y" -> score += 8
                "A Z" -> score += 3
                "B X" -> score += 1
                "B Y" -> score += 5
                "B Z" -> score += 9
                "C X" -> score += 7
                "C Y" -> score += 2
                "C Z" -> score += 6
            }
        }
        return score
    }

    override fun partTwo(): Any {
        var score = 0

        for(round in inputList) {
            when (round) {
                "A X" -> score += 3
                "A Y" -> score += 4
                "A Z" -> score += 8
                "B X" -> score += 1
                "B Y" -> score += 5
                "B Z" -> score += 9
                "C X" -> score += 2
                "C Y" -> score += 6
                "C Z" -> score += 7
            }
        }
        return score
    }

}