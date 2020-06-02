package net.afterday.compas.engine.engine.system.influence.extractor

import net.afterday.compas.engine.common.Time
import net.afterday.compas.engine.engine.system.influence.anomaly.AnomalyEvent
import net.afterday.compas.engine.sensors.SensorResult
import java.util.*
import kotlin.collections.HashMap

class ByMacExtractionStrategy(private val letters: HashMap<String, Int>) {
    private var calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))

    fun extract(value: SensorResult): AnomalyEvent?{
        val letter = value.id?.substring(0, 2)
        if (letters.containsKey(letter))
        {
            return AnomalyEvent(
                    value.id,
                    (letters[letter]!!),
                    value.value,
                    null,
                    Time.now

            )
        }
        return null
    }
}