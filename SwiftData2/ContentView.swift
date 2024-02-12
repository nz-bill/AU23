//
//  ContentView.swift
//  SwiftData2
//
//  Created by Bill Palmestedt on 2024-02-12.
//

import SwiftUI
import SwiftData

struct ContentView: View {
    
    @Environment(\.modelContext) var context
    @Query var persons: [Person]
    
    @State var age: String = ""
    @State var name: String = ""
    
    var body: some View {
        VStack {
            TextField("name", text: $name)
                .padding()
            TextField("age", text: $age)
                .padding()
            Button("add Person"){
                addPerson()
            }
            List{
                ForEach(persons){ person in
                    VStack{
                        Text("\(person.name), \(person.age)")
                        Button("update"){
                            updatePerson(person: person)
                        }
                    }
                    
                    
                }
                .onDelete(perform: { indexSet in
                    for index in indexSet {
                        deletePerson(person: persons[index])
                    }
                })
            }
        }
        .padding()
    }
    
    
    func addPerson(){
        let newPerson = Person(name: name, age: Int(age) ?? 0)
        
        context.insert(newPerson)
        name = ""
        age = ""
    }
    
    func deletePerson(person: Person){
        context.delete(person)
    }
    
    func updatePerson(person: Person){
        person.name = name
        person.age = Int(age) ?? 0
        
        do{
            try  context.save()
        } catch let error{
            print(error)
        }
        
        name = ""
        age = ""
       
    }
}

#Preview {
    ContentView().modelContainer(for: Person.self, inMemory: true)
}
