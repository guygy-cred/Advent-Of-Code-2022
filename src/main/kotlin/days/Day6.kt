package days

class Day6 : Day(6){

    override fun partOne(): Any {
        return indexOfMarker(4)
    }

    override fun partTwo(): Any {
        return indexOfMarker(14)
    }

    private fun indexOfMarker(messageLength : Int) : Int {
        var found = 0
        for(i in 0..inputString.length - messageLength){
            if(inputString.substring(i, i + messageLength).allUnique()){
                found = i + messageLength
                break
            }
        }
        return found
    }

    private fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)

}