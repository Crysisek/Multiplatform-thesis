import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        KoinHelperKt.doInitKoin(uiViewControllerFactory: UIViewControllerFactoryImpl())
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
