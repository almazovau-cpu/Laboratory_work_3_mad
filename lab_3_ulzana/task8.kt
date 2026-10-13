package com.example.mablab3.lab3

open class Assessment(val title: String, val maxPoints: Int) {
    init {
        require(title.isNotBlank()) { "Title cannot be blank" }
        require(maxPoints > 0) { "Max points must be > 0" }
    }

    open fun scoreTowardGrade(raw: Int): Double {
        val safeRaw = raw.coerceIn(0, maxPoints)
        return safeRaw.toDouble() / maxPoints
    }
}

class Quiz(title: String, maxPoints: Int, val penaltyIfLate: Double) : Assessment(title, maxPoints) {
    init {
        require(penaltyIfLate in 0.0..0.5) { "Penalty must be between 0.0 and 0.5" }
    }

    override fun scoreTowardGrade(raw: Int): Double {
        val baseScore = super.scoreTowardGrade(raw)
        return baseScore * (1.0 - penaltyIfLate)
    }
}

class Project(title: String, maxPoints: Int, val bonusCap: Double) : Assessment(title, maxPoints) {
    init {
        require(bonusCap >= 0.0) { "Bonus cap must be >= 0" }
    }

    override fun scoreTowardGrade(raw: Int): Double {
        val baseScore = super.scoreTowardGrade(raw)
        if (raw > maxPoints) {
            val extraPoints = raw - maxPoints
            val bonusRatio = extraPoints.toDouble() / maxPoints
            val allowedBonus = bonusRatio.coerceAtMost(bonusCap)
            return baseScore + allowedBonus
        }
        return baseScore
    }
}