object SOSGenerator{
    fun generateSOS(reason: String, location: String, extra: String = ""): String{
        return """
            🚨 EMERGENCY 🚨
            Reason: $reason
            Location : $location
            $extra
            Please send help immediately.
            """".trimIndent()
    }
}