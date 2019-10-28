package dk.nodes.nstack.demo

import dk.nodes.nstack.kotlin.NStack

/**
 * generated by nstack gradle plugin on Mon Oct 28 10:24:08 CET 2019
 */
object RateReminderActions {

	private const val FIRSTACTION = "firstaction"
	private const val SECONDACTION = "secondaction"

	suspend fun firstaction() {
		send(FIRSTACTION)
	}

	suspend fun secondaction() {
		send(SECONDACTION)
	}

	private suspend fun send(action: String) {
		NStack.RateReminder.action(action)
	}
}
