class ArchiveScreen(
    private val name: String
) : AbstractScreen() {

    override fun setOfElement(cmd: Int?) {
        if (cmd != null && cmd - 2 < map.keys.toList().size)
            map[map.keys.toList()[cmd - 2]]?.start()
    }

    override fun showMenuStartFormatString(): Any {
        return "\nСписок заметок архива '$name' \nВыберите номер команды\n1. Создать заметку"
    }

    override fun showMenuElementFormatString(i: Int, s: String): Any {
        return "${i + 2}. Открыть заметку '$s'"
    }

    override fun addElementStartFormatString(): Any {
        return "\nВведите название заметки или 0 для выхода"
    }

    override fun addElementContainsNameFormatString(): Any {
        return "заметка с таким названием уже существует"
    }

    override fun addElementByType(name: String) {
        map[name] = NoteScreen(name = name)
    }
}