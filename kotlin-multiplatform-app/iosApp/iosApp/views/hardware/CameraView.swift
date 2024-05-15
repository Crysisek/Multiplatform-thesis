//
//  CameraView.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 27/04/2024.
//

import SwiftUI
import AVKit
import AVFoundation


struct CameraView: View {
    @State private var isShowingCamera = false
    @State private var image: UIImage?

    var body: some View {
        VStack {
            if let image = image {
                Image(uiImage: image)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
            } else {
                Text("Brak obrazu z kamery")
            }
            Button("Otwórz kamerę") {
                self.isShowingCamera.toggle()
            }
        }
        .sheet(isPresented: $isShowingCamera) {
            CameraViewController(image: self.$image)
        }
    }
}

struct CameraViewController: UIViewControllerRepresentable {
    @Binding var image: UIImage?
    @Environment(\.presentationMode) var presentationMode

    func makeUIViewController(context: Context) -> some UIViewController {
        let cameraViewController = UIImagePickerController()
        cameraViewController.delegate = context.coordinator
        cameraViewController.sourceType = .camera
        return cameraViewController
    }

    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}

    func makeCoordinator() -> Coordinator {
        Coordinator(parent: self)
    }

    class Coordinator: NSObject, UIImagePickerControllerDelegate, UINavigationControllerDelegate {
        let parent: CameraViewController

        init(parent: CameraViewController) {
            self.parent = parent
        }

        func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
            if let pickedImage = info[.originalImage] as? UIImage {
                parent.image = pickedImage
            }
            parent.presentationMode.wrappedValue.dismiss()
        }

        func imagePickerControllerDidCancel(_ picker: UIImagePickerController) {
            parent.presentationMode.wrappedValue.dismiss()
        }
    }
}

#Preview {
    CameraView()
}
