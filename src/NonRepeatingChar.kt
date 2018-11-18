class NonRepeatingChar {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var nrc = NonRepeatingChar()
            println(nrc.firstNonRepeatingChar("kotlintok"))
        }
    }

    fun getCharCount(word: String): HashMap<Char, CountIndex> {
        val charCount = LinkedHashMap<Char, CountIndex>()
        for (i in word.toCharArray().indices) {
            var countIndex: CountIndex = charCount.getOrDefault(word[i], CountIndex())
            if (countIndex.index == -1) countIndex.index = i
            countIndex.incCount()
            charCount[word[i]] = countIndex
        }
        return charCount
    }

    fun firstNonRepeatingChar(word: String): String {
        if (word.isEmpty()) return "Empty String"
        val charCounts = getCharCount(word)
        for (charCount: CountIndex in charCounts.values) {
            if (charCount.count == 1) return word[charCount.index].toString()
        }
        return "All chars are repeating"
    }

}

class CountIndex(var count: Int = 0,
                 var index: Int = -1) {

    fun incCount() {
        count++
    }

    override fun toString(): String {
        return "CountIndex(count=$count, index=$index)"
    }

}

fun main(args: Array<String>) {
    var nrc = NonRepeatingChar()
    println(nrc.getCharCount("kotlinok"))
}