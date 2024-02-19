class NoteScreen(
    private val name: String
) : AbstractScreen() {
    override fun setOfElement(cmd: Int?) {
        println("'Что записано пером, то не вырубить топором'\nредактор строк в следующих версиях))")
    }

    override fun showMenuStartFormatString(): Any {
        return "\nЗаметка '$name' \nВыберите номер команды\n1. Добавить текст"
    }

    override fun showMenuElementFormatString(i: Int, s: String): Any {
        return s
    }

    override fun addElementStartFormatString(): Any {
        return "\nдобавить строку или 0 для выхода"
    }

    override fun addElementContainsNameFormatString(): Any {
        return "такой текст уже существует"
    }

    override fun addElementByType(name: String) {
        map[name] = NoteScreen(name = name)
    }
}