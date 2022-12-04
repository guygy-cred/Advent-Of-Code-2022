package days

class Day4  : Day(4){
    private val elfSets = inputList.map{
        val values = it.split(',', '-').map{it.toInt() }
        (values[0]..values[1]).toSet() to (values[2]..values[3]).toSet()
    }

    override fun partOne(): Any {
            return elfSets.count { (elf1, elf2) -> elf1 intersect elf2 == elf1 || elf1 intersect elf2 == elf2 }
    }

    override fun partTwo(): Any {
        return elfSets.count { (elf1, elf2) -> (elf1 intersect elf2).isNotEmpty() }
    }

}