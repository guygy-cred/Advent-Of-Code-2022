package days

class Day7 : Day(7) {
    override fun partOne(): Any {
        returnDirectories()
        return directories.filter { it.size <= 100000 }.sumOf { it.size }
    }

    override fun partTwo(): Any {
        return directories.filter { it.size >= 30000000 - (70000000 - rootDirectory.size) }.minOf { it.size }
    }

    class Directory(
        val name: String,
        val parent: Directory?,
        val children: MutableMap<String, Directory> = mutableMapOf(),
        var size: Int = 0
    )

    private val rootDirectory = Directory("/", null)
    private val directories = mutableListOf(rootDirectory)

    private fun returnDirectories(): List<Directory>{

        var currentDirectory = rootDirectory

        inputList.drop(1).forEach {
            if (it.startsWith("dir")) {
                val childName = it.substring(4, it.length)
                currentDirectory.children[childName] = addChildToCurrentDirectory(childName, currentDirectory)
            }
            if (it.startsWith("$ cd")) {
                currentDirectory = updateCurrentDirectory(currentDirectory, it.substring(5, it.length))
            }
            if (it[0].isDigit()) {
                addToParent(currentDirectory, it.split(" ")[0].toInt())
            }
        }
        return directories
    }



    private fun addChildToCurrentDirectory(childName: String, currentDirectory : Directory) : Directory {
        val newChild = Directory(childName, currentDirectory)
        directories.add(newChild)
        return newChild
    }

    private fun addToParent(parent: Directory, valueToAdd: Int) {
        parent.size += valueToAdd
        if (parent.parent != null) {
            addToParent(parent.parent, valueToAdd)
        }
    }

    private fun updateCurrentDirectory(currentDirectory: Directory, name: String): Directory {
        return if (name == "..") {
            currentDirectory.parent!!
        } else {
            currentDirectory.children.getValue(name)
        }
    }
}

