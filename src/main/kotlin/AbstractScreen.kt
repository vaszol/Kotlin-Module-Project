import java.util.Scanner

abstract class AbstractScreen {
    private val scanner = Scanner(System.`in`)
    internal val map: MutableMap<String, AbstractScreen> = HashMap()

    fun start() {
        while (true) {
            showMenu()
            when (val cmd = scanner.nextLine().trim().toIntOrNull()) {
                0 -> return
                1 -> addElement()
                in 2..map.keys.size + 1 -> setOfElement(cmd)
                else -> println("ожидается цифра из меню")
            }
        }
    }

    private fun showMenu() {
        println(showMenuStartFormatString())
        map.keys.toList().forEachIndexed { i, s ->
            println(showMenuElementFormatString(i, s))
        }
        println("0. Выход ")
    }

    private fun addElement() {
        while (true) {
            println(addElementStartFormatString())
            val name = scanner.nextLine()
            if (name == "0") return
            if (name.isEmpty()) continue
            if (map.keys.none { s -> s.lowercase() == name.lowercase() }) {
                addElementByType(name)
                return
            } else {
                println(addElementContainsNameFormatString())
                return
            }
        }
    }

    abstract fun setOfElement(cmd: Int?)
    abstract fun showMenuStartFormatString(): Any
    abstract fun showMenuElementFormatString(i: Int, s: String): Any
    abstract fun addElementStartFormatString(): Any
    abstract fun addElementContainsNameFormatString(): Any
    abstract fun addElementByType(name: String)
}