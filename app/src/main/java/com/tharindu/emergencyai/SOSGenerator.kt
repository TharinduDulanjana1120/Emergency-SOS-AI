package com.tharindu.emergencyai

object SOSGenerator {
    fun generateSOS(reason: String, location: String): String {
        return "🚨 EMERGENCY ALERT 🚨\nReason: $reason\nLocation: $location\nPlease send help immediately!"
    }
}
