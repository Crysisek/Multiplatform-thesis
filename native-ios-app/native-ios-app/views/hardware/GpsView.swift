//
//  GpsView.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 21/04/2024.
//

import SwiftUI
import CoreLocation
import Foundation

class LocationManager: NSObject, ObservableObject {
    private let locationManager = CLLocationManager()
    @Published var location: CLLocation? = nil
    
    override init() {
        super.init()
        self.locationManager.delegate = self
        self.locationManager.desiredAccuracy = kCLLocationAccuracyBest
        self.locationManager.distanceFilter = kCLDistanceFilterNone
        self.locationManager.requestWhenInUseAuthorization()
        self.locationManager.startUpdatingLocation()
    }
    
}

extension LocationManager: CLLocationManagerDelegate {
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        guard let location = locations.last else {
            return
        }
        self.location = location
    }
}

struct GpsView: View {
    @ObservedObject private var locationManager = LocationManager()

        
        var body: some View {
            
            let coordinate = self.locationManager.location != nil
            ? self.locationManager.location!.coordinate : CLLocationCoordinate2D()
            
            return HStack {
                Text("Latitude: \(coordinate.latitude)")
                Text("Longtitude: \(coordinate.longitude)")
            }
        }
}

#Preview {
    GpsView()
}
