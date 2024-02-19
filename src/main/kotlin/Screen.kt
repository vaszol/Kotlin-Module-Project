import java.util.Scanner

class Screen(
    private val scanner: Scanner,
    private val name: String,
    private val type: Type?
) {
    private val map: MutableMap<String, Screen> = HashMap()
    fun start() {
        while (true) {
            showMenu()
            when (val cmd = scanner.nextLine().trim().toIntOrNull()) {
                0 -> return
                1 -> addElement()
                in 2..map.keys.size + 1 ->
                    if (type == Type.NOTE)
                        println("'Что записано пером, то не вырубить топором'\nредактор строк в следующих версиях))")
                    else if (cmd != null && cmd - 2 < map.keys.toList().size)
                        map[map.keys.toList()[cmd - 2]]?.start()

                else -> println("ожидается цифра из меню")
            }
        }
    }

    private fun showMenu() {
        when (type) {
            Type.ARCHIVE -> println("\nСписок заметок архива '$name' \nВыберите номер команды\n1. Создать заметку")
            Type.NOTE -> println("\nЗаметка '$name' \nВыберите номер команды\n1. Добавить текст")
            else -> println("\nСписок архивов\nВыберите номер команды\n1. Создать архив")
        }
        map.keys.toList().forEachIndexed { i, s ->
            when (type) {
                Type.ARCHIVE -> println("${i + 2}. Открыть заметку '$s'")
                Type.NOTE -> println(s)
                else -> println("${i + 2}. Открыть архив '$s'")
            }
        }
        println("0. Выход ")
    }

    private fun addElement() {
        while (true) {
            when (type) {
                Type.ARCHIVE -> println("\nВведите название заметки или 0 для выхода")
                Type.NOTE -> println("\nдобавить строку или 0 для выхода")
                else -> println("\nВведите название архива или 0 для выхода")
            }
            val name = scanner.nextLine()
            if (name == "0") return
            if (name.isEmpty()) continue
            if (map.keys.none { s -> s.lowercase() == name.lowercase() }) {
                when (type) {
                    Type.ARCHIVE -> map[name] = Screen(scanner, name, Type.NOTE)
                    else -> map[name] = Screen(scanner, name, Type.ARCHIVE)
                }
                return
            } else {
                when (type) {
                    Type.ARCHIVE -> println("заметка с таким названием уже существует")
                    Type.NOTE -> println("такой текст уже существует")
                    else -> println("архив с таким названием уже существует")
                }
                return
            }
        }
    }
}