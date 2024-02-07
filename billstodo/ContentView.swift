//
//  ContentView.swift
//  billstodo
//
//  Created by Bill Palmestedt on 2024-02-07.
//

import SwiftUI

struct ContentView: View {
    
    var todoItems = [
    TodoItem(title: "vakna", isCompleted: true),
    TodoItem(title: "ät frukost", isCompleted: false),
    TodoItem(title: "gå till skolan", isCompleted: false)
    ]
    
    var body: some View {
        VStack {
            Text("Min coola todo app")
                .font(.title)
                .padding()
            
            List(todoItems, id: \.id) { item in
                TodoItemView(todoItem: item)
            }
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
