fun main() {
    val name = "Alex"
    val time = 880

    println(agoToText(name, time))
}

fun agoToText(name: String, seconds: Int): String {
    val template = "$name был(а) "

    return when (seconds) {
        in 0..60 -> template + "только что"
        in 61..(60 * 60) -> template + minutesAgo(seconds)
        in (60 * 60 + 1)..(24 * 60 * 60) -> template + hoursAgo(seconds)
        in (24 * 60 * 60 + 1)..(2 * 24 * 60 * 60) -> template + "вчера"
        in (2 * 24 * 60 * 60 + 1)..(3 * 24 * 60 * 60) -> template + "позавчера"
        else -> template + "давно"
    }
}

fun minutesAgo(seconds: Int): String {
    val correctMinutes = "минут"
    val secToMin = seconds / 60

    return when {
        secToMin % 10 == 1 && secToMin % 100 != 11 -> "$secToMin ${correctMinutes}у назад"
        secToMin % 10 in 2..4 && secToMin % 100 > 20 -> "$secToMin ${correctMinutes}ы назад"
        else -> "$secToMin $correctMinutes назад"
    }
}

fun hoursAgo(seconds: Int): String {
    val correctHours = "час"
    return when (val secToHours = seconds / 3600) {
        in 2..4, in 21..24 -> "$secToHours ${correctHours}a назад"
        in 5..20 -> "$secToHours ${correctHours}ов назад"
        else -> "$secToHours $correctHours назад"
    }
}