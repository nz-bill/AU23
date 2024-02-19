//
//  ContentView.swift
//  jsonExempel
//
//  Created by Bill Palmestedt on 2024-02-19.
//

import SwiftUI

struct ContentView: View {
    
    let dataManager = DataManager()
    
    
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("Hello, world!")
            Button("test"){
                test()
            }
        }
        .padding()
    }
    
    func test(){
        
        dataManager.saveObjectToUserDefaults()
        dataManager.loadObjectFromDataInUserDefaults()
        dataManager.loadObjectFromStringInUserDfaults()
    }
}

#Preview {
    ContentView()
}
