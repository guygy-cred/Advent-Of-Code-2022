package days

class Day1 : Day(1) {

    override fun partOne(): Any {
        var highestElf = 0
        var currentElf = 0
        for(input in inputList){
            if(input != ""){
                currentElf += Integer.parseInt(input)
            } else {
                if(currentElf > highestElf){
                    highestElf = currentElf
                }
                currentElf = 0
            }
        }
        return highestElf
    }

    override fun partTwo(): Any {
        var highestElves = mutableListOf<Int>()
        var currentElf = 0

        for(input in inputList){
            if(input != ""){
                currentElf += Integer.parseInt(input)
            } else {
                if(highestElves.size < 3){
                    highestElves.add(currentElf)
                } else {
                    highestElves.sort()
                    if(currentElf > highestElves[0]){
                        highestElves[0] = currentElf
                    }
                }
                currentElf = 0
            }
        }

        return highestElves[0] + highestElves[1] + highestElves[2]
    }
}
