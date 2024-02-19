class FirstScreen : AbstractScreen() {

    override fun setOfElement(cmd: Int?) {
        if (cmd != null && cmd - 2 < map.keys.toList().size)
            map[map.keys.toList()[cmd - 2]]?.start()
    }

    override fun showMenuStartFormatString(): Any {
        return "\nСписок архивов\nВыберите номер команды\n1. Создать архив"
    }

    override fun showMenuElementFormatString(i: Int, s: String): Any {
        return "${i + 2}. Открыть архив '$s'"
    }

    override fun addElementStartFormatString(): Any {
        return "\nВведите название архива или 0 для выхода"
    }

    override fun addElementContainsNameFormatString(): Any {
        return "архив с таким названием уже существует"
    }

    override fun addElementByType(name: String) {
        map[name] = ArchiveScreen(name = name)
    }
}
