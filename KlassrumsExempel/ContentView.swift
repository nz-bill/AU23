//
//  ContentView.swift
//  KlassrumsExempel
//
//  Created by Bill Palmestedt on 2024-02-14.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
            Text("Hello, world!")
        }
        .padding()
    }
    
    /// Adds two numbers and returns the sum
    /// - Parameters:
    ///     - a: the first integer.
    ///     - b: the second integer.
    ///     - Returns:
    ///     returns the sum of a and b as an iteger
    func addNumbers(a: Int, b: Int) -> Int{
        return a + b
    }
    
    func returnSquared(number: Int) -> Int{
        return number * number
    }
    
    func divideNumbers(a: Int, b:Int) -> Double{
        let aDouble = Double(a)
        let bDouble = Double(b)
        
        return Double(aDouble/bDouble)
    }
    
}

#Preview {
    ContentView()
}
