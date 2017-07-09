package nolambda.jsoup.example

import org.jsoup.Jsoup

fun main(args: Array<String>) {
    parseHackerNews()
}

fun parseHackerNews() {
    Jsoup.connect("https://news.ycombinator.com/").get().run {
        println(title())
        select("td a.storylink").forEachIndexed { index, element ->
            println("$index.${element.text()} (${element.attr("href")})")
        }
    }
}