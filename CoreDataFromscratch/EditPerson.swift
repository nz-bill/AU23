//
//  EditPerson.swift
//  CoreDataFromscratch
//
//  Created by Bill Palmestedt on 2024-02-12.
//

import SwiftUI

struct EditPerson: View {
    
    var entity: Person
     @ObservedObject var viewModel: PersonViewModel
    
    @State var name: String = ""
    @State var age: String = ""
    
    var body: some View {
        TextField("new name", text: $name)
            .padding()
        
        TextField("new age", text: $age)
            .padding()
        Button("update person"){
            if name.isEmpty || age.isEmpty{
                return
            }
            
            viewModel.updatePerson(entity: entity, newName: name, newAge: Int(age) ?? 0)
            age = ""
            name = ""
          
        }
        .padding()
        .background(.blue)
        .foregroundColor(.white)
        .cornerRadius(20)
        
        Text(entity.name ?? "no name")
        Text(String(entity.age) )
    }
}


