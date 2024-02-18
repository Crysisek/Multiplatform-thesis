package pl.edu.pb.androidnativeapp.navigation

sealed class Destinations(val route: String) {

    data object Home : Destinations("home_route")

    data object InfiniteList : Destinations("infinite_list_route") {
        val routeWithArgument = "$route?data_source_type={data_source_type}"
    }

    data object Hardware : Destinations("hardware_route") {
        data object Camera : Destinations("hardware_camera_route")
        data object Gps : Destinations("hardware_gps_route")
        data object Bluetooth : Destinations("hardware_bluetooth_route")
        data object Nfc : Destinations("hardware_nfc_route")

        val testSubjectDestinations = listOf(Camera, Gps, Bluetooth, Nfc)
    }

    data object FileDecoding : Destinations("file_decoding_route")

    data object Animation : Destinations("animation_route")

    data object Database : Destinations("database_route") {
        data object Save : Destinations("database_save_route")
        data object Retrieve : Destinations("database_retrieve_route")

        val testSubjectDestinations = listOf(Save, Retrieve)
    }

    companion object {
        val testSubjectDestinations = listOf(InfiniteList, Hardware, Database, Animation, FileDecoding)
    }
}

val Destinations.name: String
    get() = route.substringBefore('/').substringBeforeLast('_').replace('_', ' ').uppercase()
