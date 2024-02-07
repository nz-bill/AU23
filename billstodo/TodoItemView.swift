//
//  TodoItemView.swift
//  billstodo
//
//  Created by Bill Palmestedt on 2024-02-07.
//

import SwiftUI

struct TodoItemView: View {
    @State var todoItem: TodoItem
    
    var body: some View {
        HStack{
            Text(todoItem.title)
                
            Spacer()
            Image(systemName: todoItem.isCompleted ? "checkmark.square" : "square")
                
        }
        .padding()
        .onTapGesture {
            self.todoItem.isCompleted.toggle()
        }
        
    }
}

#Preview {
    TodoItemView(todoItem: TodoItem(title: "Title", isCompleted: true))
}
