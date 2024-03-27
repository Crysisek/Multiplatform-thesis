package pl.edu.pb.androidnativeapp.navigation

sealed class Destination(val route: String) {

    data object Home : Destination("home_route")

    data object InfiniteList : Destination("infinite_list_route?data_source_type={$DATA_SOURCE_ARGUMENT}",) {
        override fun passArgument(argument: String): String {
            return super.passArgument(argument, DATA_SOURCE_ARGUMENT)
        }
    }

    data object Hardware : Destination("hardware_route") {
        data object Camera : Destination("hardware_camera_route")
        data object Gps : Destination("hardware_gps_route")
        data object Sensor : Destination("hardware_sensor_route") {
            data object Accelerometer : Destination("hardware_sensor_accelerometer_route")
            data object Light : Destination("hardware_sensor_light_route")

            val testSubjectDestinations = listOf(Accelerometer, Light)
        }

        val testSubjectDestinations = listOf(Camera, Gps, Sensor)
    }

    data object FileDecoding : Destination("file_decoding_route")

    data object Animation : Destination("animation_route")

    data object Database : Destination("database_route") {
        data object Save : Destination("database_save_route")
        data object Retrieve : Destination("database_retrieve_route")

        val testSubjectDestinations = listOf(Save, Retrieve)
    }

    protected fun passArgument(argument: String, key: String): String {
        return this.route.replace(oldValue = "{$key}", newValue = argument)
    }

    /** By default return [route] */
    open fun passArgument(argument: String): String = route

    companion object {
        val testSubjectDestinations = listOf(InfiniteList, Hardware, Database, Animation, FileDecoding)
        const val DATA_SOURCE_ARGUMENT = "data_source_type"
    }
}

val Destination.name: String
    get() = route.substringBefore("route").replace('_', ' ').uppercase()
