//
//  SwiftData2App.swift
//  SwiftData2
//
//  Created by Bill Palmestedt on 2024-02-12.
//

import SwiftUI
import SwiftData

@main
struct SwiftData2App: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
        .modelContainer(for: Person.self)
        
    }
}
