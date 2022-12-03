package days

class Day3 : Day(3) {

    override fun partOne(): Any {
        return inputList.map{it.chunked(it.length / 2)}
            .map {it[0].toSet() intersect it[1].toSet()}
            .flatten()
            .sumOf{ convertCharacterToValue(it) }
    }
    override fun partTwo(): Any {
        return inputList.windowed(3, 3)
            .map{it[0].toSet() intersect it[1].toSet() intersect it[2].toSet()}
            .flatten()
            .sumOf{convertCharacterToValue(it)}
    }

    private fun convertCharacterToValue(char: Char): Int {
        return if(char.isLowerCase()){
            char.code - 'a'.code + 1
        } else {
            char.code - 'A'.code + 27
        }
    }

}