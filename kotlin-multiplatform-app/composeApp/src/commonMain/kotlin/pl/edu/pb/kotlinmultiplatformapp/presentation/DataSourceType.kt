package pl.edu.pb.kotlinmultiplatformapp.presentation

enum class DataSourceType(val param: String) {
    LOCAL("local_data_source"), NETWORK("network_data_source");

    companion object {
        fun ofParam(param: String) = entries.first { it.param == param }
    }
}
