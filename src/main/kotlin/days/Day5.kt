package days

class Day5 : Day(5){

    override fun partOne(): Any {
        val crates = mutableListOf("GTRW", "GCHPMSVW", "CLTSGM", "JHDMWRF", "PQLHSWFJ", "PJDNFMS", "ZBDFGCSJ", "RTB", "HNWLC")
       for(instruction in inputList){
           val instructions = splitInstructionString(instruction)
           val crateToMove = crates[instructions[1] - 1].takeLast(instructions[0]).reversed()
           crates[instructions[2] - 1] = crates[instructions[2] - 1] + crateToMove
           crates[instructions[1] - 1] = crates[instructions[1] - 1].dropLast(instructions[0])
       }
        return crates.toString()
    }

    override fun partTwo(): Any {
        val crates = mutableListOf("GTRW", "GCHPMSVW", "CLTSGM", "JHDMWRF", "PQLHSWFJ", "PJDNFMS", "ZBDFGCSJ", "RTB", "HNWLC")
        for(instruction in inputList){
            val instructions = splitInstructionString(instruction)
            val crateToMove = crates[instructions[1] - 1].takeLast(instructions[0])
            crates[instructions[2] - 1] = crates[instructions[2] - 1] + crateToMove
            crates[instructions[1] - 1] = crates[instructions[1] - 1].dropLast(instructions[0])
        }
        return crates.toString()
    }

    private fun splitInstructionString(instruction: String): List<Int>{
        return instruction.split("move ", " from ", " to ").let {
            listOf(it[1].toInt(), it[2].toInt(), it[3].toInt())
        }
    }

}