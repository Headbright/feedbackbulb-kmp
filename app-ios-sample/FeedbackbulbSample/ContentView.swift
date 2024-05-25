//
//  ContentView.swift
//  FeedbackbulbSample
//
//  Created by Konstantin Kostov on 25/05/2024.
//

import SwiftUI
import FeedbackbulbCoreSDK

struct ContentView: View {
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("Hello, world!")
            Button("Send", action: {
                Task {
                    try? await sendFeedback()
                }
            })
        }
        .padding()
    }
    
    func sendFeedback() async throws {
        let client = FeedbackSDKClient(appKey: "01b7f627-37c0-43f8-8815-2d730f55134b")
        
        
        let _ = try await client.sendFeedback(content: "Hello from iOS using Kotlin Multiplatform")
    }
}

#Preview {
    ContentView()
}
