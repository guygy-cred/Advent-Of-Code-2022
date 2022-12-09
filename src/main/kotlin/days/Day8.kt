package days

class Day8 : Day(8) {
    override fun partOne(): Any {
        val testList = mutableListOf<String>(
            "30373",
            "25512",
            "65332",
            "33549",
            "35390"
        )
        var totalVisible = 2 * inputList[0].length + 2 * inputList.size - 4
        val inputMap = inputList.map { it.toList().map { it } }
        val horizontalLength = inputMap[0].size - 1
        val verticalLength = inputMap.size - 1
        println(horizontalLength)
        println(verticalLength)
        for (i in 1 until verticalLength) {
            for (j in 1 until horizontalLength) {
                var left = false
                var right = false
                var up = false
                var down = false
                val columnValue = inputMap[i][j]

                //Handle Left
                if (inputMap[i].subList(0, j).count { it >= columnValue } > 0) {
                    left = true
                }

                //Handle Right
                if (inputMap[i].subList(j + 1, horizontalLength + 1).count { it >= columnValue } > 0) {
                    right = true
                }

                for (k in 0 until i) {
                    if (inputMap[k][j] >= columnValue) {
                        up = true
                        break
                    }
                }
                for (k in i + 1 .. verticalLength) {
                    if (inputMap[k][j] >= columnValue) {
                        down = true
                        break
                    }
                }

                print(left)
                print(right)
                print(up)
                print(down)
                println()
                if (!left || !down || !up || !right) {
                    totalVisible++
                }
            }
        }
        return (totalVisible)
    }

    override fun partTwo(): Any {
        val testList = mutableListOf<String>(
            "30373",
            "25512",
            "65332",
            "33549",
            "35390"
        )
        var currentHighestScenicScore = -1
        val inputMap = inputList.map { it.toList().map { it } }
        val horizontalLength = inputMap[0].size - 1
        val verticalLength = inputMap.size - 1
        for (i in 0 .. verticalLength) {
            for (j in 0 .. horizontalLength) {
                val columnValue = inputMap[i][j]
                var leftScore = 0
                var rightScore = 0
                var upScore = 0
                var downScore = 0

                for(k in j - 1 downTo 0){
                    leftScore++
                    if (inputMap[i][k] >= columnValue) {
                        break
                    }
                }

                for(k in j + 1  until horizontalLength + 1){
                    rightScore++
                    if (inputMap[i][k] >= columnValue) {
                        break
                    }
                }

                for (k in i - 1 downTo 0) {
                    upScore++
                    if (inputMap[k][j] >= columnValue) {
                        break
                    }
                }
                for (k in i + 1 .. verticalLength) {
                    downScore++
                    if (inputMap[k][j] >= columnValue) {
                        break
                    }
                }
                val newScore = leftScore * rightScore * upScore * downScore
                if(newScore > currentHighestScenicScore ){
                    currentHighestScenicScore = newScore
                }
            }
        }
        return (currentHighestScenicScore)
    }


}