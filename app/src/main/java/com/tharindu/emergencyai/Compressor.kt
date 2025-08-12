object Compressor {
    // Simple replacement compression
    private val replaceMap = mapOf(
        "EMERGENCY" to "E",
        "Location" to "L",
        "Reason" to "R",
        "Please send help immediately." to "H"
    )

    fun compress(message: String): String {
        var compressed = message
        for ((key, value) in replaceMap) {
            compressed = compressed.replace(key, value)
        }
        return compressed
    }

    fun decompress(compressed: String): String {
        var message = compressed
        for ((key, value) in replaceMap) {
            message = message.replace(value, key)
        }
        return message
    }
}
