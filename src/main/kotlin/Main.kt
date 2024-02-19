import java.util.Scanner

fun main() {
    println("Приложение «Заметки»")
    val scanner = Scanner(System.`in`)
    Screen(scanner, "", null).start()
    println("До свидания!")
}